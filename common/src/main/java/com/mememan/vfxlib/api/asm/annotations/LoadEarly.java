package com.mememan.vfxlib.api.asm.annotations;

import com.mememan.vfxlib.VFXLib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation interface used to load classes that need early class-loading ahead of all other mod-loading stages.
 *
 * @see VFXLib
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LoadEarly {
}
