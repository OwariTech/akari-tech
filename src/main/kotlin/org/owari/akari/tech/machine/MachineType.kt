package org.owari.akari.tech.machine

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.block.MachineBlock
import org.owari.akari.tech.blockentity.*
import org.owari.akari.tech.screen.BurningBoxScreenHandler

object MachineTypes {
    @JvmStatic val BURNING_BOX = MachineType("burning_box", mapOf("thermal_conductor" to 1,),
        lazy { ATBlocks.MACHINE_BURNING_BOX }, lazy { ATBlockEntities.MACHINE_BURNING_BOX_TYPE }, ::BurningBoxBE)
}

class MachineType<T: MachineBE<T>>(
    val name: String,
    val requirements: Map<String, Int>,
    block: Lazy<MachineBlock<T>>,
    bet: Lazy<BlockEntityType<T>>,
    val beFactory: (BlockPos, BlockState) -> T,
) {
    val block by block
    val bet by bet
}
