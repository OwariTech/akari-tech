package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.PropertyDelegate
import net.minecraft.util.ItemScatterer
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.machine.MachineTypes
import org.owari.akari.tech.machine.Thermal.burnData
import org.owari.akari.tech.machine.ThermalSupplier
import org.owari.akari.tech.screen.BurningBoxScreenHandler

class BurningBoxBE(pos: BlockPos, state: BlockState) : MachineBE<BurningBoxBE>(MachineTypes.BURNING_BOX, pos, state), ThermalSupplier {
    val items = SimpleInventory.ofSize(1)
    override var temperature: Int = 0; private set
    private var burnTime: Int = 0
    private val guiDelegate = object : PropertyDelegate {
        override fun get(index: Int) = when(index) {
            0 -> temperature
            1 -> burnTime
            else -> 0
        }
        override fun set(index: Int, value: Int) {
            when(index) {
                0 -> temperature = value
                1 -> burnTime = value
            }
        }
        override fun size() = 2
    }

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

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity) = BurningBoxScreenHandler(syncId, inv, items, guiDelegate)

    override fun drop(world: World, pos: BlockPos) {
        super.drop(world, pos)
        ItemScatterer.spawn(world, pos, items.items)
    }

    override fun tick(world: World, pos: BlockPos, state: BlockState) {
        if(working) {
            --burnTime
        }

        if(burnTime <= 0) {
            temperature = 0
            burnData[items.getStack(0).item]?.let{
                burnTime = it.burnTime
                temperature = it.burnTemperature
                items.removeStack(0, 1)
                markDirty()
            }
        }

        if(working != burnTime > 0) {
            working = burnTime > 0
            world.setBlockState(pos, state.with(ATBlocks.WORKING_PROPERTY, working))
            markDirty()
        }
    }
}
