package org.owari.akari.tech.screen

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.util.Identifier
import org.owari.akari.tech.modId

object ScreenHandlers {
    fun registerScreenHandlers() {
        HandledScreens.register(SCREEN_HANDLER_TYPE_SIMPLE, ::SimpleScreen)
        HandledScreens.register(SCREEN_HANDLER_TYPE_BURNING_BOX, ::BurningBoxScreen)
    }

    @JvmStatic val SCREEN_HANDLER_TYPE_SIMPLE = ScreenHandlerRegistry.registerSimple(Identifier(modId, "screen_handler_simple"), ::SimpleScreenHandler)
    @JvmStatic val SCREEN_HANDLER_TYPE_BURNING_BOX = ScreenHandlerRegistry.registerSimple(Identifier(modId, "screen_handler_burning_box"), ::BurningBoxScreenHandler)
}
