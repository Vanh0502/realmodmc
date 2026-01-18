package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.thirst.ThirstCapability;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = ExampleMod.MODID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class ThirstHUD {

    private static final ResourceLocation FULL =
            new ResourceLocation(ExampleMod.MODID, "textures/gui/thirst_full.png");

    @SubscribeEvent
    public static void onRender(RenderGameOverlayEvent.Post event) {

        if (event.getType() != RenderGameOverlayEvent.ElementType.FOOD) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) return;

        mc.player.getCapability(ThirstCapability.THIRST_CAPABILITY).ifPresent(thirst -> {

            MatrixStack ms = event.getMatrixStack();

            int screenW = mc.getWindow().getGuiScaledWidth();
            int screenH = mc.getWindow().getGuiScaledHeight();

            int x = screenW / 2 + 9;
            int y = screenH - 47;

            int value = thirst.getThirst();

            mc.getTextureManager().bind(FULL);

            for (int i = 0; i < 10; i++) {
                if (value - i * 2 > 0) {
                    AbstractGui.blit(
                            ms,
                            x + i * 8,
                            y,
                            0, 0,
                            10, 10,
                            10, 10
                    );
                }
            }
        });
    }
}
