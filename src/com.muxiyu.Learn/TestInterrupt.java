package com.muxiyu.Learn;

public class TestInterrupt implements Runnable {
    @Override
    public void run() {
        int i = 0;
        try {
            while (i < 10) {
                // 睡个半秒钟我们再执行
                Thread.sleep(500);
                System.out.println(i++);
            }
        } catch (InterruptedException e) {
            // 判断该阻塞线程是否还在
            System.out.println(Thread.currentThread().isAlive());
            // 判断该线程的中断标志位状态
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("is not Runnable! Interrupt");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TestInterrupt testInterrupt=new TestInterrupt();
        // 创建线程并启动
        Thread thread=new Thread(testInterrupt,"main");
        System.out.println("This is main ");
        thread.start();
        //异常处理
        try{
        //在main线程休眠3秒
        Thread.sleep(3000);
        }catch(InterruptedException e){
            System.out.println("main sleep 3000ms!");
            e.printStackTrace();
        }
        //设置中断
        thread.interrupt();
    }
}
