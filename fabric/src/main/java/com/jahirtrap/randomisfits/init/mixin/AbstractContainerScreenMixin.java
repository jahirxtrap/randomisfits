package com.jahirtrap.randomisfits.init.mixin;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.item.CraftingPlateItem;
import com.jahirtrap.randomisfits.item.EnderBagItem;
import com.jahirtrap.randomisfits.network.message.MessageOpenMenu;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin {

    @Shadow
    @Nullable
    protected Slot hoveredSlot;

    @Inject(method = "mouseClicked", at = @At("HEAD"), cancellable = true)
    public void mouseClicked(MouseButtonEvent buttonEvent, boolean bl, CallbackInfoReturnable<Boolean> cir) {
        Slot slot = hoveredSlot;
        if (ModConfig.rightClickSlotOpenMenu && slot != null && buttonEvent.button() == 1) {
            int menu = 0;
            Item item = slot.getItem().getItem();
            if (item instanceof EnderBagItem) menu = 1;
            else if (item instanceof CraftingPlateItem) menu = 2;

            if (menu != 0) {
                ClientPlayNetworking.send(new MessageOpenMenu(menu));
                cir.setReturnValue(true);
            }
        }
    }
}
