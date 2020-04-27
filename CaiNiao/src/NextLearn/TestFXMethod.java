package NextLearn;

import java.util.*;

//如果实现接口指定了接口的泛型具体类型,那么,
// 该类实现接口的所有方法的位置都要替换成给出的事实际类型,等同于C++里的模板
public class TestFXMethod extends Db{
    //实现方法必须和接口类的实参一样
    public static void main(String[] args) {
        TX tx=new TX();
        Db db=new Db();
        TestFXMethod te=new TestFXMethod();

//        System.out.println(tx.test2("muxiyu"));
//        tx.test1("王八蛋");
//        tx.test3(1,2,3,7,10,11,"muxiyu","沐汐语",12.23,1.2f,'a');
//        tx.test3();
//
        List<String>list1=new ArrayList<>();
        list1.add("q");
        list1.add("qq");
        list1.add("qqq");
        list1.add("qqqs");
        List<Integer>list2=new Vector<>();
        list2.add(12);
        list2.add(11);
        list2.add(1);
//        db.test(list1);
          db.test(list2);
    }
    public void test3(List<? extends Db> list){
        for (Object a:list){
            System.out.print(a+" ");
        }
    }
}
class TX{
    //没有返回值的泛型方法
    public <T> void test1(T t){
        T s=t;
        System.out.println(s);
    }
    //又返回值的泛型方法
    public <T> T test2(T t){return t;}
    //可变参数
    public <T> void test3(T...s){
        for (T s1:s) {
          System.out.println(s1);
        }
    }
    //在类中定义的泛型可以在普通方法使用
    //在静态方法中,不能使用泛型,如果要用,只能使用静态方法自己定义的方法
    static  <T> T test3(T t){return t;}
}
class Db extends TX{
    public void test(List<?> list){
        for (Object a:list){
            System.out.print(a+" ");
        }
    }
        //需要一个list集合但是不去顶list集合到底有哪些数据,就需要通配符来发货作用
        //在Java源码及其方法可以看到很多通配符的例子
        public void test1(Set<? extends TX> set){
        Iterator  it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        }

}
