package com.mememan.vfxlib.vfx.effects.screen;

import org.jetbrains.annotations.Nullable;

import java.awt.*;

/**
 * Data-holding {@code record} that stores information for a given {@linkplain OverlayTextureData OverlayTextureData's} mutation.
 *
 * @param colorMod The {@link Color} modification to apply to a given {@link OverlayTextureData}. Take note that in base implementations, this <b>blends</b> the passed-in {@link Color} with the
 *                 existing {@link OverlayTextureData} color. May be {@code null}.
 * @param uvPosMod The {@link UVData} <b>positional</b> modification to apply to a given {@link OverlayTextureData}. This is effectively its positional translation on-screen. May be {@code null}.
 * @param uvSkewMod The {@link UVData} <b>skewing</b> modification to apply to a given {@link OverlayTextureData}. As the name suggests, this is effectively its slanting/shearing mod on-screen. May be {@code null}.
 * @param rotationMod The {@code rotation} modification to apply to a given {@link OverlayTextureData}. This is merely a {@code double} since you can only rotate 2D textures in 2 directions (+ or -).
 * @param scaleMod The {@code scale} modification to apply to a given {@link OverlayTextureData}. Some implementations of this may allow you to scale an overlay texture beyond the current window size.
 */
public record TextureMutationData(@Nullable Color colorMod, @Nullable UVData uvPosMod, @Nullable UVData uvSkewMod, double rotationMod, double scaleMod) {
}
