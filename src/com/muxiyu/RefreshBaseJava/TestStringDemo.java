package com.muxiyu.RefreshBaseJava;

import java.util.ArrayList;
import java.util.List;

public class TestStringDemo {
    public static void main(String[] args) {
//String 类是不可改变
 // s 只是一个 String 对象的引用，并不是对象本身当执行 s = "Runoob"; 创建了一个新的对象 "Runoob"，而原来的 "Google" 还存在于内存中。
        String s="muxiyu";
        System.out.println("s1="+s);
        s ="jiangxiaobai";
        System.out.println("s2="+s);
//length()he size()方法的区别
String mu[]={"jiangxiaobai","tongli","muxiyu"};
String a="muxiyu";
        String b="xiyu";
        String c="muxi";
        List<String> list=new ArrayList<String>();
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println("数组array的长度为" + mu.length);
        System.out.println("字符串a的长度为" + a.length());
        System.out.println("list中元素个数为" + list.size());
String str1="muxiyu";
String str2=new String("muxiyu");
String str3="muxiyu";
String str4=new String ("muxiyu");
        System.out.println(str1==str2);//false
        System.out.println(str1==str3);//true
        System.out.println(str2==str4);//false

    }

}
