package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.*
import net.minecraft.util.Identifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items

class ModelProvider(gen: FabricDataGenerator) : FabricModelProvider(gen) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        (Blocks.ORE_ALL - Blocks.ORE_PYRITE).forEach(gen::registerSimpleCubeAll)
        // 黄铁矿 (愚人金) 注册为金矿的材质
        gen.registerSingleton(Blocks.ORE_PYRITE, TextureMap.all(Identifier("minecraft", "block/gold_ore")), Models.CUBE_ALL)
        gen.registerSimpleCubeAll(Blocks.MACHINE_CASING)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        Items.INGOT_ALL.forEach { gen.register(it, Models.GENERATED) }
        Items.TOOL_ALL.forEach { gen.register(it, Models.HANDHELD) }
        gen.register(Items.BLUEPRINT_EMPTY, Models.GENERATED)
        Items.BLUEPRINT_ALL.forEach { gen.register(it, Items.BLUEPRINT_EMPTY, Models.GENERATED) }
    }
}
