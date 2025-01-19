package com.mememan.vfxlib.vfx.effects.base.data;

/**
 * Data-holding {@code record} that stores effect layer information.
 *
 * @param nameByCategory A flexible string-representation of the current effect layer. May be used to categorically split effect layers.
 * @param priority The numerical representation of the effect layer's priority. Higher numbers are rendered first/higher on-top.
 * @param targetEffectType A rigid object-representation of the effect type this layer pertains to. Splits effect layers by effect type in order to avoid OOS (out of scope) race-conditions when rendering layers.
 */
public record EffectLayer(String nameByCategory, double priority, EffectType targetEffectType) {
}
