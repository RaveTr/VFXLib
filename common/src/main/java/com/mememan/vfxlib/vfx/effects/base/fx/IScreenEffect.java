package com.mememan.vfxlib.vfx.effects.base.fx;

/**
 * Hook sub-interface of {@link IEffect} whose sub-interfaces allow for the modification of the client's visual display by providing commonly-used methods that allow for the alteration of rendered elements on-screen (Static/animated overlays,
 * camera effects, level rendering, ghost objects, etc.). <br></br>
 *
 * This interface in and of itself provides the foundation for all types of visual effects. It is intended to be extended by sub-interfaces that provide more specialized methods for specific visual effects rather than
 * being directly implemented by VFX classes.
 */
public interface IScreenEffect extends IEffect {

}