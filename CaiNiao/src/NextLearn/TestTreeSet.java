package NextLearn;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet{
    public static void main(String[] args) {
        Set set=new TreeSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(40000);
        set.remove(3);
        System.out.println(set.contains(1));
        //TreeSet的自然排序
        System.out.println(set);

        //Treeset的遍历
        //使用迭代器遍历
//        Iterator <Integer> it=set.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        for (Object i:set) {
//            System.out.println(i);
//        }

        person p1=new person(12,"muxiyu");
        person p2=new person(02,"mu");
        person p5=new person(02,"mu");
        person p3=new person(32,"xiyu");
        person p4=new person(16,"muwu");
        Set<person> s=new TreeSet(new person());
        s.add(p1);
        s.add(p2);
        s.add(p3);
        s.add(p4);
        s.add(p5);
        //Treeset的遍历
        //使用迭代器遍历
        Iterator <person> itr=s.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
//        for (Object p:s) {
//            System.out.println(p.toString());
//        }

    }

}
class person implements Comparator<person> {
    //存放person对象到Treeset,然后按年龄排序
    int age;
    String name;
    public person() {}
    public person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(person o, person t1) {
        //可以用三目运算符优化
         o=t1;
        if (this.age > t1.age)
            return 1;
        if (this.age < t1.age)
            return -1;
         else{
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "person{" +"age=" + age +", name='" + name + '\'' +'}';
    }
}