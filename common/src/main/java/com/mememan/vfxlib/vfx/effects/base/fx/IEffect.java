package com.mememan.vfxlib.vfx.effects.base.fx;

import com.mememan.vfxlib.vfx.effects.base.data.EffectMetadata;
import com.mememan.vfxlib.vfx.effects.base.data.EffectTypes;
import com.mememan.vfxlib.vfx.effects.base.data.IEffectType;
import net.minecraft.network.chat.Component;

/**
 * The base interface for all VFX effects. <br></br>
 */
public interface IEffect {

    /**
     * The category under which this effect instance belongs.
     *
     * @return The category under which this effect instance belongs.
     *
     * @see EffectTypes
     */
    IEffectType getEffectType();

    /**
     * Whether this effect should render at all on the client's visual display (For physical effects, whether they can be seen by both players AND entities).
     *
     * @return Whether this effect should render at all on the client's visual display.
     */
    boolean isVisible();

    /**
     * The name of this effect, represented as a formattable {@link Component}. Primarily used in the FX editor in order to distinguish between different effects in the FX index.
     *
     * @return The {@link EffectMetadata} of this effect.
     */
    EffectMetadata getEffectMetadata();
}
