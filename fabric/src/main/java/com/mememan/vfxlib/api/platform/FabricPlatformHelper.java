package com.mememan.vfxlib.api.platform;

import com.mememan.vfxlib.VFXLConstants;
import com.mememan.vfxlib.api.asm.ClassFinder;
import com.mememan.vfxlib.api.loader.ModLoader;
import com.mememan.vfxlib.api.loader.ModPathWrapper;
import com.mememan.vfxlib.api.platform.services.IPlatformHelper;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public ModLoader getPlatform() {
        return ModLoader.FABRIC;
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public List<Class<?>> discoverAnnotatedClasses(Class<? extends Annotation> annotationTypeClazz) {
        return getFilteredAvailableClasses(annotationTypeClazz);
    }

    @Override
    public ModPathWrapper getModPathWrapper() {
        return new ModPathWrapper(() -> FabricLoader.getInstance().getGameDir()) {

            @Override
            public Path getOrCreatePath(Path nestedPath) { // I love copying from Neo/Forge for stuff that should already be standard :smiling_face_with_3_hearts:
                Path gameFolderPath = FabricLoader.getInstance().getGameDir().resolve(nestedPath);

                if (!Files.isDirectory(gameFolderPath)) {
                    try {
                        Files.createDirectories(gameFolderPath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                return gameFolderPath;
            }
        };
    }

    protected static List<Class<?>> getFilteredAvailableClasses(Class<? extends Annotation> annotationTypeClazz) { // I'm sorry (CBF to set up compile-time annotations ATM)
        ObjectArrayList<Class<?>> filteredClasses = new ObjectArrayList<>();

        FabricLoader.getInstance().getAllMods().stream()
                .map(ModContainer::getOrigin) // getRootPaths() is completely useless, returns weird ahh paths consisting of a singular "/" or null :sob:
                .flatMap(curOrigin -> curOrigin.getPaths().stream())
                .map(Path::toString)
                .forEach(pathString -> {
                    if (pathString.endsWith(".jar")) { // Check if the path is pointing to a JAR file for separate handling
                        try (JarFile jarFile = new JarFile(pathString)) {
                            jarFile.stream()
                                    .map(JarEntry::getName)
                                    .filter(name -> name.endsWith(".class"))
                                    .filter(name -> hasAnnotation(annotationTypeClazz, name, true, jarFile))
                                    .map(ClassFinder::forName)
                                    .forEach(filteredClasses::add);
                        } catch (IOException e) {
                            VFXLConstants.LOGGER.error("Failed to initialize JarFile for: {}", pathString, e);
                        }
                    } else if (Files.isDirectory(Paths.get(pathString))) { // Check if the path is pointing to a directory for standard directory walking (basically only useful in the dev env for project files inside the build/ dir) (we do be walking) (memory cardio :trol:)
                        try (Stream<Path> allExistingPaths = Files.walk(Paths.get(pathString))) {
                            allExistingPaths.filter(Files::isRegularFile)
                                    .filter(curPath -> curPath.toString().endsWith(".class"))
                                    .filter(curPath -> hasAnnotation(annotationTypeClazz, Paths.get(pathString).relativize(curPath).toString().replace(File.separatorChar, '.').replace(".class", ""), false, null))
                                    .map(curPath -> ClassFinder.forName(Paths.get(pathString).relativize(curPath).toString().replace(File.separatorChar, '.').replace(".class", "")))
                                    .forEach(filteredClasses::add);
                        } catch (IOException e) {
                            VFXLConstants.LOGGER.error("Failed to walk path: {}", pathString, e);
                        }
                    } else if (pathString.endsWith(".class")) { // I mean, how/why would you even get to this point?
                        if (hasAnnotation(annotationTypeClazz, pathString, false, null)) {
                            filteredClasses.add(ClassFinder.forName(pathString.replace(File.separatorChar, '.').replace(".class", "")));
                        }
                    }
                });

        return filteredClasses;
    }

    private static boolean hasAnnotation(Class<? extends Annotation> annotationTypeClazz, String targetClassName, boolean processForJar, @Nullable JarFile targetJar) {
        final boolean[] foundValidAnnotation = {false}; // I love atomic handling
        ClassReader reader;

        try {
            if (processForJar && targetJar != null) {
                JarEntry curEntry = targetJar.getJarEntry(targetClassName);

                if (curEntry == null) return false;

                try (InputStream jarInputStream = targetJar.getInputStream(curEntry)) {
                    reader = new ClassReader(jarInputStream);
                } catch (IOException e) {
                    VFXLConstants.LOGGER.error("Failed to initialize JarInputStream for: {}", targetClassName, e);
                    return false;
                }
            } else reader = new ClassReader(targetClassName);
        } catch (IOException e) {
            VFXLConstants.LOGGER.error("Failed to initialize ClassReader for: {}", targetClassName, e);
            return false;
        }

        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM9) {

            @Override
            public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                if (Type.getDescriptor(annotationTypeClazz).equals(desc)) foundValidAnnotation[0] = true;
                return super.visitAnnotation(desc, visible);
            }
        };
        reader.accept(visitor, 0);

        return foundValidAnnotation[0];
    }
}
