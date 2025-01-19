package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.Effect;
import it.unimi.dsi.fastutil.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Queue;

/**
 * Data-holding {@code interface} representing data used in order to transition to/from/between different effects. Note that not every effect necessarily has a transition.
 *
 * @see Effect
 */
public interface EffectTransition {

    /**
     * The metadata of this effect transition. Primarily used in the FX editor in order to distinguish between different effect transitions in the FX index.
     *
     * @return The {@link EffectMetadata} of this effect transition.
     */
    EffectMetadata getTransitionMetadata();

    List<EffectType> getValidEffectTypes();

    List<Pair<Effect, Effect>> getSpecificTransitions(); //TODO effect transition container/wrapper

    Queue<Pair<Effect, Effect>> getActiveSpecificTransitions();

    List<Effect> getExplicitTransitions();

    Queue<Effect> getActiveExplicitTransitions();

    Queue<Effect> getActiveGeneralTransitions();

    double getEffectTransitionLength();

    @Nullable
    EffectTransitionPhase getCurrentPhaseFor(Effect targetEffect);

    double getEffectTransitionTickFor(Effect targetEffect);

    double getEffectTransitionSpeedModifierFor(Effect targetEffect);

    boolean isActiveFor(Effect targetEffect);

    boolean allowEffectConcurrency(Effect targetEffect);

    boolean allowTransitionConcurrency(EffectTransition other);

    void performExplicitTransition(Effect targetEffect);

    void performSpecificTransition(@NotNull Effect from, @NotNull Effect to);

    void performGeneralisedTransition(@Nullable Effect from, @Nullable Effect to);
}
