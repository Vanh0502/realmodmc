package com.example.examplemod;

import com.example.examplemod.thirst.*;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.example.examplemod.thirst.ThirstStorage;


@Mod(ExampleMod.MODID)
public class ExampleMod {

    public static final String MODID = "examplemod";

    public ExampleMod() {
        FMLJavaModLoadingContext.get().getModEventBus()
                .addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(
                IThirst.class,
                new ThirstStorage(),
                Thirst::new
        );
    }
}
