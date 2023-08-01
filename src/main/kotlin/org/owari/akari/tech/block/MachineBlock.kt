package org.owari.akari.tech.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.*
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.tag.BlockTags
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World
import org.owari.akari.tech.blockentity.MachineBE
import org.owari.akari.tech.blockentity.MachineCasingBE
import org.owari.akari.tech.item.ATItems
import org.owari.akari.tech.machine.MachineType

abstract class MachineBlock<T : MachineBE<T>>(val type: MachineType<T>) : HorizontalFacingBlock(
    FabricBlockSettings.of(Material.METAL).strength(3.0f, 10.0f).requiresTool()
        .luminance { if(it[ATBlocks.WORKING_PROPERTY]) 15 else 0 }), BlockEntityProvider {
    init {
        defaultState = defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(ATBlocks.WORKING_PROPERTY, false)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.HORIZONTAL_FACING)
        builder.add(ATBlocks.WORKING_PROPERTY)
        //builder.add(ATBlocks.CASING_TIER_PROPERTY)
    }

    override fun getPlacementState(ctx: ItemPlacementContext) = defaultState.with(Properties.HORIZONTAL_FACING, ctx.playerFacing.opposite)

    override fun createBlockEntity(pos: BlockPos, state: BlockState): T = type.beFactory(pos, state)

    override fun <T : BlockEntity> getTicker(world: World, state: BlockState, bet: BlockEntityType<T>): BlockEntityTicker<T>? {
        if(world.isClient) return null
        return if(bet == type.bet) BlockEntityTicker<T> { w: World, p: BlockPos, s: BlockState, be: T -> if(be is MachineBE<*>) be.tick(w, p, s) } else null
    }

    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        if(world.isClient) return ActionResult.SUCCESS
        if(player.getStackInHand(hand).item == ATItems.TOOL_ENGINEERING_HAMMER) {
            world.setBlockState(pos, ATBlocks.MACHINE_CASING.defaultState)
        } else {
            val shf = state.createScreenHandlerFactory(world, pos)
            shf?.let { player.openHandledScreen(it) }
        }
        return ActionResult.SUCCESS
    }

    override fun createScreenHandlerFactory(state: BlockState, world: World, pos: BlockPos): NamedScreenHandlerFactory? {
        return world.getBlockEntity(pos) as? NamedScreenHandlerFactory
    }

    override fun onStateReplaced(state: BlockState, world: World, pos: BlockPos, newState: BlockState, moved: Boolean) {
        val be = world.getBlockEntity(pos) as MachineBE<T>
        world.removeBlockEntity(pos)
        if(newState.block == ATBlocks.MACHINE_CASING) {
            world.addBlockEntity(MachineCasingBE(pos, newState, be.machineParts))
        } else if (newState.isAir){
            be.drop(world, pos)
        }
    }
}
