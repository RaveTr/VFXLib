package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.IEffect;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Data-holding {@code interface} representing data used in order to transition to/from/between different effects. Note that not every effect necessarily has a transition.
 *
 * @see IEffect
 */
public interface IEffectTransition {

    /**
     * The metadata of this effect transition. Primarily used in the FX editor in order to distinguish between different effect transitions in the FX index.
     *
     * @return The {@link EffectMetadata} of this effect transition.
     */
    EffectMetadata getTransitionMetadata();

    /**
     * The
     *
     * @return
     */
    Consumer<IEffect> transitionToEffect();

    /**
     * The
     *
     * @return
     */
    Consumer<IEffect> transitionFromEffect();

    /**
     * The
     *
     * @return
     */
    BiConsumer<IEffect, IEffect> transitionBetweenEffects();
}
