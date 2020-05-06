package Synchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ƽ��Lock
 */
public class Locktest {
    public static void main(String[] args) {
        Widows widows=new Widows();
        widows.run();
    }
}
class Widows implements Runnable{
private static int ticket=10;
//��Lock��,ReentrantLock,�в�,��һ��true
    private ReentrantLock lock=new ReentrantLock(true);
    @Override
    public void run() {
        while (true) {
            try {
                //����
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(
                 Thread.currentThread().getName() + "����" + (ticket--) + "��Ʊ");
                }
            }finally {
                //����
                lock.unlock();
            }
        }
    }
}
