package com.mememan.vfxlib.vfx.effects.base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

/**
 * An interface with the sole purpose of categorising VFX effect types. Provides a number of useful identification methods.
 */
public interface IEffectType {

    /**
     * The name of this effect type, represented as a formattable {@link Component}.
     *
     * @return The name of this effect type.
     */
    Component getTypeName();

    /**
     * The description of this effect type, represented as a formattable {@link Component}.
     *
     * @return The description of this effect type.
     */
    Component getTypeDescription();

    /**
     * The {@link EffectPresence} of this effect type (I.E. Whether it physically exists in a {@link Level} or if it's merely a GUI/on-screen element).
     *
     * @return The {@link EffectPresence} of this effect type.
     */
    EffectPresence getTypePresence();


}
