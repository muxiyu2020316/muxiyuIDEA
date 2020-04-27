package NextLearn;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(112);
        list.add(12);
        List<Integer> list2=new ArrayList<>();
        list2.add(111);
        list2.add(11111);
        list2.add(111112);
        list2.add(121111);
        System.out.println(list);
        //翻转
        Collections.reverse(list);
        //拷贝,将s2拷贝到s1,s2的内容会替代s1
        Collections.copy(list,list2);

        System.out.println(list);
        //随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //字典升序排序
        Collections.sort(list);
        System.out.println(list);
        //指定位置,替换位置元素,前提,给出具体的集合
        Collections.swap(list,0,2);
        System.out.println(list);
        student s1=new student(21,"wangba");
        student s2=new student(12,"wangba");
        student s3=new student(11,"ba");
        student s4=new student(11,"abg");
        List<student>list1=new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        list1.add(s4);
        Collections.sort(list1,new student());
        Collections.swap(list1,1,2);
        //Random rm=new Random();
        //Collections.shuffle(list1,rm);
        for (Object o:list1) {
            System.out.println(o.toString());
        }
        System.out.println("最大值"+Collections.max(list1,new student()));
        System.out.println("最小值"+Collections.min(list1,new student()));
        System.out.println("元素出现次数"+Collections.frequency(list1,"wangba"));
    }
}
//如果比实现接口方法就只能变为抽象类,可是抽嫌累无法实例化对象
class student implements Comparator<student> {
    //存放person对象到Treeset,然后按年龄排序
    int age;
    String name;
    public student() {}
    public student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compare(student s1, student t1) {
        if(s1.age>t1.age)
            return 1;
        if(s1.age<t1.age)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "person{" +"age=" + age +", name='" + name + '\'' +'}';
    }

//    public int compare(student s1, student t1) {
//        int  temp =s1.age-t1.age;
//        return temp==0?s1.name.compareTo(t1.name):temp;
//    }
}
