package com.mememan.vfxlib.vfx.effects.camera;

import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import org.jetbrains.annotations.Nullable;

/**
 * Data-holder {@code record} that stores information relevant to the modification of a given {@link Camera} object.
 *
 * @param targetCamera The {@link Camera} instance to modify.
 * @param cameraType The {@link CameraType} of the target {@link Camera} instance (I.E. Modifying the target {@link Camera} based on whether its {@link CameraType} matches the provided {@code cameraType}).
 * @param cameraMutationData The {@link CameraMutationData} to apply to the target {@link Camera} instance. May be {@code null}.
 */
public record CameraData(Camera targetCamera, CameraType cameraType, @Nullable CameraMutationData cameraMutationData) {
}
