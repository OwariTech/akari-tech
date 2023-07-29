package org.owari.akari.tech.block

import net.fabricmc.fabric.api.block.v1.FabricBlock
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Material
import net.minecraft.block.SandBlock
import net.minecraft.item.BlockItem
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.DyeColor
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.modId

object Blocks {
    fun registerBlocks() {
        // 按照最下方排列的顺序注册所有的方块
        register("ore_tin", ORE_TIN, ORE_TIN_ITEM)
        register("ore_zinc", ORE_ZINC, ORE_ZINC_ITEM)
        register("ore_lead", ORE_LEAD, ORE_LEAD_ITEM)
        register("ore_silver", ORE_SILVER, ORE_SILVER_ITEM)
        register("ore_manganese", ORE_MANGANESE, ORE_MANGANESE_ITEM)
        register("ore_nickel", ORE_NICKEL, ORE_NICKEL_ITEM)
        register("ore_magnesium", ORE_MAGNESIUM, ORE_MAGNESIUM_ITEM)
        register("ore_chromium", ORE_CHROMIUM, ORE_CHROMIUM_ITEM)
        register("ore_rutile", ORE_RUTILE, ORE_RUTILE_ITEM)
        register("ore_titanium", ORE_TITANIUM, ORE_TITANIUM_ITEM)
        register("ore_tungsten", ORE_TUNGSTEN, ORE_TUNGSTEN_ITEM)
        register("ore_platinum_group", ORE_PLATINUM_GROUP, ORE_PLATINUM_GROUP_ITEM)
        register("ore_pyrite", ORE_PYRITE, ORE_PYRITE_ITEM)
        register("ore_sulfur", ORE_SULFUR, ORE_SULFUR_ITEM)
        register("ore_apatite", ORE_APATITE, ORE_APATITE_ITEM)
        register("ore_ruby", ORE_RUBY, ORE_RUBY_ITEM)
        register("ore_antimony", ORE_ANTIMONY, ORE_ANTIMONY_ITEM)
        register("ore_lithium", ORE_LITHIUM, ORE_LITHIUM_ITEM)
        register("ore_graphite", ORE_GRAPHITE, ORE_GRAPHITE_ITEM)
        register("ore_niterite", ORE_NITERITE, ORE_NITERITE_ITEM)
        register("ore_uranium", ORE_URANIUM, ORE_URANIUM_ITEM)

        register("ore_aluminium", ORE_ALUMINIUM, ORE_ALUMINIUM_ITEM)
        register("ore_black_sand", ORE_BLACK_SAND, ORE_BLACK_SAND_ITEM)
        register("ore_anthracite", ORE_ANTHRACITE, ORE_ANTHRACITE_ITEM)
        register("ore_salt", ORE_SALT, ORE_SALT_ITEM)
        register("ore_rock_salt", ORE_ROCK_SALT, ORE_ROCK_SALT_ITEM)
    }

    private inline fun register(name: String, block: Block, item: BlockItem) {
        val id = Identifier(modId, name)
        Registry.register(Registry.BLOCK, id, block)
        Registry.register(Registry.ITEM, id, item)
    }
    
    private inline fun Block.makeBlockItem() = BlockItem(this, FabricItemSettings().group(akariItemGroup))
    
    private inline fun simpleBlock(
        material: Material = Material.STONE,
        hardness: Float = 3.0f,
        resistance: Float = 3.0f,
        luminance: Int = 0,
        sound: BlockSoundGroup = BlockSoundGroup.STONE
    ) = Block(FabricBlockSettings.of(material).requiresTool().strength(hardness, resistance).luminance(luminance).sounds(sound))

    @JvmStatic val ORE_TIN = simpleBlock()
    @JvmStatic val ORE_TIN_ITEM = ORE_TIN.makeBlockItem()
    @JvmStatic val ORE_ZINC = simpleBlock()
    @JvmStatic val ORE_ZINC_ITEM = ORE_ZINC.makeBlockItem()
    @JvmStatic val ORE_LEAD = simpleBlock()
    @JvmStatic val ORE_LEAD_ITEM = ORE_LEAD.makeBlockItem()
    @JvmStatic val ORE_SILVER = simpleBlock()
    @JvmStatic val ORE_SILVER_ITEM = ORE_SILVER.makeBlockItem()
    @JvmStatic val ORE_MANGANESE = simpleBlock()
    @JvmStatic val ORE_MANGANESE_ITEM = ORE_MANGANESE.makeBlockItem()
    @JvmStatic val ORE_NICKEL = simpleBlock()
    @JvmStatic val ORE_NICKEL_ITEM = ORE_NICKEL.makeBlockItem()
    @JvmStatic val ORE_MAGNESIUM = simpleBlock()
    @JvmStatic val ORE_MAGNESIUM_ITEM = ORE_MAGNESIUM.makeBlockItem()
    @JvmStatic val ORE_CHROMIUM = simpleBlock(hardness = 12.0f)
    @JvmStatic val ORE_CHROMIUM_ITEM = ORE_CHROMIUM.makeBlockItem()
    @JvmStatic val ORE_RUTILE = simpleBlock(hardness = 6.0f)
    @JvmStatic val ORE_RUTILE_ITEM = ORE_RUTILE.makeBlockItem()
    @JvmStatic val ORE_TITANIUM = simpleBlock(hardness = 6.0f)
    @JvmStatic val ORE_TITANIUM_ITEM = ORE_TITANIUM.makeBlockItem()
    @JvmStatic val ORE_TUNGSTEN = simpleBlock(hardness = 6.0f)
    @JvmStatic val ORE_TUNGSTEN_ITEM = ORE_TUNGSTEN.makeBlockItem()
    @JvmStatic val ORE_PLATINUM_GROUP = simpleBlock(hardness = 6.0f)
    @JvmStatic val ORE_PLATINUM_GROUP_ITEM = ORE_PLATINUM_GROUP.makeBlockItem()
    @JvmStatic val ORE_PYRITE = simpleBlock()
    @JvmStatic val ORE_PYRITE_ITEM = ORE_PYRITE.makeBlockItem()
    @JvmStatic val ORE_SULFUR = simpleBlock()
    @JvmStatic val ORE_SULFUR_ITEM = ORE_SULFUR.makeBlockItem()
    @JvmStatic val ORE_APATITE = simpleBlock(hardness = 2.0f)
    @JvmStatic val ORE_APATITE_ITEM = ORE_APATITE.makeBlockItem()
    @JvmStatic val ORE_RUBY = simpleBlock()
    @JvmStatic val ORE_RUBY_ITEM = ORE_RUBY.makeBlockItem()
    @JvmStatic val ORE_ANTIMONY = simpleBlock()
    @JvmStatic val ORE_ANTIMONY_ITEM = ORE_ANTIMONY.makeBlockItem()
    @JvmStatic val ORE_LITHIUM = simpleBlock()
    @JvmStatic val ORE_LITHIUM_ITEM = ORE_LITHIUM.makeBlockItem()
    @JvmStatic val ORE_GRAPHITE = simpleBlock()
    @JvmStatic val ORE_GRAPHITE_ITEM = ORE_GRAPHITE.makeBlockItem()
    @JvmStatic val ORE_NITERITE = simpleBlock()
    @JvmStatic val ORE_NITERITE_ITEM = ORE_NITERITE.makeBlockItem()
    @JvmStatic val ORE_URANIUM = simpleBlock(hardness = 6.0f, resistance = 3.0f, luminance = 5)
    @JvmStatic val ORE_URANIUM_ITEM = ORE_URANIUM.makeBlockItem()

    @JvmStatic val ORE_ALUMINIUM = simpleBlock()
    @JvmStatic val ORE_ALUMINIUM_ITEM = ORE_ALUMINIUM.makeBlockItem()
    @JvmStatic val ORE_BLACK_SAND = SandBlock(0, FabricBlockSettings.of(Material.STONE, DyeColor.BLACK).strength(0.5f).sounds(BlockSoundGroup.SAND))
    @JvmStatic val ORE_BLACK_SAND_ITEM = ORE_BLACK_SAND.makeBlockItem()
    @JvmStatic val ORE_ANTHRACITE = simpleBlock(hardness = 1.5f)
    @JvmStatic val ORE_ANTHRACITE_ITEM = ORE_ANTHRACITE.makeBlockItem()
    @JvmStatic val ORE_SALT = simpleBlock(hardness = 1.5f)
    @JvmStatic val ORE_SALT_ITEM = ORE_SALT.makeBlockItem()
    @JvmStatic val ORE_ROCK_SALT = simpleBlock(hardness = 1.5f)
    @JvmStatic val ORE_ROCK_SALT_ITEM = ORE_ROCK_SALT.makeBlockItem()
}
