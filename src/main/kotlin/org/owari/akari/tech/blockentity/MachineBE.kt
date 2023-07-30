package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.TranslatableText
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.machine.MachineType

abstract class MachineBE(@JvmField val machineType: MachineType<*, *>, pos: BlockPos, state: BlockState) : BlockEntity(machineType.blockEntityType, pos, state), NamedScreenHandlerFactory {
    //@JvmField var casingTier = 0

    override fun writeNbt(nbt: NbtCompound) {
    //    nbt.putInt("machine_casing_tier", casingTier)
        super.writeNbt(nbt)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
    //    casingTier = nbt.getInt("machine_casing_tier")
    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener> = BlockEntityUpdateS2CPacket.create(this)

    override fun toInitialChunkDataNbt(): NbtCompound = createNbt()

    override fun getDisplayName() = TranslatableText(machineType.translationKey)

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
        TODO("Not yet implemented")
    }
}
