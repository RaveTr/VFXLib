package com.mememan.vfxlib;

import com.google.common.base.Suppliers;
import com.mememan.vfxlib.api.platform.VFXLServices;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.function.Supplier;

public class VFXLConstants {
	public static final String MODID = "vfxlib";
	public static final String MOD_NAME = "VFXLib";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static final Supplier<File> ROOT_VFXLIB_DIR = Suppliers.memoize(() -> VFXLServices.PLATFORM.getModPathWrapper().getOrCreatePath(Path.of("vfxlib")).toFile());

	public static final File WORKING_DIR = new File(ROOT_VFXLIB_DIR.get(), "working"); // Basically the directory for the files currently being edited, if any (session locks, etc.)
	public static final File BACKUPS_DIR = new File(ROOT_VFXLIB_DIR.get(), "backups"); // Whenever a save is made (if enabled in settings), takes a snapshot of the current editing session and stores it in this directory
	public static final File SAVES_DIR = new File(ROOT_VFXLIB_DIR.get(), "saved"); // All saved elements in their current state are stored in this directory

	public static final File CUTSCENES_DIR = new File(SAVES_DIR, "cutscenes");

	public static final File FX_DIR = new File(SAVES_DIR, "effects");
	public static final File VFX_DIR = new File(FX_DIR, "vfx");
	public static final File SFX_DIR = new File(FX_DIR, "sfx");

	public static final File ASSETS_DIR = new File(SAVES_DIR, "assets");
	public static final File ENTITY_ASSETS_DIR = new File(ASSETS_DIR, "entity");
	public static final File BLOCK_ASSETS_DIR = new File(ASSETS_DIR, "block");
	public static final File ITEM_ASSETS_DIR = new File(ASSETS_DIR, "item");

	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(MODID, path.toLowerCase(Locale.ROOT));
	}
}