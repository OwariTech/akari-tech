package org.owari.akari.tech.screen

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.screen.ScreenHandler
import org.owari.akari.tech.inventory.SimpleInventory

class BurningBoxScreenHandler(
    syncId: Int, pi: PlayerInventory, inv: Inventory = SimpleInventory.ofSize(9)
) : ScreenHandler(ScreenHandlers.SCREEN_HANDLER_TYPE_SIMPLE ,syncId) {
    override fun canUse(player: PlayerEntity) = true
}
