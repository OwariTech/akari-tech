package org.owari.akari.tech.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.*
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.blockentity.MachineBE
import org.owari.akari.tech.machine.MachineType

abstract class MachineBlock<BE : MachineBE>(type: Lazy<MachineType<BE, *>>) : HorizontalFacingBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f, 10.0f)), BlockEntityProvider {
    val machineType by type

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.HORIZONTAL_FACING)
        //builder.add(Blocks.CASING_TIER_PROPERTY)
        //builder.add(Blocks.WORKING_PROPERTY)
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BE = machineType.createBlockEntity(pos, state)

    override fun getPlacementState(ctx: ItemPlacementContext) = super.getPlacementState(ctx)?.with(Properties.HORIZONTAL_FACING, ctx.playerFacing.opposite)

    override fun <T : BlockEntity> getTicker(world: World, state: BlockState, type: BlockEntityType<T>): BlockEntityTicker<T>? {
        return if(type == machineType.blockEntityType) machineType.ticker as BlockEntityTicker<T> else null
    }
}
