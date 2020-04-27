package NextLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<String ,Integer> map=new HashMap<>();
        map.put("muxiyu",12);
        map.put("muxiyu",12);
        map.put("yu",12);
        map.put("mu",12);
        System.out.println(map);
        //Map的遍历有三种
        Set<String> key1=map.keySet();//获取set值的集合
        //第一种,通过键找值
        for (String key:key1) {
          System.out.println("key:"+key+", values:"+map.values());
        }
        //第二种,通过entrySet
        Set<Map.Entry<String,Integer>> entries=map.entrySet();
        for (Map.Entry<String,Integer> en:entries ) {
         System.out.println("key:"+en.getKey()+", values:"+en.getValue());
        }
    }
}
