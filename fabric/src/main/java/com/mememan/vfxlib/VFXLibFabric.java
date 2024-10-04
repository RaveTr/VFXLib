package com.mememan.vfxlib;

import net.fabricmc.api.ModInitializer;

public class VFXLibFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        VFXLib.initialize();
    }
}
