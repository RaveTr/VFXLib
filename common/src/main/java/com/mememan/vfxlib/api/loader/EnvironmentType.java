package com.mememan.vfxlib.api.loader;

/**
 * A basic holder enum representing environment types as objects.
 */
public enum EnvironmentType {
    DEVELOPMENT("Development"),
    PRODUCTION("Production");

    private final String name;

    EnvironmentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
