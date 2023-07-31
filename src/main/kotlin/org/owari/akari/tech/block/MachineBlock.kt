package org.owari.akari.tech.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import org.owari.akari.tech.blockentity.MachineBE
import org.owari.akari.tech.blockentity.MachineCasingBE
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.machine.MachineType

abstract class MachineBlock<BE : MachineBE<BE>>(val type: MachineType<BE>) : HorizontalFacingBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f, 10.0f)), BlockEntityProvider {
    init {
        defaultState = defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.HORIZONTAL_FACING)
        //builder.add(Blocks.CASING_TIER_PROPERTY)
        //builder.add(Blocks.WORKING_PROPERTY)
    }

    override fun getPlacementState(ctx: ItemPlacementContext) = defaultState.with(Properties.HORIZONTAL_FACING, ctx.playerFacing.opposite)

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BE = type.beFactory(pos, state)

    override fun <T : BlockEntity> getTicker(world: World, state: BlockState, bet: BlockEntityType<T>) = if(bet == type.bet) type.ticker as BlockEntityTicker<T> else null

    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        if(world.isClient) return ActionResult.SUCCESS
        if(player.getStackInHand(hand).item == Items.TOOL_ENGINEERING_HAMMER) {
            val be = world.getBlockEntity(pos) as? MachineBE<*> ?: return ActionResult.FAIL
            val newState = Blocks.MACHINE_CASING.defaultState
            world.setBlockState(pos, newState)
            world.addBlockEntity(MachineCasingBE(pos, newState, be.machineParts))
        } else {
            val shf = state.createScreenHandlerFactory(world, pos)
            shf?.let { player.openHandledScreen(it) }
        }
        return ActionResult.SUCCESS
    }

    override fun createScreenHandlerFactory(state: BlockState, world: World, pos: BlockPos): NamedScreenHandlerFactory? {
        return world.getBlockEntity(pos) as? NamedScreenHandlerFactory
    }
}
