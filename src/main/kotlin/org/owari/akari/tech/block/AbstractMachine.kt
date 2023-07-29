package org.owari.akari.tech.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.*
import net.minecraft.state.StateManager
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

abstract class AbstractMachine<BE : BlockEntity?>(val bet: BlockEntityType<BE>, val ticker: BlockEntityTicker<BE>)
    : BlockWithEntity(FabricBlockSettings.of(Material.METAL).strength(3.0f, 10.0f)) {
    override fun getRenderType(state: BlockState) = BlockRenderType.MODEL

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Blocks.CASING_TIER_PROPERTY)
    }

    abstract override fun createBlockEntity(pos: BlockPos, state: BlockState): BE

    override fun <T : BlockEntity> getTicker(world: World, state: BlockState, type: BlockEntityType<T>): BlockEntityTicker<T>? {
        return checkType(type, bet, ticker)
    }
}