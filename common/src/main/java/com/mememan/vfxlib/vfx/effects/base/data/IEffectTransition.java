package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.IEffect;
import it.unimi.dsi.fastutil.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Queue;

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

    List<IEffectType> getValidEffectTypes();

    List<Pair<IEffect, IEffect>> getSpecificTransitions(); //TODO effect transition container/wrapper

    Queue<Pair<IEffect, IEffect>> getActiveSpecificTransitions();

    List<IEffect> getExplicitTransitions();

    Queue<IEffect> getActiveExplicitTransitions();

    Queue<IEffect> getActiveGeneralTransitions();

    double getEffectTransitionLength();

    @Nullable
    EffectTransitionPhase getCurrentPhaseFor(IEffect targetEffect);

    double getEffectTransitionTickFor(IEffect targetEffect);

    double getEffectTransitionSpeedModifierFor(IEffect targetEffect);

    boolean isActiveFor(IEffect targetEffect);

    boolean allowEffectConcurrency(IEffect targetEffect);

    boolean allowTransitionConcurrency(IEffectTransition other);

    void performExplicitTransition(IEffect targetEffect);

    void performSpecificTransition(@NotNull IEffect from, @NotNull IEffect to);

    void performGeneralisedTransition(@Nullable IEffect from, @Nullable IEffect to);
}
