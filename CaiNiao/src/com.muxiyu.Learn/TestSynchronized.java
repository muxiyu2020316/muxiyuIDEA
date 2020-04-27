package com.muxiyu.Learn;
public class TestSynchronized implements Runnable{
    public static void main(String[] args) {
    TestSynchronized testSynchronized=new TestSynchronized();
//创建线程执行静态方法
    Thread thread1=new Thread(()->{
        try{
            TestStatic();
        }catch (Exception e){
            e.printStackTrace();
        }
        });
// 创建线程执行实例方法
        Thread thread2=new Thread(testSynchronized,"沐汐语");
        try {
            testSynchronized.TestNoStatic();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();
    }
    //synchronized修饰非静态方法
    public synchronized  void TestNoStatic() throws InterruptedException{
        for (int i = 0; i <3 ; i++) {
            Thread.sleep(250);
            System.out.println("this is the TestNoStatic----->非静态");
        }
    }
//synchronized修饰静态方法
    public synchronized  static void TestStatic() throws InterruptedException{
        for (int i = 0; i <4 ; i++) {
            Thread.sleep(250);
            System.out.println("this is the TestStatic-------->静态");
        }
    }
    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName()+
               Thread.currentThread().getName());
    }
}
