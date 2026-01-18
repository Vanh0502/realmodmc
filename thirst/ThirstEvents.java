package com.example.examplemod.thirst;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.ResourceLocation;

@Mod.EventBusSubscriber
public class ThirstEvents {

    // gắn capability cho player
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<PlayerEntity> event) {
        event.addCapability(
                new ResourceLocation("examplemod", "thirst"),
                new ThirstProvider()
        );
    }

    // logic tiêu thụ khát
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.player.level.isClientSide) return;

        PlayerEntity player = event.player;

        // ❌ đứng yên KHÔNG tụt
        if (!player.isSprinting()
                && !player.isSwimming()
                && player.getDeltaMovement().lengthSqr() < 0.002) {
            return;
        }

        player.getCapability(ThirstCapability.THIRST_CAPABILITY).ifPresent(thirst -> {

            // 🏃 chạy
            if (player.isSprinting()) {
                thirst.addExhaustion(0.15f); // x1.5 hunger
            }

            // 🏊 bơi
            if (player.isSwimming()) {
                thirst.addExhaustion(0.15f);
            }

            // 🦘 nhảy
            if (!player.isOnGround()) {
                thirst.addExhaustion(0.08f);
            }
        });
    }
}
