package com.wzvtc.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MySet {
    //set接口并没有对collect接口进行功能上扩充，只是比collect接口更严格。与list接口相比set接口中元素无序且不重复
    //顾名思义，Hashset根据对象的哈希值确定在集合中的位置，去油了良好的查找和存取性能
    //treeset以二叉树形式存储对象，它可以对元素进行排序
    //也就是说set在存储前会以他的方式处理集合中的元素
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(9);hashSet.add(1);hashSet.add(6);hashSet.add(3);hashSet.add(2);hashSet.add(0);hashSet.add(9);
        System.out.println(hashSet);

        TreeSet<Integer> tree =  new TreeSet<>();
        tree.add(9);tree.add(1);tree.add(6);tree.add(3);tree.add(2);tree.add(0);tree.add(9);
        System.out.println(tree);
        System.out.println(tree.lower(3));
        System.out.println(tree.floor(3));
        System.out.println(tree.higher(3));
        System.out.println(tree.ceiling(3));
    }

}
