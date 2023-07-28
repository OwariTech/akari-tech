package org.owari.akari.tech

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import org.owari.akari.tech.datagen.ChineseLanguageProvider
import org.owari.akari.tech.datagen.ModelProvider

object DataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
		gen.addProvider(ChineseLanguageProvider(gen))
		gen.addProvider(ModelProvider(gen))
	}
}
