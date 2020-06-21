package com.wzvtc.Animal;

public class Cat extends Animal {

    String name;

    public Cat(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println("小猫咻咻咻地吃");
    }

    void sleep() {
        System.out.println("小猫呼呼呼地睡");
    }

    public static void myStatic(){
        System.out.println("我是静态方法");
    }
}
