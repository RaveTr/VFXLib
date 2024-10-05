package com.mememan.vfxlib.vfx.effects.screen.data;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.gui.Gui;

import java.util.List;

/**
 * Wrapper-Class representing a texture overlay that can be rendered through Minecraft's {@link Gui} + any additional layers. All data stored in this class is mutable for the sake of avoiding
 * object construction hell during rendering.
 *
 * @see OverlayTextureData
 */
public class ScreenOverlay {
    private OverlayTextureData overlayTexture;
    private List<OverlayTextureData> otLayers;

    public ScreenOverlay(OverlayTextureData overlayTexture, List<OverlayTextureData> otLayers) {
        this.overlayTexture = overlayTexture;
        this.otLayers = otLayers;
    }

    public ScreenOverlay(OverlayTextureData overlayTexture) {
        this(overlayTexture, ObjectArrayList.of());
    }

    /**
     * The base {@link OverlayTextureData} representing the overlay to render on-screen.
     *
     * @return The {@link OverlayTextureData} representing the overlay to render on-screen.
     */
    public OverlayTextureData getOverlayTexture() {
        return overlayTexture;
    }

    /**
     * Sets the base {@link OverlayTextureData} representing the overlay to render on-screen.
     *
     * @param overlayTexture The new {@link OverlayTextureData} representing the overlay to render on-screen.
     */
    public void setOverlayTexture(OverlayTextureData overlayTexture) {
        this.overlayTexture = overlayTexture;
    }

    /**
     * A {@link List} of additional {@link OverlayTextureData} layers to render on-screen.
     *
     * @return A {@link List} of additional {@link OverlayTextureData} layers to render on-screen.
     */
    public List<OverlayTextureData> getOtLayers() {
        return otLayers;
    }

    /**
     * Sets the {@link List} of additional {@link OverlayTextureData} layers to render on-screen.
     *
     * @param otLayers The new {@link List} of additional {@link OverlayTextureData} layers to render on-screen.
     */
    public void setOtLayers(List<OverlayTextureData> otLayers) {
        this.otLayers = otLayers;
    }
}
