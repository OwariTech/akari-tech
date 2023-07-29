package org.owari.akari.tech.blockentity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.machine.MachineTier
import org.owari.akari.tech.modId
import org.owari.akari.tech.screen.SimpleScreenHandler

class MachineCasingBE(pos: BlockPos, state: BlockState) : BlockEntity(BlockEntities.MACHINE_CASING_TYPE, pos, state),
    SimpleInventory, NamedScreenHandlerFactory {

    val tier = state[Blocks.CASING_TIER_PROPERTY] ?: 0
    override val items = DefaultedList.ofSize(1 + MachineTier.getGuideSlot(tier) + MachineTier.getPartSlot(tier), ItemStack.EMPTY)

    override fun markDirty() {
        super<BlockEntity>.markDirty()
    }

    override fun writeNbt(nbt: NbtCompound) {
        Inventories.writeNbt(nbt, items)
        super.writeNbt(nbt)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, items)
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return SimpleScreenHandler(syncId, inv, this)
    }

    override fun getDisplayName() = TranslatableText(cachedState.block.translationKey)

}
