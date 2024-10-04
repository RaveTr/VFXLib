package com.mememan.vfxlib.api.platform;

import com.mememan.vfxlib.VFXLConstants;
import com.mememan.vfxlib.api.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class VFXLServices {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        VFXLConstants.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }
}