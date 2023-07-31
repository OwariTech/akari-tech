package org.owari.akari.tech.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot
import org.owari.akari.tech.inventory.SimpleInventory

class SimpleScreenHandler(syncId: Int, pi: PlayerInventory, val inv: Inventory = SimpleInventory.ofSize(9))
    : ScreenHandler(ScreenHandlers.SCREEN_HANDLER_TYPE_SIMPLE ,syncId) {
    override fun canUse(player: PlayerEntity) = true

    init {
        inv.onOpen(pi.player)
        // inv
        for(m in 0..2) {
            for(l in 0..2) {
                addSlot(Slot(inv, l + m * 3, 62 + l * 18, 17 + m * 18))
            }
        }
        // player inv
        for(m in 0..2) {
            for(l in 0..8) {
                addSlot(Slot(pi, l + m * 9 + 9, 8 + l * 18, 84 + m * 18))
            }
        }
        // player hotbar
        for(m in 0..8) {
            addSlot(Slot(pi, m, 8 + m * 18, 142))
        }
    }

    override fun transferSlot(player: PlayerEntity, index: Int): ItemStack {
        var result = ItemStack.EMPTY
        val slot = slots[index]

        if (!slot.hasStack()) return result
        val original = slot.stack
        result = original.copy()

        if (index < inv.size()) {
            if (!insertItem(original, inv.size(), slots.size, true)) return ItemStack.EMPTY
        } else {
            if (!insertItem(original, 0, slots.size, false)) return ItemStack.EMPTY
        }

        if(original.isEmpty) slot.stack = ItemStack.EMPTY
        else slot.markDirty()
        return result
    }
}
