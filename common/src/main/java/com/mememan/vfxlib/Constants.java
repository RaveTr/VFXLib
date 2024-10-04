package com.mememan.vfxlib;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class Constants {
	public static final String MODID = "vfxlib";
	public static final String MOD_NAME = "VFX Lib";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(MODID, path.toLowerCase(Locale.ROOT));
	}
}