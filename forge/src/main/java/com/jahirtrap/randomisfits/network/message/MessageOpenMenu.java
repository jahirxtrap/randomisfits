package com.jahirtrap.randomisfits.network.message;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record MessageOpenMenu(int menu) {
    public static void encode(MessageOpenMenu message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.menu);
    }

    public static MessageOpenMenu decode(FriendlyByteBuf buffer) {
        return new MessageOpenMenu(buffer.readInt());
    }

    public static void handle(MessageOpenMenu message, Supplier<NetworkEvent.Context> supplier) {
        int menu = message.menu;
        supplier.get().enqueueWork(() -> {
            ServerPlayer player = supplier.get().getSender();
            if (ModConfig.rightClickSlotOpenMenu) {
                if (menu == 1) {
                    ModContent.ENDER_BAG.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                } else if (menu == 2) {
                    ModContent.CRAFTING_PLATE.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                }
            }
        });
        supplier.get().setPacketHandled(true);
    }
}
