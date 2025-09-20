package com.jahirtrap.randomisfits.item;

import com.jahirtrap.randomisfits.init.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BaseGlassCutterItem extends DiggerItem {
    public BaseGlassCutterItem(ToolMaterial material, Properties properties) {
        super(material, ModTags.Blocks.MINEABLE_WITH_GLASS_CUTTER, 0, -2f, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.is(ModTags.Blocks.MINEABLE_WITH_GLASS_CUTTER) && Block.getDrops(state, (ServerLevel) level, pos, null, entity, stack).isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(state.getBlock()));
            itemEntity.setDefaultPickUpDelay();
            if (!level.isClientSide()) level.addFreshEntity(itemEntity);
        }

        return super.mineBlock(stack, level, state, pos, entity);
    }
}
