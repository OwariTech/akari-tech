package org.owari.akari.tech.inventory

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventories
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.util.collection.DefaultedList

interface SimpleInventory : Inventory {
    val items: DefaultedList<ItemStack>

    override fun clear() {
        items.clear()
    }

    override fun size() = items.size

    override fun isEmpty() = items.all { it.isEmpty }

    override fun getStack(slot: Int) = items[slot]

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        val result = Inventories.splitStack(items, slot, amount)
        if (!result.isEmpty) markDirty()
        return result;
    }

    override fun removeStack(slot: Int): ItemStack {
        return Inventories.removeStack(items, slot)
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        items[slot] = stack
        if (stack.count > maxCountPerStack) {
            stack.count = maxCountPerStack;
        }
    }

    override fun markDirty() { }

    override fun canPlayerUse(player: PlayerEntity) = true

    companion object {
        @JvmStatic fun of(items: DefaultedList<ItemStack>): SimpleInventory = object : SimpleInventory { override val items = items }

        @JvmStatic fun ofSize(size: Int) = of(DefaultedList.ofSize(size, ItemStack.EMPTY))
    }
}
