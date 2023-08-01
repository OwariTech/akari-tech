package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.text.TranslatableText
import net.minecraft.util.ItemScatterer
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.datagen.translationKey
import org.owari.akari.tech.machine.MachineType

abstract class MachineBE<T : MachineBE<T>>(@JvmField val machineType: MachineType<T>, pos: BlockPos, state: BlockState) : BlockEntity(machineType.bet, pos, state), NamedScreenHandlerFactory  {
    var machineParts = DefaultedList.ofSize(0, ItemStack.EMPTY)
        private set
    var working = false
    //@JvmField var casingTier = 0

    override fun writeNbt(nbt: NbtCompound) {
        nbt.putBoolean("working", working)
        val parts = NbtCompound()
        Inventories.writeNbt(parts, machineParts)
        nbt.put("parts", parts)
    //    nbt.putInt("machine_casing_tier", casingTier)
    }

    override fun readNbt(nbt: NbtCompound) {
        working = nbt.getBoolean("working")
        Inventories.readNbt(nbt.getCompound("parts"), machineParts)
    //    casingTier = nbt.getInt("machine_casing_tier")
    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener> = BlockEntityUpdateS2CPacket.create(this)

    override fun toInitialChunkDataNbt(): NbtCompound = createNbt()

    override fun getDisplayName() = TranslatableText(machineType.translationKey)

    abstract fun tick(world: World, pos: BlockPos, state: BlockState)

    open fun drop(world: World, pos: BlockPos) {
        ItemScatterer.spawn(world, pos, machineParts)
    }
}
