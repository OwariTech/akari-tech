package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.loot.LootTable
import net.minecraft.loot.context.LootContextTypes
import net.minecraft.util.Identifier
import java.util.function.BiConsumer

class LootsProvider(gen: FabricDataGenerator) : SimpleFabricLootTableProvider(gen, LootContextTypes.BLOCK) {
    override fun accept(t: BiConsumer<Identifier, LootTable.Builder>?) {

    }
}
