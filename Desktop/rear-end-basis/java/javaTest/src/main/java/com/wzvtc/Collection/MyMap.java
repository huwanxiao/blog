package com.wzvtc.Collection;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MyMap {
    public static void main(String[] args) {
        //show1();     //遍历的集中方式
          show2();      //几种map之间的区别
        //show3();      //自定义类型键值
    }

    private static void show3() {
        Map<String,Person> map = new HashMap();
        map.put("北京",new Person("张三",18));
        map.put("上海",new Person("李四",19));
        map.put("广州",new Person("王五",20));
        map.put("北京",new Person("赵六",18));

        map.forEach((key,value) ->{
            System.out.println(key+" -> "+value.name+" -> "+value.age);
        });    //这是正常输出，有唯一值。这是因为String已经重写了hashcode和equal。如果键自定义类型，就要自己重写hashcode和equal

        System.out.println("-----------------------");

        Map<Person,String> map2 = new HashMap();
        map2.put(new Person("张三",18),"北京");
        map2.put(new Person("李四",19),"上海");
        map2.put(new Person("王五",20),"广州");
        map2.put(new Person("张三",18),"北京");

        map2.forEach((key,value) ->{
            System.out.println(value+" -> "+key.name+" -> "+key.age);
        });    //重写之前；来一次发现键值不唯一了。重写之后还是运行这个
             //标识key的规则是年龄个性别是否都一样，如果是就是同一个
    }

    private static void show2() {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Properties map3 = new Properties();      //hashtable不允许存空键和值。其他的map是可以的。
         // properties是唯一还活跃的hashtable，是他的子类。唯一与io流结合的集合

        map.put("aaa",111);
        map.put("bbb",222);
        map.put("ccc",333);
        map.put("ddd",444);
        map.put("aaa",111);
        map2.put("aaa",111);
        map2.put("bbb",222);
        map2.put("ccc",333);
        map2.put("ddd",444);
        map2.put("aaa",111);
        map3.put("aaa","111");
        map3.put("bbb","222");
        map3.put("ccc","333");
        map3.put("ddd","444");
        map3.put("aaa","111");
        System.out.println("linked:"+map);    //你会发现他是按输入的顺序输出的而且唯一。
        System.out.println("hash:"+map);    //你会发现他不是按输入的顺序输出的而且唯一。

        try {
            Properties loader = new Properties();
            FileWriter fw = new FileWriter("prop.txt");
            map3.store(fw,"test1");                 //store将集合中的数据持久化的保存在硬盘中
            fw.close();
            map3.store(new FileWriter("prop.txt",true),"test2"); //简化的写法
                                                               //load将硬盘中的数据读取到集合中进行使用
            loader.load(new FileReader("prop.txt"));
            loader.forEach((key,value) ->{
                System.out.println(key + " = " + value);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void show1(){
        HashMap<String,Integer> map = new HashMap();
        map.put("aaa",111);
        map.put("bbb",222);
        map.put("ccc",333);
        map.put("ddd",444);
        map.put("aaa",555);
        System.out.println(map);     //顺序没法确定；当键相同时会替换旧值
//        遍历的三种方式
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            Integer value = map.get(s);
            System.out.println(s+" = "+value);
        }
        System.out.println("-----------------------");
        Set<HashMap.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> Entry : entrySet) {
            System.out.println(Entry.getKey()+" = "+Entry.getValue());
        }
        System.out.println(entrySet);
        System.out.println("-----------------------");
        map.forEach((key,value) -> {
            System.out.println(key + " = " + value);
        });
        System.out.println("-----------------------");
    }
}
