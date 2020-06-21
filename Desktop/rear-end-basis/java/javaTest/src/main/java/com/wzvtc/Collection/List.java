package com.wzvtc.Collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Vector;

//List接口继承自Collecction包括了Arrylist、linkedlist、vector
//2.1 ArrayList底层是以数组实现的。在增加和删除指定位置元素时会重新常见数组，效率低，但便利时效率高
//2.2 LinkedList是双向链表实现，适合于经常进行增删操作，但是查询和修改效率没ArrayList、Vector快。
//2.3 Vector与ArrayList类似,也是数组实现，但是他是同步的,是线程安全的，不会有并发产生的问题，但是效率要低
public class List {
    public static void main(String[] args) {
        //1、创建
        ArrayList arr = new ArrayList();
        ArrayList<Integer> array = new ArrayList();
        LinkedList link = new LinkedList();
        Vector vector = new Vector();
        //2、list的使用
//        arr.add("aa");arr.add(11);arr.add(true);arr.add(2.33); //这种虽然方便，但是在需要类型转换的时候容易出错
//        arr.addAll(0,arr); //重复一遍
//        System.out.println(arr.get(0));arr.set(0,"bb");arr.remove(arr.size()-1);
//        System.out.println(arr);
//        System.out.println(arr.subList(0, 2)); //打印0-1个元素
//        array.add(9);array.add(1);array.add(6);array.add(3);array.add(2);array.add(0);
//        array.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return  o2.compareTo(o1);
//            }
//        });
//        System.out.println(array);

//        link.add("stu1");link.add("stu2");link.add("stu3");
//        System.out.println(link);
//        link.offer("offer");      //向集合尾部添加
//        link.push("push");        //向集合头部添加
//        System.out.println(link);
//        System.out.println(link.peek()); //获得第一个，以上三个都没有返回值。pop有
//        link.removeFirst();
//        link.pollLast();
//        System.out.println(link);    //remove与poll作用相同，一处且返回


    }
}
