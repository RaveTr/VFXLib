package com.mememan.vfxlib.vfx.effects.base.fx;

import com.mememan.vfxlib.vfx.effects.camera.data.CameraData;
import com.mememan.vfxlib.vfx.effects.camera.data.CameraMutationData;
import com.mememan.vfxlib.vfx.effects.camera.data.CameraWrapper;
import net.minecraft.client.Camera;

/**
 * A sub-interface of {@link IScreenEffect} that provides more camera-oriented methods for extensive camera effect customizability.
 */
public interface ICameraEffect extends IScreenEffect {

    /**
     * Renders a {@link Camera} (or multiple {@linkplain Camera Cameras}) on-screen using the provided {@link CameraWrapper}.
     *
     * @param targetCamWrapper The {@link CameraWrapper} representing the {@linkplain Camera Camera(s)} to render on-screen. Base implementations of this method will always provide native
     *                         handling for additional cameras displayed on-screen, unless explicitly specified otherwise.
     * @param partialTick The value representing the partial tick in Minecraft's primary renderer (Essentially the amount of time between each tick, in ticks). There are typically 20 partial ticks per full game tick,
     *                    or 400 partial ticks in a second.
     *
     * @see CameraWrapper
     * @see CameraData
     * @see CameraMutationData
     */
    void renderCamera(CameraWrapper targetCamWrapper, float partialTick);
}
