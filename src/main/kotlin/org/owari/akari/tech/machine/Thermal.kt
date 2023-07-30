package org.owari.akari.tech.machine

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
        TranslatableText("$modId.temperature_prefix")
            .append(temperature.toString())
            .append(TranslatableText("$modId.temperature_unit"))
}

interface ThermalSupplier {
    val temperature: Int
}

interface ThermalConsumer
