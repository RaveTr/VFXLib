package com.mememan.vfxlib;

import net.minecraftforge.fml.common.Mod;

@Mod(VFXLConstants.MODID)
public class VFXLibForge {
    
    public VFXLibForge() {
        VFXLib.initialize();
    }
}