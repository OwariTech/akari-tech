package org.owari.akari.tech.machine

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.block.MachineBlock
import org.owari.akari.tech.blockentity.*
import org.owari.akari.tech.screen.BurningBoxScreenHandler

object MachineTypes {
    @JvmStatic val BURNING_BOX = MachineType("burning_box", mapOf("thermal_conductor" to 1,),
        lazy { Blocks.MACHINE_BURNING_BOX }, lazy { BlockEntities.MACHINE_BURNING_BOX_TYPE },
        ::BurningBoxBE, BurningBoxBE::tick, ::BurningBoxScreenHandler)
}

class MachineType<T: MachineBE<T>>(
    val name: String,
    val requirements: Map<String, Int>,
    block: Lazy<MachineBlock<T>>,
    bet: Lazy<BlockEntityType<T>>,
    val beFactory: (BlockPos, BlockState) -> T,
    val ticker: BlockEntityTicker<T>,
    val shFactory: (Int, PlayerInventory) -> ScreenHandler,
) {
    val block by block
    val bet by bet
}
