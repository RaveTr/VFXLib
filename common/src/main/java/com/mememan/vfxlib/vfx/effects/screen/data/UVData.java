package com.mememan.vfxlib.vfx.effects.screen.data;

/**
 * Data-holding {@code record} that stores basic UV coordinates.
 *
 * @param uCoord The {@code u} coordinate of a given 2D texture/element (Its {@code x} coordinate on the screen).
 * @param vCoord The {@code v} coordinate of a given 2D texture/element (Its {@code y} coordinate on the screen).
 */
public record UVData(double uCoord, double vCoord) {
}
