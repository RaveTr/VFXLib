package com.mememan.vfxlib.vfx.cutscene.base;

import com.mememan.vfxlib.vfx.effects.base.fx.Effect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.List;

/**
 * The base interface representing any scripted sequence of events in any given {@link Level}.
 */
public interface CutScene {

    /**
     * Gets the {@link LevelAccessor} this {@link CutScene} instance takes place in.
     *
     * @return The {@link LevelAccessor} this {@link CutScene} instance takes place in.
     */
    LevelAccessor getLevel();

    /**
     * Gets the current progress of this {@link CutScene} instance, in ticks, since it started.
     *
     * @return The current progress of this {@link CutScene} instance (in ticks).
     */
    double getProgress();

    /**
     * Gets the duration of this {@link CutScene} instance, in ticks.
     *
     * @return The duration of this {@link CutScene} instance, in ticks.
     */
    double getDuration();

    /**
     * Whether this {@link CutScene} instance should pause its sequence of events.
     *
     * @return Whether this {@link CutScene} instance should pause its sequence of events.
     */
    boolean shouldPause();

    /**
     * Gets the object representing the bounding box, or level space, encompassed by this {@link CutScene} instance.
     *
     * @return The bounding box (level space, in blocks) encapsulated by this {@link CutScene} instance.
     */
    CutSceneSpace getCutSceneSpace();

    /**
     * Gets the {@link List} of {@linkplain Block Blocks} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @return The {@link List} of {@linkplain Block Blocks} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @see #getStoredBlockEntities()
     * @see #getStoredEntities()
     * @see #getCutSceneSpace()
     */
    List<Block> getStoredBlocks();

    /**
     * Gets the {@link List} of {@linkplain BlockEntity BlockEntities} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @return The {@link List} of {@linkplain BlockEntity BlockEntities} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @see #getStoredBlocks()
     * @see #getStoredEntities()
     * @see #getCutSceneSpace()
     */
    List<BlockEntity> getStoredBlockEntities();

    /**
     * Gets the {@link List} of {@linkplain Entity Entities} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @return The {@link List} of {@linkplain Entity Entities} that are stored within this {@link CutScene} instance's {@link CutSceneSpace}.
     *
     * @see #getStoredBlocks()
     * @see #getStoredBlockEntities()
     * @see #getCutSceneSpace()
     */
    List<Entity> getStoredEntities();

    /**
     * Gets the {@link List} of {@link Effect} instances used in this {@link CutScene} instance.
     *
     * @return The {@link List} of {@link Effect} instances associated with this {@link CutScene} instance. May be empty.
     */
    List<Effect> getVFX();

    /**
     * Whether this {@link CutScene} instance can be interrupted by external events (E.G. All players leaving, any given player dying, etc.).
     *
     * @return Whether this {@link CutScene} instance can be interrupted by external events.
     */
    boolean isInterruptable();

    /**
     * Whether this {@link CutScene} instance should trigger.
     *
     * @return Whether this {@link CutScene} instance should trigger.
     */
    boolean shouldTrigger();

    /**
     * Whether this {@link CutScene} instance is done (including transitioning out).
     *
     * @return Whether this {@link CutScene} instance is done.
     */
    boolean isDone();
}