package com.example.examplemod.thirst;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ThirstProvider implements ICapabilitySerializable<INBT> {

    private final Thirst thirst = new Thirst();
    private final LazyOptional<IThirst> optional = LazyOptional.of(() -> thirst);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ThirstCapability.THIRST_CAPABILITY
                ? optional.cast()
                : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return ThirstCapability.THIRST_CAPABILITY.getStorage()
                .writeNBT(ThirstCapability.THIRST_CAPABILITY, thirst, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        ThirstCapability.THIRST_CAPABILITY.getStorage()
                .readNBT(ThirstCapability.THIRST_CAPABILITY, thirst, null, nbt);
    }
}
