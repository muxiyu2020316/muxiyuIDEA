package NextLearn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("muxiyu");
        set.add(1);
        set.add('1');
        //不允许有重复元素
        set.add(1);
        //是否包含
        set.contains(1);
        //set集合的遍历
        Iterator it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //set元素为止,取出所有值赋值给Objiect对象
        for (Object obj:set) {
            System.out.println(obj);
        }
        //获取集合大小
        set.size();
        //hashcode方法
        System.out.println(set.hashCode());
    }
}
