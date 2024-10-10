package com.mememan.vfxlib.api.platform.services;

import com.mememan.vfxlib.api.loader.EnvironmentType;
import com.mememan.vfxlib.api.loader.ModLoader;
import com.mememan.vfxlib.api.loader.ModPathWrapper;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * A loader-agnostic interface for managing platform-specific implementations of certain loader-specific features, ranging from methods that provide predicates for loader detection to methods that
 * allow for more performant ways of performing certain tasks, such as class-loading, environment-detection, etc.
 */
public interface IPlatformHelper {

    /**
     * Gets the {@link ModLoader} representation of the current platform.
     *
     * @return The {@link ModLoader} representation of the current platform.
     */
    ModLoader getPlatform();

    /**
     * Checks if a mod with the given modid is loaded.
     *
     * @param modId The modid to check against.
     *
     * @return {@code true} if the mod is loaded, {@code false} otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return {@code true} if in a development environment, {@code false} otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Discovers all (mod) classes that are annotated with the specified annotation type and compiles them into a {@link List}. Take note that this method <b>loads</b> (valid, I.E. only ones that pass annotation checks) discovered classes.
     *
     * @param annotationTypeClazz The annotation type class.
     *
     * @return A {@link List} of classes annotated with the specified annotation type.
     */
    List<Class<?>> discoverAnnotatedClasses(Class<? extends Annotation> annotationTypeClazz);

    /**
     * Gets the {@link ModPathWrapper} representing path-related operations for a given loader.
     *
     * @return The {@link ModPathWrapper} of the current platform.
     */
    ModPathWrapper getModPathWrapper();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default EnvironmentType getEnvironmentType() {
        return isDevelopmentEnvironment() ? EnvironmentType.DEVELOPMENT : EnvironmentType.PRODUCTION;
    }
}