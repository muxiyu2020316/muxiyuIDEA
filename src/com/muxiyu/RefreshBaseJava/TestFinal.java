package com.muxiyu.RefreshBaseJava;

public class TestFinal {
    //初始化方式一，在定义变量时直接赋值
    private final int i = 3;

    //初始化方式二,声明完变量后在构造方法中为其赋值
    //如果采用用这种方式，那么每个构造方法中都要有j赋值的语句
    private int j=9;
    //无参构造器
    public TestFinal() {

    }
    public int FinalTest() {
        return  j;
    }
    public TestFinal(String str) {
        this();  //调用无参构造器
    }
    //下面的代码同样会报错，因为对j重复赋值
    public TestFinal(String str1, String str2) {
        this();
        j = 3;
    }
    static class FinalTest{
        //-----------------类变量（静态变量）------------------//
        //初始化方式一，在定义类变量时直接赋值
        public final static int p = 3;

        //初始化方式二，在静态代码块中赋值
        //成员变量可以在构造函数中赋值，但是类变量却不可以。
        //因此成员变量属于对象独有，每个对象创建时只会调用一次构造函数，
        //因此可以保证该成员变量只被初始化一次；
        //而类变量是该类的所有对象共有，每个对象创建时都会对该变量赋值
        //这样就会造成变量的重复赋值。
        public final static int q;

        static {
            q = 3;
        }

    }

    public static void main(String[] args) {

    }
}

