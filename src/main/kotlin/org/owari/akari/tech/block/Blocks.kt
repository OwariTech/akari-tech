package org.owari.akari.tech.block

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.modId

object Blocks {
    fun registerBlocks() {
        register("ore_tin", ORE_TIN, ORE_TIN_ITEM)
    }

    private inline fun register(name: String, block: Block, item: BlockItem) {
        val id = Identifier(modId, name)
        Registry.register(Registry.BLOCK, id, block)
        Registry.register(Registry.ITEM, id, item)
    }

    @JvmStatic
    val ORE_TIN = Block(FabricBlockSettings.of(Material.STONE).strength(3.0f, 3.0f).requiresTool())
    @JvmStatic
    val ORE_TIN_ITEM = BlockItem(ORE_TIN, FabricItemSettings().group(akariItemGroup))
}
