package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.*
import net.minecraft.state.property.Properties
import net.minecraft.util.Identifier
import net.minecraft.util.math.Direction
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.item.ATItems
import org.owari.akari.tech.modId

class ModelProvider(gen: FabricDataGenerator) : FabricModelProvider(gen) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        (ATBlocks.ORE_ALL - ATBlocks.ORE_PYRITE).forEach(gen::registerSimpleCubeAll)
        // 黄铁矿 (愚人金) 注册为金矿的材质
        gen.registerSingleton(ATBlocks.ORE_PYRITE, TextureMap.all(Identifier("minecraft", "block/gold_ore")), Models.CUBE_ALL)
        gen.registerSimpleCubeAll(ATBlocks.MACHINE_CASING)

        val modelOn = Models.ORIENTABLE.upload(ATBlocks.MACHINE_BURNING_BOX, "_on",
            TextureMap()
                .put(TextureKey.PARTICLE, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.SIDE, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.TOP, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.FRONT, Identifier(modId, "block/machine_burning_box_on")),
            gen.modelCollector
        )
        val modelOff = Models.ORIENTABLE.upload(ATBlocks.MACHINE_BURNING_BOX, "_off",
            TextureMap()
                .put(TextureKey.PARTICLE, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.SIDE, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.TOP, Identifier(modId, "block/machine_casing"))
                .put(TextureKey.FRONT, Identifier(modId, "block/machine_burning_box_off")),
            gen.modelCollector
        )
        val bvm = BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, ATBlocks.WORKING_PROPERTY)
            .register(Direction.NORTH, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn))
            .register(Direction.EAST, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.SOUTH, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, true, BlockStateVariant.create().put(VariantSettings.MODEL, modelOn).put(VariantSettings.Y, VariantSettings.Rotation.R270))
            .register(Direction.NORTH, false, BlockStateVariant.create().put(VariantSettings.MODEL, modelOff))
            .register(Direction.EAST, false, BlockStateVariant.create().put(VariantSettings.MODEL, modelOff).put(VariantSettings.Y, VariantSettings.Rotation.R90))
            .register(Direction.SOUTH, false, BlockStateVariant.create().put(VariantSettings.MODEL, modelOff).put(VariantSettings.Y, VariantSettings.Rotation.R180))
            .register(Direction.WEST, false, BlockStateVariant.create().put(VariantSettings.MODEL, modelOff).put(VariantSettings.Y, VariantSettings.Rotation.R270))
        gen.blockStateCollector.accept(VariantsBlockStateSupplier.create(ATBlocks.MACHINE_BURNING_BOX).coordinate(bvm))
        gen.registerParentedItemModel(ATBlocks.MACHINE_BURNING_BOX, Identifier(modId, "block/machine_burning_box_off"))
    }

    override fun generateItemModels(gen: ItemModelGenerator) {
        ATItems.INGOT_ALL.forEach { gen.register(it, Models.GENERATED) }
        ATItems.TOOL_ALL.forEach { gen.register(it, Models.HANDHELD) }
        gen.register(ATItems.BLUEPRINT_EMPTY, Models.GENERATED)
        ATItems.BLUEPRINT_ALL.forEach { gen.register(it, ATItems.BLUEPRINT_EMPTY, Models.GENERATED) }
        gen.register(ATItems.TECHNIQUE_INSTRUCTION_EMPTY, Models.GENERATED)
        ATItems.TECHNIQUE_INSTRUCTION_ALL.forEach { gen.register(it, ATItems.TECHNIQUE_INSTRUCTION_EMPTY, Models.GENERATED) }
    }
}
