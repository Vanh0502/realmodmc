package com.example.examplemod;

import com.example.examplemod.thirst.ThirstCapability;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RealisticEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        event.player.getCapability(ThirstCapability.THIRST_CAPABILITY).ifPresent(thirst -> {
            thirst.addThirst(-1);
        });
    }
}
