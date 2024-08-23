package com.jahirtrap.randomisfits.network.message;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.network.CustomPayloadEvent;

public record MessageOpenMenu(int menu) {
    public static void encode(MessageOpenMenu message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.menu);
    }

    public static MessageOpenMenu decode(FriendlyByteBuf buffer) {
        return new MessageOpenMenu(buffer.readInt());
    }

    public static void handle(MessageOpenMenu message, CustomPayloadEvent.Context context) {
        int menu = message.menu;
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (ModConfig.rightClickSlotOpenMenu) {
                if (menu == 1) {
                    ModContent.ENDER_BAG.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                } else if (menu == 2) {
                    ModContent.CRAFTING_PLATE.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                }
            }
        });
        context.setPacketHandled(true);
    }
}
