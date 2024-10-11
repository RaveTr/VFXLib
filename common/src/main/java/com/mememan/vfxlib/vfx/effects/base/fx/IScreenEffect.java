package com.mememan.vfxlib.vfx.effects.base.fx;

import com.mememan.vfxlib.vfx.effects.base.data.EffectPresence;

/**
 * Hook sub-interface of {@link IEffect} whose sub-interfaces allow for the modification of the client's visual display by providing commonly-used methods that allow for the alteration of rendered elements on-screen (Static/animated overlays,
 * camera effects, level rendering, ghost objects, etc.). <br></br>
 *
 * This interface in and of itself provides the foundation for all types of visual effects. It is intended to be extended by sub-interfaces that provide more specialized methods for specific visual effects rather than
 * being directly implemented by VFX classes, as per standard VFXLib conventions. <br></br>
 *
 * It should be noted that by default, any effect derived from this interface typically falls under effect types whose effect presence is {@link EffectPresence#GRAPHICAL}. Some exceptions may exist for effects that have some
 * relationship to the server but should still be manipulated to some extent by the client, such as <b>derived</b> ghost object effects, object-tied afterimage overlays, etc.
 */
public interface IScreenEffect extends IEffect {

}