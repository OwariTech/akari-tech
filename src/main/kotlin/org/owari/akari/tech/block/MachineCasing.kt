package org.owari.akari.tech.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.blockentity.BlockEntities
import org.owari.akari.tech.blockentity.MachineCasingBE

class MachineCasing : BlockWithEntity(FabricBlockSettings.of(Material.METAL).strength(3.0f, 10.0f)) {
    override fun getRenderType(state: BlockState) = BlockRenderType.MODEL

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Blocks.CASING_TIER_PROPERTY)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState) = MachineCasingBE(pos, state)

    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {

        return ActionResult.SUCCESS
    }

}
