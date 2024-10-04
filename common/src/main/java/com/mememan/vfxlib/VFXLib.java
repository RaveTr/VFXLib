package com.mememan.vfxlib;

import com.mememan.vfxlib.api.asm.annotations.LoadEarly;
import com.mememan.vfxlib.api.loader.ModLoader;
import com.mememan.vfxlib.api.platform.VFXLServices;

public class VFXLib {

    /**
     * The main method responsible for initializing pretty much all Chaos Awakens content and whatnot.
     */
    public static void initialize() {
        VFXLServices.PLATFORM.discoverAnnotatedClasses(LoadEarly.class);

        VFXLServices.REGISTRAR.setupRegistrar();

        if (VFXLServices.PLATFORM.getPlatform().equals(ModLoader.FABRIC)) VFXLServices.NETWORK_MANAGER.setupNetworkHandler();
    }

    /**
     * Method for some tasks that generally need to be deferred to a specific mod-loading stage (Primarily for Forge/NeoForge).
     */
    public static void deferredSetup() {
        VFXLServices.NETWORK_MANAGER.setupNetworkHandler();
    }
}