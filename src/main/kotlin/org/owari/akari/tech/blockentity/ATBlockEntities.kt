package org.owari.akari.tech.blockentity

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.owari.akari.tech.block.ATBlocks
import org.owari.akari.tech.modId

object ATBlockEntities {
    fun registerBlockEntities() {
        register("machine_casing", MACHINE_CASING_TYPE)
        register("machine_burning_box", MACHINE_BURNING_BOX_TYPE)
    }

    private inline fun register(name: String, bet: BlockEntityType<*>) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier(modId, name), bet)
    }

    @JvmStatic val MACHINE_CASING_TYPE = FabricBlockEntityTypeBuilder.create(::MachineCasingBE, ATBlocks.MACHINE_CASING).build()
    @JvmStatic val MACHINE_BURNING_BOX_TYPE = FabricBlockEntityTypeBuilder.create(::BurningBoxBE, ATBlocks.MACHINE_BURNING_BOX).build()
}
