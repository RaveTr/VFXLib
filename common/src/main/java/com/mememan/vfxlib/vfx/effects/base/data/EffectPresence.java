package com.mememan.vfxlib.vfx.effects.base.data;

import net.minecraft.world.level.Level;

/**
 * An enum representing the existence of an effect, either in graphical (on-screen, GUI) or physical (in a {@link Level}) sense.
 * <br></br>
 * TL;DR: <br>
 * <b>Graphical</b> = No hitbox, tied to client, can be controlled from server (triggering, checking for activity/visibility) and client (manipulation).<br>
 * <b>Physical</b> = Hitbox (optional), tied to server, can only be controlled from the server (Graphical effects can be "stacked" on top if needed).
 */
public enum EffectPresence {
    /**
     * An effect that exists solely on the client. This includes ghost-objects, but primarily encompasses effects such as GUI manipulation and camera shakes, etc.
     */
    GRAPHICAL,
    /**
     * An effect that exists both on the client and the server. These effects are synced S2C and are not tied to the player's screen, but rather a given {@link Level} (or existing objects within it).
     */
    PHYSICAL
}
