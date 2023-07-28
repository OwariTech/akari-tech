package org.owari.akari.tech

import net.fabricmc.api.ModInitializer
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.worldgen.OreGenerators
import org.slf4j.LoggerFactory

const val modId = "akari-tech"

object AkariTech : ModInitializer {
    private val logger = LoggerFactory.getLogger("akari-tech")

	override fun onInitialize() {
		logger.info("Loading mod [Akari Tech]")

		Items.registerItems()
		Blocks.registerBlocks()
		OreGenerators.registerOreGenerators()
	}
}
