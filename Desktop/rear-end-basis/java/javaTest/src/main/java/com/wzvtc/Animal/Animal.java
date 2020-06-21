package com.wzvtc.Animal;

public abstract class Animal {
    int num = 0;
    abstract void eat();
    abstract void sleep();

    public int getNum() {
        return num;
    }
}
