package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.inventory.Inventories
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.machine.MachineTypes
import org.owari.akari.tech.machine.ThermalSupplier

class BurningBoxBE(pos: BlockPos, state: BlockState) : MachineBE<BurningBoxBE>(MachineTypes.BURNING_BOX, pos, state), NamedScreenHandlerFactory, ThermalSupplier {
    override var temperature: Int = 0; private set
    val items = SimpleInventory.ofSize(1)

    override fun writeNbt(nbt: NbtCompound) {
        super.writeNbt(nbt)
        nbt.putInt("temperature", temperature)
        Inventories.writeNbt(nbt, items.items)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        temperature = nbt.getInt("temperature")
        Inventories.readNbt(nbt, items.items)
    }

    companion object {
        fun tick(world: World, pos: BlockPos, state: BlockState, be2: BurningBoxBE) {

        }
    }
}
