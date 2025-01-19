package com.mememan.vfxlib.vfx.effects.base.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;

/**
 * Data-holding {@code record} for storing effect metadata used in the FX editor, primarily for distinguishing between different elements storing this object (effect types, effects, etc.).
 *
 * @param logoFile The {@link ResourceLocation} representing the logo file for this FX metadata object.
 * @param name The name of this FX metadata object, represented as a formattable {@link Component}.
 * @param description The description of this FX metadata object, represented as a formattable {@link Component}.
 */
public record EffectMetadata(ResourceLocation logoFile, Component name, Component description) {
    public static final Codec<EffectMetadata> CODEC = RecordCodecBuilder.create(inst -> inst.group(ResourceLocation.CODEC.fieldOf("logoFile").forGetter(EffectMetadata::logoFile), ExtraCodecs.COMPONENT.fieldOf("name").forGetter(EffectMetadata::name), ExtraCodecs.COMPONENT.fieldOf("description").forGetter(EffectMetadata::description)).apply(inst, EffectMetadata::new));
}
