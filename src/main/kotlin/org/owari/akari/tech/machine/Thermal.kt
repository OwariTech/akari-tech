package org.owari.akari.tech.machine

import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.tag.ItemTags
import net.minecraft.text.TranslatableText
import org.owari.akari.tech.modId
import kotlin.math.*

object Thermal {
    /**
     * 计算热传导一次上升 / 下降的温度
     *
     * 算法:
     * 耗热机器温度 会不断趋近于 热源温度
     * 当 热源温度 高于 / 低于 耗热机器温度 时, 每次热传导,
     * 耗热机器温度 会上升 / 下降 min(abs(热源 - 耗热), 热传导倍率 * max(5, (热源 - 耗热) * 0.2)) 度
     *
     * @param from 热源温度
     * @param to 耗热机器温度
     * @param thermalMultiplier 热传导倍率
     */
    @JvmStatic
    fun calcThermalConduct(
        from: Int,
        to: Int,
        thermalMultiplier: Int
    ): Int {
        val sign = if (from > to) -1 else 1
        val delta = abs(from - to)
        return sign * min(delta, thermalMultiplier * max(5, (delta * 0.2).toInt()))
    }

    @JvmStatic
    fun getTemperatureDisplay(temperature: Int) =
        TranslatableText("custom.$modId.temperature_prefix")
            .append(temperature.toString())
            .append(TranslatableText("custom.$modId.temperature_unit"))

    // first = time
    // second = temperature
    /*
有机系:
- 甘蔗: 300
- 木材: 700
- 木炭 / 煤: 1000
- 无烟煤: 1600
- 天然气: 2000
- 原油: 1000
- 汽油: 1300

无机系:
- 钠粉: 1700
- 硫粉: 1800
- 氢气: 2000
- 铝粉: 2500
- 镁粉: 3000
     */
    val burnData = buildMap<Item, BurnData> {
        put(Items.COAL, BurnData(80 * 20, 1000))
        put(Items.CHARCOAL, BurnData(80 * 20, 1000))
        put(Items.SUGAR_CANE, BurnData(5 * 20, 300))
        put(Items.STICK, BurnData(5 * 20, 700))
        listOf(Items.ACACIA_PLANKS, Items.BIRCH_PLANKS, Items.CRIMSON_PLANKS, Items.JUNGLE_PLANKS,
            Items.DARK_OAK_PLANKS, Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.WARPED_PLANKS)
            .forEach { put(it, BurnData(80 * 20, 700)) }
        listOf(Items.ACACIA_LOG, Items.BIRCH_LOG, Items.CRIMSON_HYPHAE, Items.JUNGLE_PLANKS,
            Items.DARK_OAK_PLANKS, Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.WARPED_PLANKS)
            .forEach { put(it, BurnData(15 * 20, 700)) }
    }

    data class BurnData(val burnTime: Int, val burnTemperature: Int)
}

interface ThermalSupplier {
    val temperature: Int
}

interface ThermalConsumer
