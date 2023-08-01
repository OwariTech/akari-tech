package org.owari.akari.tech.util

import net.minecraft.item.Item
import net.minecraft.tag.TagKey
import net.minecraft.util.registry.Registry
import kotlin.jvm.optionals.getOrNull

object ItemUtil {
    fun TagKey<Item>.getAllItem() = Registry.ITEM.getEntryList(this).orElse(null)?.map{ it.value() }?.toList() ?: listOf<Item>()
}
