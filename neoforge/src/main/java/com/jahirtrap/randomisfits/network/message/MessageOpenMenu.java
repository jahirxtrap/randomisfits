package com.jahirtrap.randomisfits.network.message;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public record MessageOpenMenu(int menu) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MODID, "message_open_menu");

    @Override
    public void write(FriendlyByteBuf buffer) {
        buffer.writeInt(menu);
    }

    public MessageOpenMenu(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public static void handle(MessageOpenMenu message, PlayPayloadContext context) {
        int menu = message.menu;
        context.workHandler().execute(() -> {
            if (ModConfig.rightClickSlotOpenMenu && context.player().orElse(null) instanceof ServerPlayer player) {
                if (menu == 1) {
                    ModContent.ENDER_BAG.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                } else if (menu == 2) {
                    ModContent.CRAFTING_PLATE.get().use(player.level(), player, InteractionHand.MAIN_HAND);
                }
            }
        });
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}
