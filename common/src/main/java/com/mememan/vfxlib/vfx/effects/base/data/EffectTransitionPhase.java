package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.Effect;

/**
 * Object-holder enum representing the different phases of an {@link EffectTransition}.
 *
 * @see EffectTransition
 */
public enum EffectTransitionPhase {
    /**
     * Transitioning out of any given {@link Effect}.
     */
    FROM,
    /**
     * Transitioning into any given {@link Effect}.
     */
    TO,
    /**
     * Transitioning between any two given {@link Effect} instances.
     */
    BETWEEN
}
