package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import org.owari.akari.tech.*
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.item.Items
import org.owari.akari.tech.machine.MachineType
import org.owari.akari.tech.machine.MachineTypes

val MachineType<*>.translationKey: String
    get() = "custom.$modId.${this.name}"

abstract class AkariLanguageProvider(gen: FabricDataGenerator, lang: String) : FabricLanguageProvider(gen, lang) {

    fun TranslationBuilder.add(machineType: MachineType<*>, text: String) {
        add(machineType.translationKey, text)
    }
}

class ChineseLanguageProvider(gen: FabricDataGenerator) : AkariLanguageProvider(gen, "zh_cn") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(akariItemGroup, "灯火科技")

        b.add(Items.BLUEPRINT_EMPTY, "蓝图 (空)")
        Items.BLUEPRINT_ALL.forEach { b.add(it, "蓝图 (包含机器设计)") }

        b.add(Items.TECHNIQUE_INSTRUCTION_EMPTY, "工艺指导书 (空)")
        Items.TECHNIQUE_INSTRUCTION_ALL.forEach { b.add(it, "工艺指导书 (包含工艺)") }

        b.add(Items.TOOL_ENGINEERING_HAMMER, "工程锤")

        b.add(Items.INGOT_STEEL, "钢锭")
        b.add(Items.INGOT_STAINLESS_STEEL, "不锈钢锭")
        b.add(Items.INGOT_TIN, "锡锭")
        b.add(Items.INGOT_LEAD, "铅锭")
        b.add(Items.INGOT_SILVER, "银锭")
        b.add(Items.INGOT_ZINC, "锌锭")
        b.add(Items.INGOT_ALUMINIUM, "铝锭")
        b.add(Items.INGOT_TITANIUM, "钛锭")
        b.add(Items.INGOT_TUNGSTEN, "钨锭")
        b.add(Items.INGOT_CHROMIUM, "铬锭")
        b.add(Items.INGOT_MANGANESE, "锰锭")
        b.add(Items.INGOT_NICKEL, "镍锭")
        b.add(Items.INGOT_MAGNESIUM, "镁锭")
        b.add(Items.INGOT_ANTIMONY, "锑锭")
        b.add(Items.INGOT_LITHIUM, "锂锭")
        b.add(Items.INGOT_NEODYMIUM, "钕锭")
        b.add(Items.INGOT_INVAR, "殷钢锭")
        b.add(Items.INGOT_SODIUM, "钠锭")
        b.add(Items.INGOT_FERRITE, "铁氧体锭")

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

        b.add(Blocks.MACHINE_CASING, "机器外壳")
        b.add(Blocks.MACHINE_BURNING_BOX_ITEM, "燃烧室")

        b.add(MachineTypes.BURNING_BOX, "燃烧室")

        b.add("advancement.$modId.get_tin.title", "一些新矿石?")
        b.add("advancement.$modId.get_tin.description", "挖掘到一个锡石矿石")

        b.add("custom.$modId.temperature_prefix", "温度:")
        b.add("custom.$modId.temperature_unit", "℃")
        b.add("custom.$modId.blueprint_tooltip_prefix", "类型: ")
        b.add("custom.$modId.machine_part_tier_prefix", "等级: ")
    }
}

class EnglishLanguageProvider(gen: FabricDataGenerator) : AkariLanguageProvider(gen, "en_us") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(akariItemGroup, "Akari Tech")

        b.add(Items.TOOL_ENGINEERING_HAMMER, "Engineering Hammer")

        b.add(Items.BLUEPRINT_EMPTY, "Blueprints (Empty)")
        Items.BLUEPRINT_ALL.forEach { b.add(it, "Blueprints (Including Machine Design)") }

        b.add(Items.TECHNIQUE_INSTRUCTION_EMPTY, "Technique Instructions (Empty)")
        Items.TECHNIQUE_INSTRUCTION_ALL.forEach { b.add(it, "Technique Instructions (Including Techniques)") }

        b.add(Items.INGOT_STEEL, "Steel Ingot")
        b.add(Items.INGOT_STAINLESS_STEEL, "Stainless Steel Ingot")
        b.add(Items.INGOT_TIN, "Tin Ingot")
        b.add(Items.INGOT_LEAD, "Lead Ingot")
        b.add(Items.INGOT_SILVER, "Silver Ingot")
        b.add(Items.INGOT_ZINC, "Zinc Ingot")
        b.add(Items.INGOT_ALUMINIUM, "Aluminium Ingot")
        b.add(Items.INGOT_TITANIUM, "Titanium Ingot")
        b.add(Items.INGOT_TUNGSTEN, "Tungsten Ingot")
        b.add(Items.INGOT_CHROMIUM, "Chromium Ingot")
        b.add(Items.INGOT_MANGANESE, "Manganese Ingot")
        b.add(Items.INGOT_NICKEL, "Nickel Ingot")
        b.add(Items.INGOT_MAGNESIUM, "Magnesium Ingot")
        b.add(Items.INGOT_ANTIMONY, "Antimony Ingot")
        b.add(Items.INGOT_LITHIUM, "Lithium Ingot")
        b.add(Items.INGOT_NEODYMIUM, "Neodymium Ingot")
        b.add(Items.INGOT_INVAR, "Invar Alloy Ingot")
        b.add(Items.INGOT_SODIUM, "Sodium")
        b.add(Items.INGOT_FERRITE, "Ferrite Ingot")

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

        b.add(Blocks.MACHINE_CASING, "Machine Casing")
        b.add(Blocks.MACHINE_BURNING_BOX_ITEM, "Burning Box")

        b.add(MachineTypes.BURNING_BOX, "Burning Box")

        b.add("advancement.$modId.get_tin.title", "New ores?")
        b.add("advancement.$modId.get_tin.description", "Got a cassiterite ore")

        b.add("custom.$modId.temperature_prefix", "Temperature:")
        b.add("custom.$modId.temperature_unit", "℃")
        b.add("custom.$modId.blueprint_tooltip_prefix", "Type: ")
        b.add("custom.$modId.machine_part_tier_prefix", "Tier: ")
    }
}
