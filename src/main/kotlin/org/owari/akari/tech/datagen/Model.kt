package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.*
import net.minecraft.util.Identifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.modId

class ModelProvider(gen: FabricDataGenerator) : FabricModelProvider(gen) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        (Blocks.ORE_ALL - Blocks.ORE_PYRITE).forEach(gen::registerSimpleCubeAll)
        // 黄铁矿 (愚人金) 注册为金矿的材质
        gen.registerSingleton(Blocks.ORE_PYRITE, TextureMap.all(Identifier("minecraft", "block/gold_ore")), Models.CUBE_ALL)
        gen.registerSimpleCubeAll(Blocks.MACHINE_CASING)
        val burningBoxMap = TextureMap()
            .put(TextureKey.TOP, Identifier(modId, "block/machine_casing"))
            .put(TextureKey.SIDE, Identifier(modId, "block/machine_casing"))
            .put(TextureKey.FRONT, Identifier(modId, "block/machine_burning_box_off"))
        gen.registerNorthDefaultHorizontalRotatable(Blocks.MACHINE_BURNING_BOX, burningBoxMap)

    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        Items.INGOT_ALL.forEach { gen.register(it, Models.GENERATED) }
        Items.TOOL_ALL.forEach { gen.register(it, Models.HANDHELD) }
        gen.register(Items.BLUEPRINT_EMPTY, Models.GENERATED)
        Items.BLUEPRINT_ALL.forEach { gen.register(it, Items.BLUEPRINT_EMPTY, Models.GENERATED) }
        gen.register(Items.TECHNIQUE_INSTRUCTION_EMPTY, Models.GENERATED)
        Items.TECHNIQUE_INSTRUCTION_ALL.forEach { gen.register(it, Items.TECHNIQUE_INSTRUCTION_EMPTY, Models.GENERATED) }
    }
}
