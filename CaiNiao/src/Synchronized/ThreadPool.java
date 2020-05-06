package Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建多线程
 *  corePoolSize: 核心池的大小
 *  maximumPoolSize: 最大线程数
 *  keepAliveTime: 线程没有任务时最多保持多长时间后会终止
 */
public class ThreadPool {
    public static void main(String[] args) {
        //创建一个可 重用固定线程数的线程池
        //接口->类,多态
        ExecutorService excu=Executors.newFixedThreadPool(10);
        excu.execute(new Ticket());//适用于Runnable接口实现多继承
//        excu.submit();//适用于Callable
        //excu.execute(new trySync());
        //关闭线程池
        excu.shutdown();
    }
}
class Ticket implements Runnable {
    private int ticket = 5;

    public void run() {
        //编写线程体
        for (int i = 0; i < 100; i++) {
            /**
             * synchronized(同步监视器){需要同步的代码}
             * 说明:
             * 1.操作共享数据的代码，即为需要被同步的代码
             * 2.共享数据:多个线程共同操作的变量。比如: ticket就是共享数据。
             * 3.同步监视器，俗称:锁。任何一个类的对象，都可以充当锁。
             * 	要求多个线程必须公用同一个锁
             */
            Object object = new Object();
            synchronized (object) {/**任何类对象都可以*/
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}