package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.*
import net.minecraft.util.Identifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.modId
import java.util.*

class ModelProvider(gen: FabricDataGenerator) : FabricModelProvider(gen) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        gen.registerSimpleCubeAll(Blocks.ORE_TIN)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(Items.INGOT_TIN, Models.GENERATED)

        gen.register(Blocks.ORE_TIN_ITEM, Model(Optional.of(Identifier(modId, "block/ore_tin")), Optional.empty()))
    }
}
