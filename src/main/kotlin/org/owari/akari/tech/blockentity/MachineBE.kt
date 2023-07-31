package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.text.TranslatableText
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.datagen.translationKey
import org.owari.akari.tech.machine.MachineType

abstract class MachineBE<T : MachineBE<T>>(@JvmField val machineType: MachineType<T>, pos: BlockPos, state: BlockState) : BlockEntity(machineType.bet, pos, state), NamedScreenHandlerFactory  {
    constructor(machineType: MachineType<T>, pos: BlockPos, state: BlockState, initParts: DefaultedList<ItemStack>) : this(machineType, pos, state) {
        machineParts = initParts
    }

    var machineParts = DefaultedList.ofSize(0, ItemStack.EMPTY)
        private set
    //@JvmField var casingTier = 0

    override fun writeNbt(nbt: NbtCompound) {
        val parts = NbtCompound()
        Inventories.writeNbt(parts, machineParts)
        nbt.put("parts", parts)
    //    nbt.putInt("machine_casing_tier", casingTier)
    }

    override fun readNbt(nbt: NbtCompound) {
        val parts = nbt.getCompound("parts")
        Inventories.readNbt(parts, machineParts)
        Inventories.readNbt(nbt, machineParts)
    //    casingTier = nbt.getInt("machine_casing_tier")
    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener> = BlockEntityUpdateS2CPacket.create(this)

    override fun toInitialChunkDataNbt(): NbtCompound = createNbt()

    override fun getDisplayName() = TranslatableText(machineType.translationKey)

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity) = machineType.shFactory(syncId, inv)
}
