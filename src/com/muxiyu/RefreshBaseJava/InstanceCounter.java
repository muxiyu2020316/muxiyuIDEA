package com.muxiyu.RefreshBaseJava;

public class InstanceCounter {
    //定义了一个静态变量并且初始化
    private static int numInstances=0;
    //静态方法
    private  static int getCount(){
        return numInstances;
    }
    private  static void addInstance(){
       numInstances++;
    }
    InstanceCounter(){
        InstanceCounter.addInstance();
    }
    public static void main(String[] args) {
        System.out.println("Starting with " + InstanceCounter.getCount() + " instances");
         MyRunnable myRunnable1=new MyRunnable();
         myRunnable1.stop();
         MyRunnable myRunnable2=new MyRunnable();
         myRunnable2.run();
    }
    //抽象类
    abstract class Caravan{
        private double price;
        private String model;
        private String year;
        //抽象方法没有方法体,只有方法的定义
        public abstract void goFast();
        public abstract void changeColor();
    }
    //继承抽象类的子类
    class Testabstract extends Caravan{

        @Override
        public void goFast() {
            //继承抽象类的方法并实现他们
        }

        @Override
        public void changeColor() {

        }
    }
    //volatile修饰符
    static class MyRunnable implements Runnable
    {
        private volatile boolean active;
        public void run()
        {
            active = true;
            while (active) // 第一行
            {
                for (int i = 0; i < 500; ++i){
                    new InstanceCounter();
                }
            }
            System.out.println("Created 1= " + InstanceCounter.getCount() + " instances");

        }
        public void stop()
        {
            active = false; // 第二行
            while (active) // 第一行
            {
                for (int i = 0; i < 20; ++i){
                    new InstanceCounter();
                }
            }
            System.out.println("Created 2= " + InstanceCounter.getCount() + " instances");
    }

    }
}
