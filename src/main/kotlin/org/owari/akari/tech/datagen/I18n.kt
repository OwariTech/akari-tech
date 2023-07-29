package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items

class ChineseLanguageProvider(gen: FabricDataGenerator) : FabricLanguageProvider(gen, "zh_cn") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(Items.INGOT_TIN, "锡锭")

        b.add(Blocks.ORE_TIN, "锡石矿石")
        b.add(Blocks.ORE_ZINC, "闪锌矿石")
        b.add(Blocks.ORE_LEAD, "方铅矿石")
        b.add(Blocks.ORE_SILVER, "银矿石")
        b.add(Blocks.ORE_MANGANESE, "软锰矿石")
        b.add(Blocks.ORE_NICKEL, "镍黄铁矿石")
        b.add(Blocks.ORE_MAGNESIUM, "菱镁矿石")
        b.add(Blocks.ORE_CHROMIUM, "铬铁矿石")
        b.add(Blocks.ORE_RUTILE, "金红石矿石")
        b.add(Blocks.ORE_TITANIUM, "钛铁矿石")
        b.add(Blocks.ORE_TUNGSTEN, "黑钨矿石")
        b.add(Blocks.ORE_PLATINUM_GROUP, "铂族金属矿石")
        b.add(Blocks.ORE_PYRITE, "黄铁矿")
        b.add(Blocks.ORE_SULFUR, "天然硫矿石")
        b.add(Blocks.ORE_APATITE, "磷灰石矿石")
        b.add(Blocks.ORE_RUBY, "红宝石矿石")
        b.add(Blocks.ORE_ANTIMONY, "辉锑矿石")
        b.add(Blocks.ORE_LITHIUM, "锂辉石矿石")
        b.add(Blocks.ORE_GRAPHITE, "石墨矿石")
        b.add(Blocks.ORE_NITERITE, "硝酸盐矿石")
        b.add(Blocks.ORE_URANIUM, "晶质铀矿石")

        b.add(Blocks.ORE_ALUMINIUM, "铝土矿石")
        b.add(Blocks.ORE_BLACK_SAND, "黑沙")
        b.add(Blocks.ORE_ANTHRACITE, "无烟煤矿石")
        b.add(Blocks.ORE_SALT, "盐矿石")
        b.add(Blocks.ORE_ROCK_SALT, "岩盐矿石")
    }
}

class EnglishLanguageProvider(gen: FabricDataGenerator) : FabricLanguageProvider(gen, "en_us") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(Items.INGOT_TIN, "Tin Ingot")

        b.add(Blocks.ORE_TIN, "Cassiterite Ore")
        b.add(Blocks.ORE_ZINC, "Sphalerite Ore")
        b.add(Blocks.ORE_LEAD, "Galena Ore")
        b.add(Blocks.ORE_SILVER, "Silver Ore")
        b.add(Blocks.ORE_MANGANESE, "Pyrolusite Ore")
        b.add(Blocks.ORE_NICKEL, "Pentlandite Ore")
        b.add(Blocks.ORE_MAGNESIUM, "Magnesite Ore")
        b.add(Blocks.ORE_CHROMIUM, "Chromite Ore")
        b.add(Blocks.ORE_RUTILE, "Rutile Ore")
        b.add(Blocks.ORE_TITANIUM, "Ilmenite Ore")
        b.add(Blocks.ORE_TUNGSTEN, "Wolframite Ore")
        b.add(Blocks.ORE_PLATINUM_GROUP, "Platinum Group Minerals")
        b.add(Blocks.ORE_PYRITE, "Pyrite Ore")
        b.add(Blocks.ORE_SULFUR, "Natural Sulfur Ore")
        b.add(Blocks.ORE_APATITE, "Apatite Ore")
        b.add(Blocks.ORE_RUBY, "Ruby Ore")
        b.add(Blocks.ORE_ANTIMONY, "Stibnite Ore")
        b.add(Blocks.ORE_LITHIUM, "Spodumene Ore")
        b.add(Blocks.ORE_GRAPHITE, "Graphite Ore")
        b.add(Blocks.ORE_NITERITE, "Niterite Ore")
        b.add(Blocks.ORE_URANIUM, "Uraninite Ore")

        b.add(Blocks.ORE_ALUMINIUM, "Bauxite Ore")
        b.add(Blocks.ORE_BLACK_SAND, "Black Sand")
        b.add(Blocks.ORE_ANTHRACITE, "Anthracite Ore")
        b.add(Blocks.ORE_SALT, "Salt Ore")
        b.add(Blocks.ORE_ROCK_SALT, "Rock Salt Ore")
    }
}
