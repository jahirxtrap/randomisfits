package com.jahirtrap.randomisfits.network.message;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.InteractionHand;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class MessageOpenMenu {
    public static final ResourceLocation ID = new ResourceLocation(MODID, "message_open_menu");

    public static void handle(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buffer, PacketSender sender) {
        int menu = buffer.readInt();
        server.execute(() -> {
            if (ModConfig.rightClickSlotOpenMenu) {
                if (menu == 1) {
                    ModContent.ENDER_BAG.use(player.level, player, InteractionHand.MAIN_HAND);
                } else if (menu == 2) {
                    ModContent.CRAFTING_PLATE.use(player.level, player, InteractionHand.MAIN_HAND);
                }
            }
        });
    }
}
