package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.item.ATItems
import org.owari.akari.tech.modId

class ItemTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Item>(gen, Registry.ITEM, "item") {
    override fun generateTags() {
        ATItems.INGOT_ALL.forEach(getOrCreateTagBuilder(TagKeys.INGOT)::add)
    }
}

class BlockTagsProvider(gen: FabricDataGenerator) : FabricTagProvider<Block>(gen, Registry.BLOCK, "block") {
    override fun generateTags() {
        (ATBlocks.ORE_ALL - ATBlocks.ORE_BLACK_SAND).forEach(getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)::add)
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(ATBlocks.ORE_BLACK_SAND)
        listOf(
            ATBlocks.ORE_TIN, ATBlocks.ORE_ZINC, ATBlocks.ORE_LEAD, ATBlocks.ORE_SULFUR, ATBlocks.ORE_APATITE, ATBlocks.ORE_GRAPHITE,
            ATBlocks.ORE_NITERITE, ATBlocks.ORE_ALUMINIUM, ATBlocks.ORE_SALT, ATBlocks.ORE_ROCK_SALT,
        ).forEach(getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)::add)
        listOf(
            ATBlocks.ORE_SILVER, ATBlocks.ORE_MANGANESE, ATBlocks.ORE_NICKEL, ATBlocks.ORE_MAGNESIUM, ATBlocks.ORE_RUTILE,
            ATBlocks.ORE_TITANIUM, ATBlocks.ORE_TUNGSTEN, ATBlocks.ORE_PLATINUM_GROUP, ATBlocks.ORE_PYRITE, ATBlocks.ORE_RUBY,
            ATBlocks.ORE_ANTIMONY, ATBlocks.ORE_LITHIUM, ATBlocks.ORE_URANIUM,
        ).forEach(getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)::add)


        listOf(
            ATBlocks.MACHINE_CASING, ATBlocks.MACHINE_BURNING_BOX
        ).forEach(getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)::add)
        listOf(
            ATBlocks.MACHINE_CASING, ATBlocks.MACHINE_BURNING_BOX
        ).forEach(getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)::add)
    }
}

object TagKeys {
    @JvmStatic val INGOT: TagKey<Item> = TagKey.of(Registry.ITEM_KEY, Identifier(modId, "ingot"))
}
