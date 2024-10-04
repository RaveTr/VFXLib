package com.mememan.vfxlib.api.platform;

import com.mememan.vfxlib.api.asm.ClassFinder;
import com.mememan.vfxlib.api.loader.ModLoader;
import com.mememan.vfxlib.api.platform.services.IPlatformHelper;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public ModLoader getPlatform() {
        return ModLoader.FORGE;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public List<Class<?>> discoverAnnotatedClasses(Class<? extends Annotation> annotationTypeClazz) {
        return ModList.get().getAllScanData().stream()
                .flatMap(scanData -> scanData.getAnnotations().stream())
                .filter(annotationData -> Objects.equals(annotationData.annotationType(), Type.getType(annotationTypeClazz)))
                .map(ModFileScanData.AnnotationData::clazz)
                .map(Type::getClassName)
                .map(ClassFinder::forName)
                .collect(Collectors.toCollection(ObjectArrayList::new));
    }
}