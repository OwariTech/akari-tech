package org.owari.akari.tech.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import org.owari.akari.tech.*
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.item.ATItems
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

        b.add(ATItems.BLUEPRINT_EMPTY, "蓝图 (空)")
        ATItems.BLUEPRINT_ALL.forEach { b.add(it, "蓝图 (包含机器设计)") }

        b.add(ATItems.TECHNIQUE_INSTRUCTION_EMPTY, "工艺指导书 (空)")
        ATItems.TECHNIQUE_INSTRUCTION_ALL.forEach { b.add(it, "工艺指导书 (包含工艺)") }

        b.add(ATItems.TOOL_ENGINEERING_HAMMER, "工程锤")

        b.add(ATItems.INGOT_STEEL, "钢锭")
        b.add(ATItems.INGOT_STAINLESS_STEEL, "不锈钢锭")
        b.add(ATItems.INGOT_TIN, "锡锭")
        b.add(ATItems.INGOT_LEAD, "铅锭")
        b.add(ATItems.INGOT_SILVER, "银锭")
        b.add(ATItems.INGOT_ZINC, "锌锭")
        b.add(ATItems.INGOT_ALUMINIUM, "铝锭")
        b.add(ATItems.INGOT_TITANIUM, "钛锭")
        b.add(ATItems.INGOT_TUNGSTEN, "钨锭")
        b.add(ATItems.INGOT_CHROMIUM, "铬锭")
        b.add(ATItems.INGOT_MANGANESE, "锰锭")
        b.add(ATItems.INGOT_NICKEL, "镍锭")
        b.add(ATItems.INGOT_MAGNESIUM, "镁锭")
        b.add(ATItems.INGOT_ANTIMONY, "锑锭")
        b.add(ATItems.INGOT_LITHIUM, "锂锭")
        b.add(ATItems.INGOT_NEODYMIUM, "钕锭")
        b.add(ATItems.INGOT_INVAR, "殷钢锭")
        b.add(ATItems.INGOT_SODIUM, "钠锭")
        b.add(ATItems.INGOT_FERRITE, "铁氧体锭")

        b.add(ATBlocks.ORE_TIN, "锡石矿石")
        b.add(ATBlocks.ORE_ZINC, "闪锌矿石")
        b.add(ATBlocks.ORE_LEAD, "方铅矿石")
        b.add(ATBlocks.ORE_SILVER, "银矿石")
        b.add(ATBlocks.ORE_MANGANESE, "软锰矿石")
        b.add(ATBlocks.ORE_NICKEL, "镍黄铁矿石")
        b.add(ATBlocks.ORE_MAGNESIUM, "菱镁矿石")
        b.add(ATBlocks.ORE_CHROMIUM, "铬铁矿石")
        b.add(ATBlocks.ORE_RUTILE, "金红石矿石")
        b.add(ATBlocks.ORE_TITANIUM, "钛铁矿石")
        b.add(ATBlocks.ORE_TUNGSTEN, "黑钨矿石")
        b.add(ATBlocks.ORE_PLATINUM_GROUP, "铂族金属矿石")
        b.add(ATBlocks.ORE_PYRITE, "黄铁矿")
        b.add(ATBlocks.ORE_SULFUR, "天然硫矿石")
        b.add(ATBlocks.ORE_APATITE, "磷灰石矿石")
        b.add(ATBlocks.ORE_RUBY, "红宝石矿石")
        b.add(ATBlocks.ORE_ANTIMONY, "辉锑矿石")
        b.add(ATBlocks.ORE_LITHIUM, "锂辉石矿石")
        b.add(ATBlocks.ORE_GRAPHITE, "石墨矿石")
        b.add(ATBlocks.ORE_NITERITE, "硝酸盐矿石")
        b.add(ATBlocks.ORE_URANIUM, "晶质铀矿石")

        b.add(ATBlocks.ORE_ALUMINIUM, "铝土矿石")
        b.add(ATBlocks.ORE_BLACK_SAND, "黑沙")
        b.add(ATBlocks.ORE_ANTHRACITE, "无烟煤矿石")
        b.add(ATBlocks.ORE_SALT, "盐矿石")
        b.add(ATBlocks.ORE_ROCK_SALT, "岩盐矿石")

        b.add(ATBlocks.MACHINE_CASING, "机器外壳")
        b.add(ATBlocks.MACHINE_BURNING_BOX_ITEM, "燃烧室")

        b.add(MachineTypes.BURNING_BOX, "燃烧室")

        b.add("advancement.$modId.get_tin.title", "一些新矿石?")
        b.add("advancement.$modId.get_tin.description", "挖掘到一个锡石矿石")

        b.add("custom.$modId.temperature_prefix", "温度: ")
        b.add("custom.$modId.temperature_unit", " ℃")
        b.add("custom.$modId.time_remaining", "剩余时间: ")
        b.add("custom.$modId.time_unit", " 秒")
        b.add("custom.$modId.blueprint_tooltip_prefix", "类型: ")
        b.add("custom.$modId.machine_part_tier_prefix", "等级: ")
    }
}

class EnglishLanguageProvider(gen: FabricDataGenerator) : AkariLanguageProvider(gen, "en_us") {
    override fun generateTranslations(b: TranslationBuilder) {
        b.add(akariItemGroup, "Akari Tech")

        b.add(ATItems.TOOL_ENGINEERING_HAMMER, "Engineering Hammer")

        b.add(ATItems.BLUEPRINT_EMPTY, "Blueprints (Empty)")
        ATItems.BLUEPRINT_ALL.forEach { b.add(it, "Blueprints (Including Machine Design)") }

        b.add(ATItems.TECHNIQUE_INSTRUCTION_EMPTY, "Technique Instructions (Empty)")
        ATItems.TECHNIQUE_INSTRUCTION_ALL.forEach { b.add(it, "Technique Instructions (Including Techniques)") }

        b.add(ATItems.INGOT_STEEL, "Steel Ingot")
        b.add(ATItems.INGOT_STAINLESS_STEEL, "Stainless Steel Ingot")
        b.add(ATItems.INGOT_TIN, "Tin Ingot")
        b.add(ATItems.INGOT_LEAD, "Lead Ingot")
        b.add(ATItems.INGOT_SILVER, "Silver Ingot")
        b.add(ATItems.INGOT_ZINC, "Zinc Ingot")
        b.add(ATItems.INGOT_ALUMINIUM, "Aluminium Ingot")
        b.add(ATItems.INGOT_TITANIUM, "Titanium Ingot")
        b.add(ATItems.INGOT_TUNGSTEN, "Tungsten Ingot")
        b.add(ATItems.INGOT_CHROMIUM, "Chromium Ingot")
        b.add(ATItems.INGOT_MANGANESE, "Manganese Ingot")
        b.add(ATItems.INGOT_NICKEL, "Nickel Ingot")
        b.add(ATItems.INGOT_MAGNESIUM, "Magnesium Ingot")
        b.add(ATItems.INGOT_ANTIMONY, "Antimony Ingot")
        b.add(ATItems.INGOT_LITHIUM, "Lithium Ingot")
        b.add(ATItems.INGOT_NEODYMIUM, "Neodymium Ingot")
        b.add(ATItems.INGOT_INVAR, "Invar Alloy Ingot")
        b.add(ATItems.INGOT_SODIUM, "Sodium")
        b.add(ATItems.INGOT_FERRITE, "Ferrite Ingot")

        b.add(ATBlocks.ORE_TIN, "Cassiterite Ore")
        b.add(ATBlocks.ORE_ZINC, "Sphalerite Ore")
        b.add(ATBlocks.ORE_LEAD, "Galena Ore")
        b.add(ATBlocks.ORE_SILVER, "Silver Ore")
        b.add(ATBlocks.ORE_MANGANESE, "Pyrolusite Ore")
        b.add(ATBlocks.ORE_NICKEL, "Pentlandite Ore")
        b.add(ATBlocks.ORE_MAGNESIUM, "Magnesite Ore")
        b.add(ATBlocks.ORE_CHROMIUM, "Chromite Ore")
        b.add(ATBlocks.ORE_RUTILE, "Rutile Ore")
        b.add(ATBlocks.ORE_TITANIUM, "Ilmenite Ore")
        b.add(ATBlocks.ORE_TUNGSTEN, "Wolframite Ore")
        b.add(ATBlocks.ORE_PLATINUM_GROUP, "Platinum Group Minerals")
        b.add(ATBlocks.ORE_PYRITE, "Pyrite Ore")
        b.add(ATBlocks.ORE_SULFUR, "Natural Sulfur Ore")
        b.add(ATBlocks.ORE_APATITE, "Apatite Ore")
        b.add(ATBlocks.ORE_RUBY, "Ruby Ore")
        b.add(ATBlocks.ORE_ANTIMONY, "Stibnite Ore")
        b.add(ATBlocks.ORE_LITHIUM, "Spodumene Ore")
        b.add(ATBlocks.ORE_GRAPHITE, "Graphite Ore")
        b.add(ATBlocks.ORE_NITERITE, "Niterite Ore")
        b.add(ATBlocks.ORE_URANIUM, "Uraninite Ore")

        b.add(ATBlocks.ORE_ALUMINIUM, "Bauxite Ore")
        b.add(ATBlocks.ORE_BLACK_SAND, "Black Sand")
        b.add(ATBlocks.ORE_ANTHRACITE, "Anthracite Ore")
        b.add(ATBlocks.ORE_SALT, "Salt Ore")
        b.add(ATBlocks.ORE_ROCK_SALT, "Rock Salt Ore")

        b.add(ATBlocks.MACHINE_CASING, "Machine Casing")
        b.add(ATBlocks.MACHINE_BURNING_BOX_ITEM, "Burning Box")

        b.add(MachineTypes.BURNING_BOX, "Burning Box")

        b.add("advancement.$modId.get_tin.title", "New ores?")
        b.add("advancement.$modId.get_tin.description", "Got a cassiterite ore")

        b.add("custom.$modId.temperature_prefix", "Temperature:")
        b.add("custom.$modId.temperature_unit", "℃")
        b.add("custom.$modId.time_remaining", "Time remaining: ")
        b.add("custom.$modId.time_unit", " s")
        b.add("custom.$modId.blueprint_tooltip_prefix", "Type: ")
        b.add("custom.$modId.machine_part_tier_prefix", "Tier: ")
    }
}
