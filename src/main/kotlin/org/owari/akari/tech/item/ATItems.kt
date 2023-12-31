package org.owari.akari.tech.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.item.part.ThermalConductor
import org.owari.akari.tech.machine.MachineTypes
import org.owari.akari.tech.modId

object ATItems {
    fun registerItems() {
        registerIngots()
        registerTools()
        registerBluePrints()
        registerTechniqueInstructions()
        registerParts()
    }

    private inline fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(modId, name), item)
    }

    private inline fun simpleItem(maxCount: Int = 64) = Item(FabricItemSettings().group(akariItemGroup).maxCount(maxCount))

    private inline fun registerIngots() {
        register("ingot_steel", INGOT_STEEL)
        register("ingot_stainless_steel", INGOT_STAINLESS_STEEL)
        register("ingot_tin", INGOT_TIN)
        register("ingot_lead", INGOT_LEAD)
        register("ingot_silver", INGOT_SILVER)
        register("ingot_zinc", INGOT_ZINC)
        register("ingot_aluminium", INGOT_ALUMINIUM)
        register("ingot_titanium", INGOT_TITANIUM)
        register("ingot_tungsten", INGOT_TUNGSTEN)
        register("ingot_chromium", INGOT_CHROMIUM)
        register("ingot_manganese", INGOT_MANGANESE)
        register("ingot_nickel", INGOT_NICKEL)
        register("ingot_magnesium", INGOT_MAGNESIUM)
        register("ingot_antimony", INGOT_ANTIMONY)
        register("ingot_lithium", INGOT_LITHIUM)
        register("ingot_neodymium", INGOT_NEODYMIUM)
        register("ingot_invar", INGOT_INVAR)
        register("ingot_sodium", INGOT_SODIUM)
        register("ingot_ferrite", INGOT_FERRITE)
    }

    @JvmStatic val INGOT_STEEL = simpleItem()
    @JvmStatic val INGOT_STAINLESS_STEEL = simpleItem()
    @JvmStatic val INGOT_TIN = simpleItem()
    @JvmStatic val INGOT_LEAD = simpleItem()
    @JvmStatic val INGOT_SILVER = simpleItem()
    @JvmStatic val INGOT_ZINC = simpleItem()
    @JvmStatic val INGOT_ALUMINIUM = simpleItem()
    @JvmStatic val INGOT_TITANIUM = simpleItem()
    @JvmStatic val INGOT_TUNGSTEN = simpleItem()
    @JvmStatic val INGOT_CHROMIUM = simpleItem()
    @JvmStatic val INGOT_MANGANESE = simpleItem()
    @JvmStatic val INGOT_NICKEL = simpleItem()
    @JvmStatic val INGOT_MAGNESIUM = simpleItem()
    @JvmStatic val INGOT_ANTIMONY = simpleItem()
    @JvmStatic val INGOT_LITHIUM = simpleItem()
    @JvmStatic val INGOT_NEODYMIUM = simpleItem()
    @JvmStatic val INGOT_INVAR = simpleItem()
    @JvmStatic val INGOT_SODIUM = simpleItem()
    @JvmStatic val INGOT_FERRITE = simpleItem()

    @JvmStatic val INGOT_ALL: List<Item> = listOf(
        INGOT_STEEL, INGOT_STAINLESS_STEEL, INGOT_TIN, INGOT_LEAD, INGOT_SILVER, INGOT_ZINC, INGOT_ALUMINIUM,
        INGOT_TITANIUM, INGOT_TUNGSTEN, INGOT_CHROMIUM, INGOT_MANGANESE, INGOT_NICKEL, INGOT_MAGNESIUM,
        INGOT_ANTIMONY, INGOT_LITHIUM, INGOT_NEODYMIUM, INGOT_INVAR, INGOT_SODIUM, INGOT_FERRITE
    )

    private inline fun registerTools() {
        register("tool_engineering_hammer", TOOL_ENGINEERING_HAMMER)

    }

    @JvmStatic val TOOL_ENGINEERING_HAMMER = simpleItem(maxCount = 1)

    @JvmStatic val TOOL_ALL: List<Item> = listOf(TOOL_ENGINEERING_HAMMER)

    private inline fun registerBluePrints() {
        register("blueprint", BLUEPRINT_EMPTY)

        register("blueprint_burning_box", BLUEPRINT_BURNING_BOX)
    }

    @JvmStatic val BLUEPRINT_EMPTY = simpleItem()

    @JvmStatic val BLUEPRINT_BURNING_BOX = BluePrint(MachineTypes.BURNING_BOX)

    @JvmStatic val BLUEPRINT_ALL: List<BluePrint> = listOf(BLUEPRINT_BURNING_BOX)

    private inline fun registerTechniqueInstructions() {
        register("technique_instruction", TECHNIQUE_INSTRUCTION_EMPTY)
    }

    @JvmStatic val TECHNIQUE_INSTRUCTION_EMPTY = simpleItem()

    @JvmStatic val TECHNIQUE_INSTRUCTION_ALL: List<TechniqueInstruction> = listOf()

    private inline fun registerParts() {
        register("part_thermal_conductor_t0", PART_THERMAL_CONDUCTOR_T0)
        register("part_thermal_conductor_t1", PART_THERMAL_CONDUCTOR_T1)
        register("part_thermal_conductor_t2", PART_THERMAL_CONDUCTOR_T2)
        register("part_thermal_conductor_t3", PART_THERMAL_CONDUCTOR_T3)
        register("part_thermal_conductor_t4", PART_THERMAL_CONDUCTOR_T4)
        register("part_thermal_conductor_t5", PART_THERMAL_CONDUCTOR_T5)
        register("part_thermal_conductor_t6", PART_THERMAL_CONDUCTOR_T6)
    }

    @JvmStatic val PART_THERMAL_CONDUCTOR_T0 = ThermalConductor(0)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T1 = ThermalConductor(1)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T2 = ThermalConductor(2)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T3 = ThermalConductor(3)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T4 = ThermalConductor(4)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T5 = ThermalConductor(5)
    @JvmStatic val PART_THERMAL_CONDUCTOR_T6 = ThermalConductor(6)

}
