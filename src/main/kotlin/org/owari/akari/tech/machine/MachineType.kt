package org.owari.akari.tech.machine

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.blockentity.*
import org.owari.akari.tech.screen.ScreenHandlers

object MachineTypes {
    @JvmStatic val BURNING_BOX = MachineType("burning_box", BlockEntities.MACHINE_BURNING_BOX_TYPE, ::BurningBoxBE, mapOf(), BurningBoxBE::tick, ScreenHandlers.SCREEN_HANDLER_TYPE_BURNING_BOX)
}

class MachineType<T : MachineBE, SH: ScreenHandler>(
    val name: String,
    val blockEntityType: BlockEntityType<T>,
    val blockEntityCreator: (BlockPos, BlockState) -> T,
    val requirements: Map<String, Int>,
    val ticker: BlockEntityTicker<T>,
    val guiHandler: ScreenHandlerType<SH>
) {
    val translationKey = "machine_type.$name"

    fun createBlockEntity(pos: BlockPos, state: BlockState): T = blockEntityCreator(pos, state)

}

