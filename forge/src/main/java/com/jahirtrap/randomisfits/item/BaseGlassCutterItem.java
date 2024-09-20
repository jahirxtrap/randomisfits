package com.jahirtrap.randomisfits.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static com.jahirtrap.randomisfits.RandomisfitsMod.MODID;

public class BaseGlassCutterItem extends DiggerItem {
    private static final TagKey<Block> MINEABLE_WITH_GLASS_CUTTER = TagKey.create(Registries.BLOCK, new ResourceLocation(MODID, "mineable/glass_cutter"));

    public BaseGlassCutterItem(Tier tier, Properties properties) {
        super(tier, MINEABLE_WITH_GLASS_CUTTER, properties.attributes(createAttributes(tier, -1f, -2f)));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.is(MINEABLE_WITH_GLASS_CUTTER) && Block.getDrops(state, (ServerLevel) level, pos, null, entity, stack).isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(state.getBlock()));
            itemEntity.setDefaultPickUpDelay();
            if (!level.isClientSide()) level.addFreshEntity(itemEntity);
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }
}
