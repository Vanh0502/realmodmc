package com.example.examplemod.thirst;

public interface IThirst {

    int getThirst();
    void setThirst(int value);

    // thêm ↓↓↓
    void addThirst(int value);
    void addExhaustion(float value);
}
