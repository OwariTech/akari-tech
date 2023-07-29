package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import java.util.function.Consumer

class RecipesProvider(gen: FabricDataGenerator) : FabricRecipeProvider(gen) {
    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {

    }
}
