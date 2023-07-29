package org.owari.akari.tech.blockentity

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.block.Blocks
import org.owari.akari.tech.modId

object BlockEntities {
    fun registerBlockEntities() {
       register("machine_casing", MACHINE_CASING_TYPE)
    }

    private inline fun register(name: String, bet: BlockEntityType<*>) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier(modId, name), bet)
    }

    @JvmStatic val MACHINE_CASING_TYPE = FabricBlockEntityTypeBuilder.create(::MachineCasingBE, Blocks.MACHINE_CASING).build()
}
