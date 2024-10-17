package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.IEffect;
import it.unimi.dsi.fastutil.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    List<Pair<IEffect, IEffect>> getSpecificTransitions(); //TODO effect transition container/wrapper

    List<Pair<IEffect, IEffect>> getActiveSpecificTransitions();

    List<IEffect> getExplicitTransitions();

    List<IEffect> getActiveExplicitTransitions();

    List<IEffect> getActiveGeneralTransitions();

    @Nullable
    EffectTransitionPhase getCurrentPhaseFor(IEffect targetEffect);

    double getEffectTransitionTick();

    double getEffectTransitionLength();

    double getEffectTransitionSpeedModifier();

    boolean isActiveFor(IEffect targetEffect);

    void performTransition(IEffect targetEffect);

    void performGeneralisedTransition(@Nullable IEffect from, @Nullable IEffect to);
}
