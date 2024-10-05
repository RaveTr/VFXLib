package com.mememan.vfxlib.vfx.effects.screen;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/**
 * Data-holding {@code record} that stores high-level rendering information for an overlay texture.
 *
 * @param overlayTexture The {@link ResourceLocation} representing the overlay texture.
 * @param alpha The {@code alpha} value of the passed-in {@code overlayTextureLocation} (Basically its transparency on-screen). Typically clamped between {@code 0.0F} and {@code 1.0F}.
 * @param width The value representing the total width of the passed-in {@code overlayTextureLocation}, in pixels.
 * @param height The value representing the total height of the passed-in {@code overlayTextureLocation}, in pixels.
 * @param screenWidth The value representing the total width of the current Minecraft window, in pixels.
 * @param screenHeight The value representing the total height of the current Minecraft window, in pixels.
 * @param otMutationData The {@link TextureMutationData} representing the modifications applied to the passed-in {@code overlayTextureLocation}. May be {@code null}.
 */
public record OverlayTextureData(ResourceLocation overlayTexture, float alpha, double width, double height, double screenWidth, double screenHeight, @Nullable TextureMutationData otMutationData) {
}
