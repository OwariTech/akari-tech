package org.owari.akari.tech.worldgen

import net.fabricmc.fabric.api.biome.v1.BiomeModification
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Block
import net.minecraft.structure.rule.RuleTest
import net.minecraft.util.Identifier
import net.minecraft.util.registry.*
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.modId

object OreGenerators {
    fun registerOreGenerators() {
        register("ore_tin", CF_ORE_TIN, PF_ORE_TIN)
    }

    private inline fun register(name: String, cf: ConfiguredFeature<*, *>, pf: PlacedFeature) {
        val id = Identifier(modId, "gen_$name")
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, cf)
        Registry.register(BuiltinRegistries.PLACED_FEATURE, id, pf)
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, id))
    }

    private inline fun oreConfigFeature(block: Block, size: Int, test: RuleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES) =
        ConfiguredFeature(Feature.ORE, OreFeatureConfig(test, block.defaultState, size))
    private inline fun orePlacedFeature(cf: ConfiguredFeature<*, *>, count: Int, top: YOffset = YOffset.TOP, bottom: YOffset = YOffset.BOTTOM) =
        PlacedFeature(RegistryEntry.of(cf), listOf(CountPlacementModifier.of(count), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(top, bottom)))

    @JvmStatic val CF_ORE_TIN = oreConfigFeature(Blocks.ORE_TIN, 6)
    @JvmStatic val PF_ORE_TIN = orePlacedFeature(CF_ORE_TIN, 20, YOffset.fixed(64))
}
