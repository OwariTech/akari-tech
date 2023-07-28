package org.owari.akari.tech.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.akariItemGroup
import org.owari.akari.tech.modId

object Items {
    fun registerItems() {
        register("ingot_tin", INGOT_TIN)
    }

    private inline fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(modId, name), item)
    }

    @JvmStatic
    val INGOT_TIN = Item(FabricItemSettings().group(akariItemGroup))
}
