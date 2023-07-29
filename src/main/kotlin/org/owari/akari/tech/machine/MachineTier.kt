package org.owari.akari.tech.machine

object MachineTier {
    @JvmStatic fun getPartSlot(tier: Int) = when(tier) {
        0 -> 2
        1 -> 3
        2 -> 4
        3 -> 6
        4 -> 8
        5 -> 9
        6 -> 12
        else -> 0
    }
    @JvmStatic fun getGuideSlot(tier: Int) = when(tier) {
        0 -> 0
        1, 2, 3 -> 1
        4, 5 -> 2
        6 -> 3
        else -> 0
    }

}
