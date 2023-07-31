package org.owari.akari.tech.screen

import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import org.owari.akari.tech.inventory.SimpleInventory

class BurningBoxScreen(handler: BurningBoxScreenHandler) : HandledScreen<BurningBoxScreenHandler>(handler, handler.pi, Text.of("")) {
    override fun drawBackground(matrices: MatrixStack, delta: Float, mouseX: Int, mouseY: Int) {

    }
}

class BurningBoxScreenHandler(syncId: Int, val pi: PlayerInventory, val inv: Inventory = SimpleInventory.ofSize(1)
) : ScreenHandler(ScreenHandlers.SCREEN_HANDLER_TYPE_BURNING_BOX ,syncId) {
    override fun canUse(player: PlayerEntity) = true
}
