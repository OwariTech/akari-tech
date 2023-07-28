package org.owari.akari.tech.worldgen

import net.fabricmc.fabric.api.biome.v1.BiomeModification
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
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
        register("ore_tin", CONFIG_FEATURE_ORE_TIN, PLACE_FEATURE_ORE_TIN)
    }

    private inline fun register(name: String, cf: ConfiguredFeature<*, *>, pf: PlacedFeature) {
        val id = Identifier(modId, "gen_$name")
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, cf)
        Registry.register(BuiltinRegistries.PLACED_FEATURE, id, pf)
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, id))
    }
}

val CONFIG_FEATURE_ORE_TIN = ConfiguredFeature(
    Feature.ORE, OreFeatureConfig(
        OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
        Blocks.ORE_TIN.defaultState,
        6
    )
)

val PLACE_FEATURE_ORE_TIN = PlacedFeature(
    RegistryEntry.of(CONFIG_FEATURE_ORE_TIN),
    listOf(
        CountPlacementModifier.of(20),
        SquarePlacementModifier.of(),
        HeightRangePlacementModifier.uniform(
            YOffset.BOTTOM,
            YOffset.fixed(64)
        )
    )
)
