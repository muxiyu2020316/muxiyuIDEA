package com.muxiyu.Learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestTraversrsMap {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("名字","muxiyu");
        map.put("年龄","21") ;
        map.put("性别","man");
        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key:map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        //第二种迭代器
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String ,String > entry=it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry:map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
        //第五种
        System.out.println("通过Map.key()遍历所有的key，但不能遍历values");
        for (String v : map.keySet()) {
            System.out.println("key= " + v);
        }
    }
}
