package com.mememan.vfxlib.vfx.effects.camera.data;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.client.Camera;

import java.util.List;

/**
 * Wrapper-Class representing a {@link Camera} (through a {@link CameraData} object) and any additional on-screen cameras that can be modified in various ways. All data stored in this class is mutable
 * for the sake of avoiding object construction hell during rendering.
 *
 * @see CameraData
 */
public class CameraWrapper {
    private CameraData primaryCamera;
    private List<CameraData> additionalCameras;

    public CameraWrapper(CameraData primaryCamera, List<CameraData> additionalCameras) {
        this.primaryCamera = primaryCamera;
        this.additionalCameras = additionalCameras;
    }

    public CameraWrapper(CameraData primaryCamera) {
        this(primaryCamera, ObjectArrayList.of());
    }

    /**
     * The primary {@link Camera} instance in this wrapper.
     *
     * @return The primary {@link Camera} instance.
     */
    public CameraData getPrimaryCamera() {
        return primaryCamera;
    }

    /**
     * Sets the primary {@link Camera} instance in this wrapper.
     *
     * @param primaryCamera The new primary {@link Camera} instance.
     */
    public void setPrimaryCamera(CameraData primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    /**
     * Additional {@link Camera} instances that are visible on-screen. May be empty.
     *
     * @return Additional {@link Camera} instances that are visible on-screen.
     */
    public List<CameraData> getAdditionalCameras() {
        return additionalCameras;
    }

    /**
     * Sets the additional {@link Camera} instances that are visible on-screen.
     *
     * @param additionalCameras The new {@link List} of additional {@link Camera} instances to be shown on-screen.
     */
    public void setAdditionalCameras(List<CameraData> additionalCameras) {
        this.additionalCameras = additionalCameras;
    }
}
