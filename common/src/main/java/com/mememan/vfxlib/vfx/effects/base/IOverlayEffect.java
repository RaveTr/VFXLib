package com.mememan.vfxlib.vfx.effects.base;

import com.mememan.vfxlib.vfx.effects.screen.data.OverlayTextureData;
import com.mememan.vfxlib.vfx.effects.screen.data.ScreenOverlay;
import com.mememan.vfxlib.vfx.effects.screen.data.TextureMutationData;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;

/**
 * A sub-interface of {@link IScreenEffect} that provides more screen-overlay-oriented methods for extensive gui effect customizability.
 */
public interface IOverlayEffect {

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
}
