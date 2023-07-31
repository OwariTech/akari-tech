package org.owari.akari.tech.item.part

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.world.World
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.item.MachinePart
import org.owari.akari.tech.modId

class ThermalConductor(override val tier: Int) : Item(FabricItemSettings().group(akariItemGroup)), MachinePart {
    override val type: String = "thermal_conductor"

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip += TranslatableText("custom.$modId.machine_part_tier_prefix").append(" $tier")
    }
}
