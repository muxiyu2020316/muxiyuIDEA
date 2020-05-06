package Synchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁Lock
 */
public class Locktest {
    public static void main(String[] args) {
        Widows widows=new Widows();
        widows.run();
    }
}
class Widows implements Runnable{
private static int ticket=10;
//加Lock锁,ReentrantLock,有参,加一个true
    private ReentrantLock lock=new ReentrantLock(true);
    @Override
    public void run() {
        while (true) {
            try {
                //枷锁
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(
                 Thread.currentThread().getName() + "卖第" + (ticket--) + "张票");
                }
            }finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
