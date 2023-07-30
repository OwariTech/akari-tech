package org.owari.akari.tech.item.part

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.item.MachinePart

class ThermalConductor(override val tier: Int) : Item(FabricItemSettings().group(akariItemGroup)), MachinePart {
    override val type: String = "thermal_conductor"
}

