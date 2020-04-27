package RefreshBaseJava;

import java.util.List;
class Food {}
class Fruit extends Food {}
class Apple extends Fruit {}
class Banana extends Fruit{}
//测试泛型
public class GenericTest {
    //用来测试上街通配符和下界通配符的实例.
public void testExtends(List<? extends Fruit> list){
    //报错,extends为上界通配符,只能取值,不能放.
    //因为Fruit的子类不只有Apple还有Banana,
    // 这里不能确定具体的泛型到底是Apple还是Banana
    // 所以放入任何一种类型都会报错
    //list.add(new Apple());
    Fruit fruit=list.get(1);
}
public void testSuper(List<? super Fruit>list){
    //super为下界通配符，可以存放元素
    //但是只能存放当前类或者子类的实例
    list.add(new Apple());
    //无法确定Fruit的父类是否只有Food一个(Object是超级父类)
    //list.add(new Food());
    Object object = list.get(1);
}
}
