package com.mememan.vfxlib.mixins.client;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseScreen.class)
public abstract class PauseScreenMixin extends Screen {

    private PauseScreenMixin(Component titleComponent) {
        super(titleComponent);
    }

    @Inject(method = "createPauseMenu", at = @At("RETURN"), cancellable = true)
    private void vfxlib$createPauseScreen(CallbackInfo ci) {
        addRenderableWidget(new ImageButton(width / 2 + 106, height / 4 + 40, 20, 20, 0, 0, 20, AbstractWidget.ACCESSIBILITY_TEXTURE, 20, 20, curButton -> {
            minecraft.setScreen(null);
            minecraft.mouseHandler.grabMouse();
        }));
    }
}
