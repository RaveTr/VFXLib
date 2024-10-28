package com.mememan.vfxlib.vfx.effects.base.data;

import com.mememan.vfxlib.vfx.effects.base.fx.IEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Container-Class that essentially wraps around a given {@link IEffect} instance and provides methods in order to track/update it whenever it transitions.
 */
public class EffectTransitionContainer {
    @NotNull
    private final IEffect ownerEffect;
    @Nullable
    private IEffect targetEffect;
    private final double durationInTicks;
    private double tickProgress = 0.0D;
    @Nullable
    private EffectTransitionPhase getCurrentPhase;

    public EffectTransitionContainer(@NotNull IEffect ownerEffect, double durationInTicks) {
        this.ownerEffect = ownerEffect;
        this.durationInTicks = durationInTicks;
    }

    public double getTickProgress() {
        return tickProgress;
    }
}
