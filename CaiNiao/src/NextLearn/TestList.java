package NextLearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(112);
        list.add(12);
        list.addAll(list);
        for (Object o:list ) {
            System.out.println(o);
        }
        //indexof()第一次出现的下标
        System.out.println(list.indexOf(12));
        //lastIndexof()第一次出现的下标
        System.out.println(list.lastIndexOf(12));
        //索引下标从0开始
        //按照指定索引下标修改元素
        list.set(2,123);
        //按照指定索引下标截取指定范围内的元素,形成新集合,截取包含开始索引,不包含结束索引
        System.out.println(list.subList(1,3));
    }
}
