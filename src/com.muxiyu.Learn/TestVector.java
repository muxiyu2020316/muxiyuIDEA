package com.muxiyu.Learn;

import java.util.*;

public class TestVector {
    public static void main(String[] args) {
        //增量表示向量每次增加的元素数目
        Vector<java.io.Serializable> vector=new Vector<java.io.Serializable>(10,3);//默认大小为10
        System.out.println("capacity="+vector.capacity()+",size="+vector.size());
        vector.add(1);
        vector.add(1,"muxiyu");
        vector.addElement("jiangxiaobai");
        vector.addElement("xiaobai");
        vector.addElement("江小白");
        vector.addElement("沐汐语");
        //vector.remove(1);
        vector.removeElementAt(3);
        System.out.println("set="+vector.set(2,"赵丽颖"));
        System.out.println("get="+vector.get(3));
        System.out.println("indexof="+vector.indexOf(1));
        System.out.println(vector.contains("muxiyu"));
        System.out.println("Capacity after =" + vector.capacity()+",size="+vector.size());
        System.out.println("First element="+vector.firstElement());
        System.out.println("Last element=" +vector.lastElement());
        Enumeration vEnum = vector.elements();
        System.out.println("Elements in vector:");
        while(vEnum.hasMoreElements())
            System.out.print(vEnum.nextElement() + " ");
            System.out.println();
    }
}
