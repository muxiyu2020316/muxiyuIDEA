package com.muxiyu.Learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestTraversArrayList {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("muxiyu");
        list.add("男");
        list.add(21);
        list.add(169.5);
        list.add("64KG");
        //第一种遍历方法使用 For-Each 遍历 List
        for (Object s:list) {
            System.out.print(s+"->");
        }
        System.out.println("\n"+list);
        System.out.println();
        //第二种遍历，把链表变为数组相关的内容进行遍历
        Object[]Array=new Object[list.size()];
        list.toArray(Array);
        for (Object c:Array ) {
            System.out.print(c+"->");
        }
        System.out.println();
        //第三种遍历 使用迭代器进行相关遍历
        Iterator iterable=list.iterator();
        while(iterable.hasNext()){
            System.out.print(iterable.next()+"->");
        }
    }
}
