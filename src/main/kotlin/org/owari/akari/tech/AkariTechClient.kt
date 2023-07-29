package org.owari.akari.tech

import net.fabricmc.api.*
import org.owari.akari.tech.screen.ScreenHandlers

@Environment(EnvType.CLIENT)
object AkariTechClient : ClientModInitializer {
    override fun onInitializeClient() {
        ScreenHandlers.registerScreenHandlers()
    }
}