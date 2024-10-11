package com.mememan.vfxlib.api.asm;

import com.mememan.vfxlib.VFXLConstants;

public final class ClassFinder {

    /**
     * A utility method that wraps {@link Class#forName(String)} in a {@code try-catch} block.
     *
     * @param targetClassName The name of the class to initialize.
     *
     * @return The initialized class, or {@code null} if no such class exists.
     */
    public static Class<?> forName(String targetClassName) {
        try {
            return Class.forName(targetClassName);
        } catch (ClassNotFoundException e) {
            VFXLConstants.LOGGER.error("Failed to load: {}, no such class was found.", targetClassName, e);
            return null;
        }
    }
}
