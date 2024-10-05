package com.mememan.vfxlib.vfx.effects.camera.data;

import net.minecraft.client.Camera;

/**
 * Data-holder {@code record} that stores information relevant to the modification of a given {@link CameraData} object.
 *
 * @param fovMod The {@code fov} modification to apply to a given {@link CameraData} based on the target {@link Camera} instance (I.E. Instanced per-camera rather than being a global modifier).
 * @param yawMod The {@code yaw} modification to apply to a given {@link CameraData} based on the target {@link Camera} instance (I.E. Instanced per-camera rather than being a global modifier).
 *               In other words, this is the camera's rotation around the Y-axis of its origin position (left-right, horizontally).
 * @param pitchMod The {@code pitch} modification to apply to a given {@link CameraData} based on the target {@link Camera} instance (I.E. Instanced per-camera rather than being a global modifier).
 *                 In other words, this is the camera's rotation around the X-axis of its origin position (up-down, vertically (duh)).
 * @param rollMod The {@code roll} modification to apply to a given {@link CameraData} based on the target {@link Camera} instance (I.E. Instanced per-camera rather than being a global modifier).
 *                In other words, this is the camera's rotation around the Z-axis of its origin position (left-right, vertically).
 *
 * @see CameraData
 */
public record CameraMutationData(double fovMod, double yawMod, double pitchMod, double rollMod) {
}
