package com.muxiyu.Learn;

import java.security.Key;
import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashMap {
    public static void main(String[] args) {
        //创建一个哈希表
        Hashtable hashtable=new Hashtable();
        Enumeration name;
        String string;
        double bal;
        hashtable.put("muxiyu",1);
        hashtable.put("jiangxiaobai",2);
        hashtable.put("muxu",3);
        hashtable.put("xiyu",4);
        hashtable.put("xi",5);
        hashtable.put("yu",6);
        //显示所有哈希表中的数值:
        name=hashtable.keys();
        while(name.hasMoreElements()){
            string= (String) name.nextElement();
            System.out.println(string + ": " +
                   hashtable.get(string));
        }
        System.out.println("remove(key,value):"+hashtable.remove("xiyu"));
        System.out.println("get:"+hashtable.get("muxiyu"));
        System.out.println("size:"+hashtable.size());
        System.out.println("contains:"+hashtable.contains("muxiyu"));
        System.out.println("containsKey:"+hashtable.containsKey("muxiyu"));
        System.out.println("containsValue:"+hashtable.containsValue(4));
        System.out.println("isEmpty:"+hashtable.isEmpty());
    }

}
