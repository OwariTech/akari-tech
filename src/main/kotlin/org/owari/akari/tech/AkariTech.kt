package org.owari.akari.tech

import net.fabricmc.api.ModInitializer
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.blockentity.ATBlockEntities
import org.owari.akari.tech.item.ATItems
import org.owari.akari.tech.worldgen.OreGenerators
import org.slf4j.LoggerFactory

const val modId = "akari-tech"

object AkariTech : ModInitializer {
    private val logger = LoggerFactory.getLogger("akari-tech")

	override fun onInitialize() {
		logger.info("Loading mod [Akari Tech]")

		ATItems.registerItems()
		ATBlocks.registerBlocks()
		ATBlockEntities.registerBlockEntities()
		OreGenerators.registerOreGenerators()
	}
}
