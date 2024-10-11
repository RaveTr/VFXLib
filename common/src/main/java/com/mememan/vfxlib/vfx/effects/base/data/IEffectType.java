package com.mememan.vfxlib.vfx.effects.base.data;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

/**
 * An interface with the sole purpose of categorising VFX effect types. Provides a number of useful identification methods.
 */
public interface IEffectType {

    /**
     * The name of this effect type, represented as a formattable {@link Component}. Primarily used in the FX editor in order to distinguish between different effect types in the FX index.
     *
     * @return The {@link EffectMetadata} of this effect type.
     */
    EffectMetadata getTypeMetadata();

    /**
     * The {@link EffectPresence} of this effect type (I.E. Whether it physically exists in a {@link Level} or if it's merely a GUI/on-screen element).
     *
     * @return The {@link EffectPresence} of this effect type.
     */
    EffectPresence getTypePresence();
}
