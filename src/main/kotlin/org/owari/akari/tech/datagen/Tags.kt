package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.modId

class ItemTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Item>(gen, Registry.ITEM, "item") {
    override fun generateTags() {
        getOrCreateTagBuilder(Tags.INGOT).add(Items.INGOT_TIN)
    }
}

class BlockTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Block>(gen, Registry.BLOCK, "block") {
    override fun generateTags() {

    }
}

object Tags {
    @JvmStatic val INGOT: TagKey<Item> = TagKey.of(Registry.ITEM_KEY, Identifier(modId, "ingot"))
}
