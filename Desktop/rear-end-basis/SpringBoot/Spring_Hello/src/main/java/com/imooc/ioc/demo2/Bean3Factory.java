package com.imooc.ioc.demo2;

public class Bean3Factory {
    public Bean3 createBean3(){
        System.out.println("Bean3Factory has woeked");
        return new Bean3();
    }
}
