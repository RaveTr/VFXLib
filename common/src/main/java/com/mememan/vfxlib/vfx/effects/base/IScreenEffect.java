package com.mememan.vfxlib.vfx.effects.base;

import com.mememan.vfxlib.vfx.effects.camera.data.CameraData;
import com.mememan.vfxlib.vfx.effects.camera.data.CameraMutationData;
import com.mememan.vfxlib.vfx.effects.camera.data.CameraWrapper;
import com.mememan.vfxlib.vfx.effects.screen.data.OverlayTextureData;
import com.mememan.vfxlib.vfx.effects.screen.data.ScreenOverlay;
import com.mememan.vfxlib.vfx.effects.screen.data.TextureMutationData;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;

/**
 * Hook interface which allows for the modification of the client's visual display by providing commonly-used methods that allow for the alteration of rendered elements on-screen (Static/animated overlays, camera effects, level
 * rendering, ghost objects, etc.).
 */
public interface IScreenEffect {

    /**
     * Renders the {@code screenOverlay} passed into this method through Minecraft's {@link Gui}.
     *
     * @param mcGuiGraphics The {@link GuiGraphics} used by the {@linkplain GameRenderer GameRenderer's} {@linkplain GameRenderer#render(float, long, boolean) render} method. Can be any other instance, but is Minecraft's
     *                      in base implementations of this method.
     * @param screenOverlay The {@link ScreenOverlay} representing the overlay(s) (and any modifications made to it) to render on-screen.
     * @param partialTick The value representing the partial tick in Minecraft's primary renderer (Essentially the amount of time between each tick, in ticks). There are typically 20 partial ticks per full game tick,
     *                    or 400 partial ticks in a second.
     *
     * @see Gui#render(GuiGraphics, float)
     * @see ScreenOverlay
     * @see TextureMutationData
     * @see OverlayTextureData
     */
    void renderBasicOverlay(GuiGraphics mcGuiGraphics, ScreenOverlay screenOverlay, float partialTick);

    /**
     * Renders a {@link Camera} (or multiple {@linkplain Camera Cameras}) on-screen using the provided {@link CameraWrapper}.
     *
     * @param targetCamWrapper The {@link CameraWrapper} representing the {@linkplain Camera Camera(s)} to render on-screen.
     * @param partialTick The value representing the partial tick in Minecraft's primary renderer (Essentially the amount of time between each tick, in ticks). There are typically 20 partial ticks per full game tick,
     *                    or 400 partial ticks in a second.
     *
     * @see CameraWrapper
     * @see CameraData
     * @see CameraMutationData
     */
    void renderCamera(CameraWrapper targetCamWrapper, float partialTick);
}