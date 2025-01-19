package com.mememan.vfxlib.vfx.effects.screen.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/**
 * Data-holding {@code record} that stores basic UV coordinates.
 *
 * @param uCoord The {@code u} coordinate of a given 2D texture/element (Its {@code x} coordinate on the screen).
 * @param vCoord The {@code v} coordinate of a given 2D texture/element (Its {@code y} coordinate on the screen).
 */
public record UVData(double uCoord, double vCoord) {
    public static final Codec<UVData> CODEC = RecordCodecBuilder.create(inst -> inst.group(Codec.DOUBLE.fieldOf("uCoord").forGetter(UVData::uCoord), Codec.DOUBLE.fieldOf("vCoord").forGetter(UVData::vCoord)).apply(inst, UVData::new));
}
