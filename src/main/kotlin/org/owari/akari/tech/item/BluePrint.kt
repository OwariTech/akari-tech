package org.owari.akari.tech.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.world.World
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.datagen.translationKey
import org.owari.akari.tech.machine.MachineType
import org.owari.akari.tech.modId

class BluePrint(val type: MachineType<*>) : Item(FabricItemSettings().group(akariItemGroup)) {
    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip += TranslatableText("custom.$modId.blueprint_tooltip_prefix").append(TranslatableText(type.translationKey))
    }
}
