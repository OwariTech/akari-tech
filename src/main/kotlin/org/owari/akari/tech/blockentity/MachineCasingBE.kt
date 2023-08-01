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
import net.minecraft.text.TranslatableText
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.machine.MachineTier
import org.owari.akari.tech.screen.SimpleScreenHandler

class MachineCasingBE(pos: BlockPos, state: BlockState) : BlockEntity(ATBlockEntities.MACHINE_CASING_TYPE, pos, state), NamedScreenHandlerFactory {
    constructor(pos: BlockPos, state: BlockState, initParts: DefaultedList<ItemStack>) : this(pos, state) {
        parts = initParts
    }

    val tier = 0 //state[Blocks.CASING_TIER_PROPERTY] ?: 0
    var parts = DefaultedList.ofSize(1 + MachineTier.getGuideSlot(tier) + MachineTier.getPartSlot(tier), ItemStack.EMPTY)
        private set

    override fun writeNbt(nbt: NbtCompound) {
        Inventories.writeNbt(nbt, parts)
    }

    override fun readNbt(nbt: NbtCompound) {
        Inventories.readNbt(nbt, parts)
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return SimpleScreenHandler(syncId, inv, SimpleInventory.of(parts))
    }

    override fun getDisplayName() = TranslatableText(cachedState.block.translationKey)

}
