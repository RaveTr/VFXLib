package com.mememan.vfxlib.vfx.effects.base.fx;

import com.mememan.vfxlib.vfx.effects.base.data.EffectMetadata;
import com.mememan.vfxlib.vfx.effects.base.data.EffectTypes;
import com.mememan.vfxlib.vfx.effects.base.data.IEffectType;
import net.minecraft.network.chat.Component;

/**
 * The base interface for all VFX effects. <br></br>
 *
 * All sub-interfaces representing VFX supercategories are inherently derived from this interface, whose sole purpose is to store common methods that should be shared across all existing effects and their types. <br></br>
 *
 * For more specific implementations, refer to the direct sub-interfaces of this interface. <br></br>
 *
 * Note that this interface should <b>NOT</b> be used for direct effect implementations, but that it should rather be used as the foundation for more spec-tailored effect interfaces, which are then optimally
 * implemented and fleshed-out for proper use.
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
     * The name of this effect, represented as a formattable {@link Component}. Primarily used in the FX editor in order to distinguish between different effects in the FX index.
     *
     * @return The {@link EffectMetadata} of this effect.
     */
    EffectMetadata getEffectMetadata();

    /**
     * Whether this effect should render at all on the client's visual display (For physical effects, whether they can be seen by both players AND entities, and whether they have any effect/hitbox).
     *
     * @return Whether this effect should be visible.
     *
     * @see #setVisible(boolean)
     */
    boolean isVisible();

    /**
     * Sets whether this effect should render at all on the client's visual display (For physical effects, whether they can be seen by both players AND entities, and whether they have any effect/hitbox).
     *
     * @param visible Whether this effect should be visible.
     *
     * @see #isVisible()
     */
    void setVisible(boolean visible);

    /**
     * Enqueues this effect instance to be added/rendered (depending on its implementation). <br></br>
     *
     * Calling this method multiple times stacks different instances of the same effect, as per standard VFXLib conventions. Exceptions are handled by the VFX queue.
     *
     * @param async Whether this effect should be rendered asynchronously (I.E. Instead of being queued to play after other effects of its type are done, it will be played immediately).
     *
     * @see #enqueueEffect()
     */
    void enqueueEffect(boolean async);

    /**
     * Overloaded variant of {@link #enqueueEffect(boolean)}, with {@code async} defaulted to {@code false}.
     *
     * @see #enqueueEffect(boolean)
     */
    default void enqueueEffect() {
        enqueueEffect(false);
    }

    /**
     * Dequeues this effect instance from the VFX queue (removes it, DEQUEUE HERE DOES NOT REFER TO A DOUBLE-ENDED QUEUE!!! (duh)). <br></br>
     *
     * If this effect instance is already in-progress, calling this method will stop it based on the value of {@code abruptDequeue}. Calling this method multiple times does nothing if the effect is already dequeued.
     *
     * @param abruptDequeue Whether this effect should be dequeued immediately instead of being transitioned out-of smoothly.
     *
     * @see #dequeueEffect()
     */
    void dequeueEffect(boolean abruptDequeue);

    /**
     * Overloaded variant of {@link #dequeueEffect(boolean)}, with {@code abruptDequeue} defaulted to {@code false}.
     *
     * @see #dequeueEffect(boolean)
     */
    default void dequeueEffect() {
        dequeueEffect(false);
    }
}
