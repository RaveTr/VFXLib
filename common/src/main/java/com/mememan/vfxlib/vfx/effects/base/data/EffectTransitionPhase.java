package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.IEffect;

/**
 * Object-holder enum representing the different phases of an {@link IEffectTransition}.
 *
 * @see IEffectTransition
 */
public enum EffectTransitionPhase {
    /**
     * Transitioning out of any given {@link IEffect}.
     */
    FROM,
    /**
     * Transitioning into any given {@link IEffect}.
     */
    TO,
    /**
     * Transitioning between any two given {@link IEffect} instances.
     */
    BETWEEN
}
