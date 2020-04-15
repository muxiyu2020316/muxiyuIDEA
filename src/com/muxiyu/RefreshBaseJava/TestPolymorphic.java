package com.muxiyu.RefreshBaseJava;
public class TestPolymorphic {
    public static void main(String[] args) {
        System.out.println("测试静态方法重写的区别");
        Animals animals=new Dogs();
        Animals bigfish=new Dogs("muxiyu",2);
        Animals dogs=new Animals();
       Dogs tiger= new Dogs();

        animals.hello();
        bigfish.hello();
        dogs.hello();
        tiger.hello();

        animals.TestPolymorphic();
        bigfish.TestPolymorphic();
        dogs.TestPolymorphic();

        animals.getInfo();
        animals.getSuperInfo();
        bigfish.getInfo();
    }
}
class Animals {
    String name;
    int age;
    public Animals() {
        name = "alex";
        age = 1;
    }
    public Animals(String nm, int ag) {
        name = nm;
        age = ag;
    }
    public void getInfo() {
        System.out.print(name + "'s age is " + age + '\n');
    }
    public void getSuperInfo() {}
    public static void hello() {
        System.out.println("Greeting from Animal");
    }
    public void TestPolymorphic(){
        System.out.println("哈哈哈,我是父类Animals的testPolymorphic 方法");
    }
}
class Dogs extends Animals {
    String name;
    int age;
    public Dogs() {
        name = "prter";
        age = 3;
    }
    public Dogs(String nm, int ag) {
        super(nm, ag);
    }
    public void getInfo() {
        System.out.print(name + "'s age is " + age + '\n');
    }
    // 通过super显式调用父类的非静态成员方法
    public void getSuperInfo() {
        super.getInfo();
    }
    public static void hello() {
        System.out.println("Greeting from Animal to --> Dog");
    }
    public void TestPolymorphic(){
        System.out.println("哈哈哈,我是子类Dogs的testPolymorphic 方法");
    }
}