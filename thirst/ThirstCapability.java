package com.example.examplemod.thirst;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class ThirstCapability {

    @CapabilityInject(IThirst.class)
    public static Capability<IThirst> THIRST_CAPABILITY = null;

    public static final ResourceLocation ID =
            new ResourceLocation("examplemod", "thirst");
}
