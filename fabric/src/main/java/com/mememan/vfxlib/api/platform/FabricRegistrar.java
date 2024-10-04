package com.mememan.vfxlib.api.platform;

import com.mememan.vfxlib.api.asm.annotations.RegistrarEntry;
import com.mememan.vfxlib.api.platform.services.IRegistrar;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FabricRegistrar implements IRegistrar {

    @Override
    public void setupRegistrar() {
        VFXLServices.PLATFORM.discoverAnnotatedClasses(RegistrarEntry.class);
    }

    @Override
    public <V, T extends V> Supplier<T> registerObject(ResourceLocation objId, Supplier<T> objSup, Registry<V> targetRegistry) {
        T targetObject = Registry.register(targetRegistry, objId, objSup.get());
        return () -> targetObject;
    }
}