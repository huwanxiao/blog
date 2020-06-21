package com.wzvtc.Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Foreach {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(9);array.add(1);array.add(6);array.add(3);array.add(2);array.add(0);
        array.forEach(obj -> {obj++;System.out.println("for:"+obj);} );

        for (Integer integer : array) {
            integer++;
            System.out.println("fori"+integer);
        }

        Iterator<Integer> it = array.iterator();
        it.forEachRemaining(obj -> {obj++;System.out.println("iterator2 "+obj);});

        while(it.hasNext()){
            int t = it.next();
            System.out.println("iterater"+t++);
        }

        for (int i = 0; i < array.size(); i++) {
            System.out.println("for"+array.get(i));
        }
    }
}
