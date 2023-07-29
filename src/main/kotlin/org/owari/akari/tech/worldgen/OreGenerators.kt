package org.owari.akari.tech.worldgen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Block
import net.minecraft.structure.rule.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.*
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.modId
import java.util.function.Predicate

object OreGenerators {
    fun registerOreGenerators() {
        register("ore_tin", CF_ORE_TIN, PF_ORE_TIN)
        register("ore_zinc", CF_ORE_ZINC, PF_ORE_ZINC)
        register("ore_lead", CF_ORE_LEAD, PF_ORE_LEAD)
        register("ore_silver", CF_ORE_SILVER, PF_ORE_SILVER)
        register("ore_manganese", CF_ORE_MANGANESE, PF_ORE_MANGANESE)
        register("ore_nickel", CF_ORE_NICKEL, PF_ORE_NICKEL)
        register("ore_magnesium", CF_ORE_MAGNESIUM, PF_ORE_MAGNESIUM)
        register("ore_chromium", CF_ORE_CHROMIUM, PF_ORE_CHROMIUM)
        register("ore_rutile", CF_ORE_RUTILE, PF_ORE_RUTILE)
        register("ore_titanium", CF_ORE_TITANIUM, PF_ORE_TITANIUM)
        register("ore_tungsten", CF_ORE_TUNGSTEN, PF_ORE_TUNGSTEN)
        register("ore_platinum_group", CF_ORE_PLATINUM_GROUP, PF_ORE_PLATINUM_GROUP)
        register("ore_pyrite", CF_ORE_PYRITE, PF_ORE_PYRITE)
        //register("ore_sulfur", CF_ORE_SULFUR, PF_ORE_SULFUR)
        register("ore_apatite", CF_ORE_APATITE, PF_ORE_APATITE)
        register("ore_ruby", CF_ORE_RUBY, PF_ORE_RUBY)
        register("ore_antimony", CF_ORE_ANTIMONY, PF_ORE_ANTIMONY)
        register("ore_lithium", CF_ORE_LITHIUM, PF_ORE_LITHIUM)
        register("ore_graphite", CF_ORE_GRAPHITE, PF_ORE_GRAPHITE)
        register("ore_niterite", CF_ORE_NITERITE, PF_ORE_NITERITE)
        register("ore_uranium", CF_ORE_URANIUM, PF_ORE_URANIUM)

        register("ore_aluminium", CF_ORE_ALUMINIUM, PF_ORE_ALUMINIUM, BiomeSelectors.categories(Biome.Category.MOUNTAIN))
        register("ore_black_sand", CF_ORE_BLACK_SAND, PF_ORE_BLACK_SAND, BiomeSelectors.categories(Biome.Category.RIVER))
        register("ore_anthracite", CF_ORE_ANTHRACITE, PF_ORE_ANTHRACITE, BiomeSelectors.categories(Biome.Category.SWAMP))
        register("ore_salt", CF_ORE_SALT, PF_ORE_SALT)
        register("ore_rock_salt", CF_ORE_ROCK_SALT, PF_ORE_ROCK_SALT)
    }

    private inline fun register(name: String, cf: ConfiguredFeature<*, *>, pf: PlacedFeature, selector: Predicate<BiomeSelectionContext> = BiomeSelectors.foundInOverworld()) {
        val id = Identifier(modId, "gen_$name")
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, cf)
        Registry.register(BuiltinRegistries.PLACED_FEATURE, id, pf)
        BiomeModifications.addFeature(selector, GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, id))
    }

    private inline fun oreConfigFeature(block: Block, size: Int, test: RuleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES) =
        ConfiguredFeature(Feature.ORE, OreFeatureConfig(test, block.defaultState, size))
    private inline fun orePlacedFeature(cf: ConfiguredFeature<*, *>, count: Int, top: YOffset = YOffset.TOP, bottom: YOffset = YOffset.BOTTOM) =
        PlacedFeature(RegistryEntry.of(cf), listOf(CountPlacementModifier.of(count), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(bottom, top)))

    @JvmStatic val CF_ORE_TIN = oreConfigFeature(Blocks.ORE_TIN, 8)
    @JvmStatic val PF_ORE_TIN = orePlacedFeature(CF_ORE_TIN, 12, YOffset.fixed(82))
    @JvmStatic val CF_ORE_ZINC = oreConfigFeature(Blocks.ORE_ZINC, 6)
    @JvmStatic val PF_ORE_ZINC = orePlacedFeature(CF_ORE_ZINC, 6, YOffset.fixed(60))
    @JvmStatic val CF_ORE_LEAD = oreConfigFeature(Blocks.ORE_LEAD, 4)
    @JvmStatic val PF_ORE_LEAD = orePlacedFeature(CF_ORE_LEAD, 8, YOffset.fixed(72))
    @JvmStatic val CF_ORE_SILVER = oreConfigFeature(Blocks.ORE_SILVER, 9)
    @JvmStatic val PF_ORE_SILVER = orePlacedFeature(CF_ORE_SILVER, 5, YOffset.fixed(42))
    @JvmStatic val CF_ORE_MANGANESE = oreConfigFeature(Blocks.ORE_MANGANESE, 4)
    @JvmStatic val PF_ORE_MANGANESE = orePlacedFeature(CF_ORE_MANGANESE, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_NICKEL = oreConfigFeature(Blocks.ORE_NICKEL, 4)
    @JvmStatic val PF_ORE_NICKEL = orePlacedFeature(CF_ORE_NICKEL, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_MAGNESIUM = oreConfigFeature(Blocks.ORE_MAGNESIUM, 4)
    @JvmStatic val PF_ORE_MAGNESIUM = orePlacedFeature(CF_ORE_MAGNESIUM, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_CHROMIUM = oreConfigFeature(Blocks.ORE_CHROMIUM, 4)
    @JvmStatic val PF_ORE_CHROMIUM = orePlacedFeature(CF_ORE_CHROMIUM, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_RUTILE = oreConfigFeature(Blocks.ORE_RUTILE, 4)
    @JvmStatic val PF_ORE_RUTILE = orePlacedFeature(CF_ORE_RUTILE, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_TITANIUM = oreConfigFeature(Blocks.ORE_TITANIUM, 4)
    @JvmStatic val PF_ORE_TITANIUM = orePlacedFeature(CF_ORE_TITANIUM, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_TUNGSTEN = oreConfigFeature(Blocks.ORE_TUNGSTEN, 4)
    @JvmStatic val PF_ORE_TUNGSTEN = orePlacedFeature(CF_ORE_TUNGSTEN, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_PLATINUM_GROUP = oreConfigFeature(Blocks.ORE_PLATINUM_GROUP, 5)
    @JvmStatic val PF_ORE_PLATINUM_GROUP = orePlacedFeature(CF_ORE_PLATINUM_GROUP, 4, YOffset.fixed(20))
    @JvmStatic val CF_ORE_PYRITE = oreConfigFeature(Blocks.ORE_PYRITE, 9)
    @JvmStatic val PF_ORE_PYRITE = orePlacedFeature(CF_ORE_PYRITE, 8, YOffset.fixed(72))
    @JvmStatic val CF_ORE_SULFUR = oreConfigFeature(Blocks.ORE_SULFUR, 8)
    @JvmStatic val PF_ORE_SULFUR = orePlacedFeature(CF_ORE_SULFUR, 10, YOffset.fixed(170), YOffset.fixed(50))
    @JvmStatic val CF_ORE_APATITE = oreConfigFeature(Blocks.ORE_APATITE, 20)
    @JvmStatic val PF_ORE_APATITE = orePlacedFeature(CF_ORE_APATITE, 2, YOffset.fixed(80))
    @JvmStatic val CF_ORE_RUBY = oreConfigFeature(Blocks.ORE_RUBY, 2)
    @JvmStatic val PF_ORE_RUBY = orePlacedFeature(CF_ORE_RUBY, 40, YOffset.fixed(320))
    @JvmStatic val CF_ORE_ANTIMONY = oreConfigFeature(Blocks.ORE_ANTIMONY, 4)
    @JvmStatic val PF_ORE_ANTIMONY = orePlacedFeature(CF_ORE_ANTIMONY, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_LITHIUM = oreConfigFeature(Blocks.ORE_LITHIUM, 4)
    @JvmStatic val PF_ORE_LITHIUM = orePlacedFeature(CF_ORE_LITHIUM, 4, YOffset.fixed(42))
    @JvmStatic val CF_ORE_GRAPHITE = oreConfigFeature(Blocks.ORE_GRAPHITE, 12)
    @JvmStatic val PF_ORE_GRAPHITE = orePlacedFeature(CF_ORE_GRAPHITE, 3, YOffset.fixed(20))
    @JvmStatic val CF_ORE_NITERITE = oreConfigFeature(Blocks.ORE_NITERITE, 12)
    @JvmStatic val PF_ORE_NITERITE = orePlacedFeature(CF_ORE_NITERITE, 6, YOffset.fixed(72))
    @JvmStatic val CF_ORE_URANIUM = oreConfigFeature(Blocks.ORE_URANIUM, 8)
    @JvmStatic val PF_ORE_URANIUM = orePlacedFeature(CF_ORE_URANIUM, 4, YOffset.fixed(30))

    @JvmStatic val CF_ORE_ALUMINIUM = oreConfigFeature(Blocks.ORE_ALUMINIUM, 50)
    @JvmStatic val PF_ORE_ALUMINIUM = orePlacedFeature(CF_ORE_ALUMINIUM, 1, YOffset.fixed(200), YOffset.fixed(60))
    @JvmStatic val CF_ORE_BLACK_SAND = oreConfigFeature(Blocks.ORE_BLACK_SAND, 50, BlockMatchRuleTest(net.minecraft.block.Blocks.SAND))
    @JvmStatic val PF_ORE_BLACK_SAND = orePlacedFeature(CF_ORE_BLACK_SAND, 1, YOffset.fixed(90), YOffset.fixed(50))
    @JvmStatic val CF_ORE_ANTHRACITE = oreConfigFeature(Blocks.ORE_ANTHRACITE, 50)
    @JvmStatic val PF_ORE_ANTHRACITE = orePlacedFeature(CF_ORE_ANTHRACITE, 1, YOffset.fixed(70), YOffset.fixed(50))
    @JvmStatic val CF_ORE_SALT = oreConfigFeature(Blocks.ORE_SALT, 30)
    @JvmStatic val PF_ORE_SALT = orePlacedFeature(CF_ORE_SALT, 1, YOffset.fixed(110), YOffset.fixed(32))
    @JvmStatic val CF_ORE_ROCK_SALT = oreConfigFeature(Blocks.ORE_ROCK_SALT, 30)
    @JvmStatic val PF_ORE_ROCK_SALT = orePlacedFeature(CF_ORE_ROCK_SALT, 1, YOffset.fixed(120), YOffset.fixed(32))

}
