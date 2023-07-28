package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items

class ChineseLanguageProvider(gen: FabricDataGenerator) : FabricLanguageProvider(gen, "zh_cn") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(Items.INGOT_TIN, "锡锭")

        b.add(Blocks.ORE_TIN, "锡石矿石")
    }
}
