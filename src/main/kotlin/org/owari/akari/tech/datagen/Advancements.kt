package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.modId
import java.util.function.Consumer

class AdvancementsProvider(gen: FabricDataGenerator) : FabricAdvancementProvider(gen) {
    override fun generateAdvancement(consumer: Consumer<Advancement>) {
        Advancement.Builder.create().display(
            Blocks.ORE_TIN_ITEM,
            TranslatableText("advancement.$modId.get_tin.title"),
            TranslatableText("advancement.$modId.get_tin.description"),
            Identifier(modId, "icon.png"),
            AdvancementFrame.TASK, true, true, false)
            .criterion("get_tin", InventoryChangedCriterion.Conditions.items(Blocks.ORE_TIN_ITEM))
            .build(consumer, "$modId/get_tin")
    }
}
