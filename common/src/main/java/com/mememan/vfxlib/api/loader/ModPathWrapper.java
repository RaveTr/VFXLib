package com.mememan.vfxlib.api.loader;

import com.mememan.vfxlib.api.platform.VFXLServices;
import com.mememan.vfxlib.api.platform.services.IPlatformHelper;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Wrapper-Class that effectively streamlines calling loader-specific implementations of common {@link Path}-related methods/operations within the game's root directory.
 *
 * @see VFXLServices#PLATFORM
 * @see IPlatformHelper
 */
public abstract class ModPathWrapper {
    private final Supplier<Path> gameDir;

    public ModPathWrapper(Supplier<Path> gameDir) {
        this.gameDir = gameDir;
    }

    /**
     * Directly gets the game's root directory, as specified by the loader-specific implementation within this instance's constructor.
     *
     * @return The game's root directory (Where "mods", "config", etc. live).
     */
    @NotNull
    public Path getGameDir() {
        return gameDir.get();
    }

    /**
     * Gets a {@link Path} from the game's root directory, as specified by the given loader-specific implementation. If no such directory (as per the one passed into this method) exists,
     * this method (as per impl-standard) will create a {@link Path} matching the given {@code nestedPath} within the game's root directory.
     *
     * @param nestedPath Nested directory within the game's root directory to check for.
     *
     * @return The specified {@code nestedPath} from the game's root directory, created if it did not exist.
     */
    public abstract Path getOrCreatePath(Path nestedPath);
}