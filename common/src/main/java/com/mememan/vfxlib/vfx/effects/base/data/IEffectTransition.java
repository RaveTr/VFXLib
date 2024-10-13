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
     * The {@link Consumer} responsible for handling transitions to the consumed effect instance.
     *
     * @return The {@link Consumer} responsible for handling transitions to the consumed effect instance.
     */
    Consumer<IEffect> transitionToEffect();

    /**
     * The {@link Consumer} responsible for handling transitions out of/from the consumed effect instance.
     *
     * @return The {@link Consumer} responsible for handling transitions out of/from the consumed effect instance.
     */
    Consumer<IEffect> transitionFromEffect();

    /**
     * The {@link BiConsumer} responsible for handling transitions between 2 particular consumed effect instances.
     *
     * @return The {@link BiConsumer} responsible for handling transitions between 2 consumed particular effect instances.
     */
    BiConsumer<IEffect, IEffect> transitionBetweenEffects();
}
