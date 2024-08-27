package com.jahirtrap.randomisfits.network.message;

import com.jahirtrap.randomisfits.init.ModConfig;
import com.jahirtrap.randomisfits.init.ModContent;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.network.CustomPayloadEvent;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public record MessageOpenMenu(int menu) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(MODID, "message_open_menu");
    public static final Type<MessageOpenMenu> TYPE = new Type<>(ID);

    public static final StreamCodec<FriendlyByteBuf, MessageOpenMenu> CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            MessageOpenMenu::menu,
            MessageOpenMenu::new
    );

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

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
