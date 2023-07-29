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
        gen.registerSimpleCubeAll(Blocks.ORE_ZINC)
        gen.registerSimpleCubeAll(Blocks.ORE_LEAD)
        gen.registerSimpleCubeAll(Blocks.ORE_SILVER)
        gen.registerSimpleCubeAll(Blocks.ORE_MANGANESE)
        gen.registerSimpleCubeAll(Blocks.ORE_NICKEL)
        gen.registerSimpleCubeAll(Blocks.ORE_MAGNESIUM)
        gen.registerSimpleCubeAll(Blocks.ORE_CHROMIUM)
        gen.registerSimpleCubeAll(Blocks.ORE_RUTILE)
        gen.registerSimpleCubeAll(Blocks.ORE_TITANIUM)
        gen.registerSimpleCubeAll(Blocks.ORE_TUNGSTEN)
        gen.registerSimpleCubeAll(Blocks.ORE_PLATINUM_GROUP)
        // 黄铁矿 (愚人金) 注册为金矿的材质
        gen.registerSingleton(Blocks.ORE_PYRITE, TextureMap.all(Identifier("minecraft", "block/gold_ore")), Models.CUBE_ALL)
        gen.registerSimpleCubeAll(Blocks.ORE_SULFUR)
        gen.registerSimpleCubeAll(Blocks.ORE_APATITE)
        gen.registerSimpleCubeAll(Blocks.ORE_RUBY)
        gen.registerSimpleCubeAll(Blocks.ORE_ANTIMONY)
        gen.registerSimpleCubeAll(Blocks.ORE_LITHIUM)
        gen.registerSimpleCubeAll(Blocks.ORE_GRAPHITE)
        gen.registerSimpleCubeAll(Blocks.ORE_NITERITE)
        gen.registerSimpleCubeAll(Blocks.ORE_URANIUM)

        gen.registerSimpleCubeAll(Blocks.ORE_ALUMINIUM)
        gen.registerSimpleCubeAll(Blocks.ORE_BLACK_SAND)
        gen.registerSimpleCubeAll(Blocks.ORE_ANTHRACITE)
        gen.registerSimpleCubeAll(Blocks.ORE_SALT)
        gen.registerSimpleCubeAll(Blocks.ORE_ROCK_SALT)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        gen.register(Items.INGOT_STEEL, Models.GENERATED)
        gen.register(Items.INGOT_STAINLESS_STEEL, Models.GENERATED)
        gen.register(Items.INGOT_TIN, Models.GENERATED)
        gen.register(Items.INGOT_LEAD, Models.GENERATED)
        gen.register(Items.INGOT_SILVER, Models.GENERATED)
        gen.register(Items.INGOT_ZINC, Models.GENERATED)
        gen.register(Items.INGOT_ALUMINIUM, Models.GENERATED)
        gen.register(Items.INGOT_TITANIUM, Models.GENERATED)
        gen.register(Items.INGOT_TUNGSTEN, Models.GENERATED)
        gen.register(Items.INGOT_CHROMIUM, Models.GENERATED)
        gen.register(Items.INGOT_MANGANESE, Models.GENERATED)
        gen.register(Items.INGOT_NICKEL, Models.GENERATED)
        gen.register(Items.INGOT_MAGNESIUM, Models.GENERATED)
        gen.register(Items.INGOT_ANTIMONY, Models.GENERATED)
        gen.register(Items.INGOT_LITHIUM, Models.GENERATED)
        gen.register(Items.INGOT_NEODYMIUM, Models.GENERATED)
        gen.register(Items.INGOT_INVAR, Models.GENERATED)
        gen.register(Items.INGOT_SODIUM, Models.GENERATED)
        gen.register(Items.INGOT_FERRITE, Models.GENERATED)
    }
}
