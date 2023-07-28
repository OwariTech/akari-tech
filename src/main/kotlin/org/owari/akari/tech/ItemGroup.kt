package org.owari.akari.tech

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier

val akariItemGroup = FabricItemGroupBuilder.create(Identifier(modId, "akari_item_group"))
    .icon { ItemStack(Items.IRON_INGOT) }
    .build()
