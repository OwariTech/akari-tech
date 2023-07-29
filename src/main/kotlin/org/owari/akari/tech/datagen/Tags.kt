package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.modId

class ItemTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Item>(gen, Registry.ITEM, "item") {
    override fun generateTags() {
        Items.INGOT_ALL.forEach(getOrCreateTagBuilder(TagKeys.INGOT)::add)
    }
}

class BlockTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Block>(gen, Registry.BLOCK, "block") {
    override fun generateTags() {
        (Blocks.ORE_ALL - Blocks.ORE_BLACK_SAND).forEach(getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)::add)
        listOf(
            Blocks.ORE_TIN, Blocks.ORE_ZINC, Blocks.ORE_LEAD, Blocks.ORE_SULFUR, Blocks.ORE_APATITE, Blocks.ORE_GRAPHITE,
            Blocks.ORE_NITERITE, Blocks.ORE_ALUMINIUM, Blocks.ORE_SALT, Blocks.ORE_ROCK_SALT,
        ).forEach(getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)::add)
        listOf(
            Blocks.ORE_SILVER, Blocks.ORE_MANGANESE, Blocks.ORE_NICKEL, Blocks.ORE_MAGNESIUM, Blocks.ORE_RUTILE,
            Blocks.ORE_TITANIUM, Blocks.ORE_TUNGSTEN, Blocks.ORE_PLATINUM_GROUP, Blocks.ORE_PYRITE, Blocks.ORE_RUBY,
            Blocks.ORE_ANTIMONY, Blocks.ORE_LITHIUM, Blocks.ORE_URANIUM,
        ).forEach(getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)::add)

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(Blocks.ORE_BLACK_SAND)
    }
}

object TagKeys {
    @JvmStatic val INGOT: TagKey<Item> = TagKey.of(Registry.ITEM_KEY, Identifier(modId, "ingot"))
}
