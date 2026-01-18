package com.example.examplemod.thirst;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class ThirstStorage implements Capability.IStorage<IThirst> {

    @Override
    public INBT writeNBT(Capability<IThirst> capability, IThirst instance, Direction side) {
        return IntNBT.valueOf(instance.getThirst());
    }

    @Override
    public void readNBT(Capability<IThirst> capability, IThirst instance, Direction side, INBT nbt) {
        if (nbt instanceof IntNBT) {
            instance.setThirst(((IntNBT) nbt).getAsInt());
        }
    }
}
