package org.owari.akari.tech

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import org.owari.akari.tech.datagen.*

object DataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
		gen.addProvider(ChineseLanguageProvider(gen))
		gen.addProvider(EnglishLanguageProvider(gen))
		gen.addProvider(ModelProvider(gen))
		gen.addProvider(RecipesProvider(gen))
		gen.addProvider(LootsProvider(gen))
		gen.addProvider(AdvancementsProvider(gen))
		gen.addProvider(ItemTagsProvider(gen))
		gen.addProvider(BlockTagsProvider(gen))
	}
}
