package com.mememan.vfxlib.gui.base;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;

/**
 * Wrapper-Class used to store and mutate passed-in dimensions' information.
 */
public class Dimensions {
    private static final int SCREEN_WIDTH = Minecraft.getInstance().screen.width;
    private static final int SCREEN_HEIGHT = Minecraft.getInstance().screen.height;
    private int width;
    private int height;
    private double scaleMod = 1.0D;

    public Dimensions(int initialWidth, int initialHeight, double scaleMod) {
        this.width = Mth.clamp(initialWidth, 0, SCREEN_WIDTH);
        this.height = Mth.clamp(initialHeight, 0, SCREEN_HEIGHT);
        this.scaleMod = scaleMod;
    }

    public Dimensions(int initialWidth, int initialHeight) {
        this(initialWidth, initialHeight, 1.0D);
    }

    /**
     * The width value currently stored in this instance, irrespective of the current {@link #scaleMod} value.
     *
     * @return The current raw width value.
     *
     * @see #getWidth()
     */
    public int getRawWidth() {
        return this.width;
    }

    /**
     * The width value currently stored in this instance, multiplied by the current {@link #scaleMod} value.
     *
     * @return The current scaled width value.
     *
     * @see #getRawWidth()
     * @see #getScaleMod()
     */
    public int getWidth() {
        return (int) (this.width * this.scaleMod);
    }

    /**
     * Directly updates the currently stored width value to the one passed in without considering the current {@link #scaleMod}. Clamped between {@code 0} and {@link #SCREEN_WIDTH}.
     *
     * @param width The new width value, clamped between {@code 0} and {@link #SCREEN_WIDTH}.
     *
     * @see #setWidth(int)
     */
    public void setRawWidth(int width) {
        this.width = Mth.clamp(width, 0, SCREEN_WIDTH);
    }

    /**
     * Updates the currently stored width value to the one passed in, considering the current {@link #scaleMod}. Clamped between {@code 0} and {@link #SCREEN_WIDTH}.
     *
     * @param width The new width value, clamped between {@code 0} and {@link #SCREEN_WIDTH}.
     *
     * @see #setRawWidth(int)
     * @see #getScaleMod()
     */
    public void setWidth(int width) {
        this.width = (int) Mth.clamp(width * scaleMod, 0, SCREEN_WIDTH);
    }

    /**
     * The height value currently stored in this instance, irrespective of the current {@link #scaleMod} value.
     *
     * @return The current raw height value.
     *
     * @see #getHeight()
     */
    public int getRawHeight() {
        return this.height;
    }

    /**
     * The height value currently stored in this instance, multiplied by the current {@link #scaleMod} value.
     *
     * @return The current scaled height value.
     *
     * @see #getRawHeight()
     * @see #getScaleMod()
     */
    public int getHeight() {
        return (int) (this.height * this.scaleMod);
    }

    /**
     * Directly updates the currently stored height value to the one passed in without considering the current {@link #scaleMod}. Clamped between {@code 0} and {@link #SCREEN_HEIGHT}.
     *
     * @param height The new height value, clamped between {@code 0} and {@link #SCREEN_HEIGHT}.
     *
     * @see #setHeight(int)
     */
    public void setRawHeight(int height) {
        this.height = Mth.clamp(height, 0, SCREEN_HEIGHT);
    }

    /**
     * Updates the currently stored height value to the one passed in, considering the current {@link #scaleMod}. Clamped between {@code 0} and {@link #SCREEN_HEIGHT}.
     *
     * @param height The new height value, clamped between {@code 0} and {@link #SCREEN_HEIGHT}.
     *
     * @see #setRawHeight(int)
     * @see #getScaleMod()
     */
    public void setHeight(int height) {
        this.height = (int) Mth.clamp(height * scaleMod, 0, SCREEN_HEIGHT);
    }

    /**
     * The current {@link #scaleMod} value, by which the current {@link #getWidth()} and {@link #getHeight()} values
     * are (typically) multiplied whenever they're called for use in any given native VFXLib GUI. Also important for scaling outside of that particular use case (duh).
     *
     * @return The current {@link #scaleMod} value.
     *
     * @see #setScaleMod(double)
     */
    public double getScaleMod() {
        return scaleMod;
    }

    /**
     * Sets the current {@link #scaleMod} value to the one passed in.
     *
     * @param scaleMod The new {@link #scaleMod} value.
     *
     * @see #getScaleMod()
     */
    public void setScaleMod(double scaleMod) {
        this.scaleMod = scaleMod;
    }

    /**
     * Shortcut method for directly scaling the current dimensions using the {@code scaleMod} passed in.
     *
     * @param scaleMod The new {@link #scaleMod} value.
     *
     * @see #getScaleMod()
     * @see #getWidth()
     * @see #getHeight()
     */
    public void scale(double scaleMod) {
        setScaleMod(scaleMod);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Copies this instance's values into a new {@link Dimensions} instance.
     *
     * @return The new {@link Dimensions} instance with the currently-stored values.
     *
     * @see #copyFrom(Dimensions)
     */
    public Dimensions copy() {
        return new Dimensions(this.width, this.height, this.scaleMod);
    }

    /**
     * Center this instance's {@link #width} and {@link #height} values, relative to the currently-stored dimension values, in a new {@link Dimensions} instance.
     *
     * @return The new {@link Dimensions} instance with the set {@link #width} and {@link #height} center values.
     */
    public Dimensions center() {
        return new Dimensions(this.width / 2, this.height / 2, this.scaleMod);
    }

    /**
     * Center this instance's {@link #width} and {@link #height} values, relative to the current {@link Minecraft} window size, in a new {@link Dimensions} instance.
     *
     * @return The new {@link Dimensions} instance with the set {@link #width} and {@link #height} center values.
     */
    public Dimensions centerOnScreen() {
        return new Dimensions(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, this.scaleMod); //TODO Vertices impl + finally advance
    }

    /**
     * (Safely) copies the values of the {@link Dimensions} passed in into this instance.
     *
     * @param other The {@link Dimensions} to copy values from.
     *
     * @see #copy()
     */
    public void copyFrom(Dimensions other) {
        if (other == null) return;

        setRawWidth(other.getRawWidth());
        setRawHeight(other.getRawHeight());
        setScaleMod(other.getScaleMod());
    }

    public boolean smallerThan(Dimensions other) {
        return getWidth() < other.getWidth() && getHeight() < other.getHeight();
    }

    public boolean largerThan(Dimensions other) {
        return getWidth() > other.getWidth() && getHeight() > other.getHeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Dimensions)) return false;

        Dimensions other = (Dimensions) obj;

        return width == other.width && height == other.height && scaleMod == other.scaleMod;
    }
}
