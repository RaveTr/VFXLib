package com.mememan.vfxlib.vfx.effects.base;

import com.mememan.vfxlib.vfx.effects.screen.ScreenOverlay;
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
     * @param mcGuiGraphics The {@link GuiGraphics} used by the {@linkplain GameRenderer GameRenderer's} {@linkplain GameRenderer#render(float, long, boolean) render} method.
     * @param screenOverlay The {@link ScreenOverlay} representing the overlay to render on-screen.
     * @param overlayTexAlpha The {@code alpha} value of the passed-in {@code screenOverlay} (Basically its transparency on-screen). Clamped between {@code 0.0F} and {@code 1.0F}.
     * @param partialTick The value representing the partial tick in Minecraft's primary renderer (Essentially the amount of time between each tick, in ticks). There are typically 20 partial ticks per full game tick,
     *                    or 400 partial ticks in a second.
     * @param textureWidth The value representing the total width of the passed-in {@code screenOverlay}, in pixels.
     * @param textureHeight The value representing the total height of the passed-in {@code screenOverlay}, in pixels.
     * @param screenWidth The value representing the total width of the current Minecraft window, in pixels.
     * @param screenHeight The value representing the total height of the current Minecraft window, in pixels.
     *
     * @see Gui#render(GuiGraphics, float)
     */
    void renderBasicOverlay(GuiGraphics mcGuiGraphics, ScreenOverlay screenOverlay, double overlayTexAlpha, float partialTick, double textureWidth, double textureHeight, double screenWidth, double screenHeight);
}
