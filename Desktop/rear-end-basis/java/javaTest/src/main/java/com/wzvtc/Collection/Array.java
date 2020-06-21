package com.wzvtc.Collection;

import com.wzvtc.Animal.Cat;

public class Array {
    public static void main(String[] args) {
        Cat[] arr = new Cat[3];      //用数组存一个类
        for (int i = 0; i < arr.length; i++) {
           arr[i] = new Cat("花花"+i);
        }
        for (Cat cat : arr) {
            System.out.println(cat.getName());
        }
    }


}
