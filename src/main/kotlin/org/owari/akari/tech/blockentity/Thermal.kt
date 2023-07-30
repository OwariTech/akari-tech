package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.machine.MachineTypes
import org.owari.akari.tech.machine.ThermalSupplier

class BurningBoxBE(pos: BlockPos, state: BlockState) : MachineBE(MachineTypes.BURNING_BOX, pos, state), NamedScreenHandlerFactory, ThermalSupplier {
    override var temperature: Int = 0; private set
    val items = SimpleInventory.ofSize(1)

    companion object {
        fun tick(world: World, pos: BlockPos, state: BlockState, be2: BurningBoxBE) {

        }
    }
}
