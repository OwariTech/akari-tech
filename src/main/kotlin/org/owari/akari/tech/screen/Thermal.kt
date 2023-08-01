package org.owari.akari.tech.screen

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.gui.widget.TextFieldWidget
import net.minecraft.client.render.GameRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.ArrayPropertyDelegate
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.slot.Slot
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import org.owari.akari.tech.blockentity.BurningBoxBE
import org.owari.akari.tech.inventory.SimpleInventory
import org.owari.akari.tech.modId
import kotlin.math.ceil

class BurningBoxScreen(handler: BurningBoxScreenHandler, inv: PlayerInventory, title: Text) : HandledScreen<BurningBoxScreenHandler>(handler, handler.pi, Text.of("")) {
    val background = Identifier(modId, "textures/gui/gui_burning_box.png")

    override fun init() {
        super.init()
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    override fun drawBackground(matrices: MatrixStack, delta: Float, mouseX: Int, mouseY: Int) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader)
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F)
        RenderSystem.setShaderTexture(0, background)
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

    }

    override fun drawForeground(matrices: MatrixStack, mouseX: Int, mouseY: Int) {
        textRenderer.drawWithShadow(matrices,title.string, titleX.toFloat(), titleY.toFloat(), 0xffffff)
        textRenderer.drawWithShadow(matrices,
            TranslatableText("custom.$modId.temperature_prefix").append(handler.getTemperature().toString())
                .append(TranslatableText("custom.$modId.temperature_unit")).string,
            44f, 20f, 0xfffff)
        textRenderer.drawWithShadow(matrices,
            TranslatableText("custom.$modId.time_remaining").append(handler.getRemainingTime().toString())
                .append(TranslatableText("custom.$modId.time_unit")).string,
            44f, 30f, 0xfffff)
    }

    override fun render(matrices: MatrixStack, mouseX: Int, mouseY: Int, delta: Float) {
        drawBackground(matrices, delta, mouseX, mouseY)
        super.render(matrices, mouseX, mouseY, delta)
        drawMouseoverTooltip(matrices, x, y)
    }
}

class BurningBoxScreenHandler(syncId: Int, val pi: PlayerInventory, val inv: Inventory, val delegate: PropertyDelegate) : ScreenHandler(ScreenHandlers.SCREEN_HANDLER_TYPE_BURNING_BOX ,syncId) {
    constructor(syncId: Int, pi: PlayerInventory) : this(syncId, pi, SimpleInventory.ofSize(1), ArrayPropertyDelegate(2))

    init {
        checkSize(inv, 1)
        addProperties(delegate)
        addSlot(Slot(inv, 0, 44, 48))
        // 玩家物品栏
        for (m in 0..2) {
            for (l in 0..8) {
                addSlot(Slot(pi, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        // 玩家快捷栏
        for (m in 0..8) {
            addSlot(Slot(pi, m, 8 + m * 18, 142));
        }
    }

    override fun canUse(player: PlayerEntity) = true

    fun getTemperature() = delegate[0]
    fun getRemainingTime() = ceil(delegate[1].toFloat() / 20).toInt()

    override fun transferSlot(player: PlayerEntity, index: Int): ItemStack {
        var newStack = ItemStack.EMPTY
        val slot = slots[index]
        if(slot != null && slot.hasStack()) {
            val origin = slot.stack
            newStack = origin.copy()
            if(index < inv.size()) {
                if(!insertItem(origin, inv.size(), slots.size, true)) return ItemStack.EMPTY
            } else {
                if (!insertItem(origin, 0, inv.size(), false)) return ItemStack.EMPTY
            }

            if(origin.isEmpty) slot.stack = ItemStack.EMPTY
            else slot.markDirty()
        }
        return newStack
    }
}
