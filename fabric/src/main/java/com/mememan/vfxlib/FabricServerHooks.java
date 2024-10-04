package com.mememan.vfxlib;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.Nullable;

public class FabricServerHooks {
    private static MinecraftServer CURRENT_SERVER;

    protected static void handleServerLifecycleHooks() {
        ServerLifecycleEvents.SERVER_STARTING.register((targetServer) -> CURRENT_SERVER = targetServer);
        ServerLifecycleEvents.SERVER_STOPPING.register((targetServer) -> CURRENT_SERVER = null);
    }

    @Nullable
    public static MinecraftServer getCurrentServer() {
        return CURRENT_SERVER;
    }
}
