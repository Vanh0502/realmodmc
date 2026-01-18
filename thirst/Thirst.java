package com.example.examplemod.thirst;

public class Thirst implements IThirst {

    private int thirst = 20;
    private float exhaustion = 0;

    @Override
    public int getThirst() {
        return thirst;
    }

    @Override
    public void setThirst(int value) {
        thirst = Math.max(0, Math.min(20, value));
    }

    @Override
    public void addThirst(int value) {
        setThirst(thirst + value);
    }

    @Override
    public void addExhaustion(float value) {
        exhaustion += value;

        // 1.5 lần đói (đói là 4.0)
        while (exhaustion >= 6.0f) {
            exhaustion -= 6.0f;
            addThirst(-1);
        }
    }
}
