package Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳ش������߳�
 *  corePoolSize: ���ĳصĴ�С
 *  maximumPoolSize: ����߳���
 *  keepAliveTime: �߳�û������ʱ��ౣ�ֶ೤ʱ������ֹ
 */
public class ThreadPool {
    public static void main(String[] args) {
        //����һ���� ���ù̶��߳������̳߳�
        //�ӿ�->��,��̬
        ExecutorService excu=Executors.newFixedThreadPool(10);
        excu.execute(new Ticket());//������Runnable�ӿ�ʵ�ֶ�̳�
//        excu.submit();//������Callable
        //excu.execute(new trySync());
        //�ر��̳߳�
        excu.shutdown();
    }
}
class Ticket implements Runnable {
    private int ticket = 5;

    public void run() {
        //��д�߳���
        for (int i = 0; i < 100; i++) {
            /**
             * synchronized(ͬ��������){��Ҫͬ���Ĵ���}
             * ˵��:
             * 1.�����������ݵĴ��룬��Ϊ��Ҫ��ͬ���Ĵ���
             * 2.��������:����̹߳�ͬ�����ı���������: ticket���ǹ������ݡ�
             * 3.ͬ�����������׳�:�����κ�һ����Ķ��󣬶����Գ䵱����
             * 	Ҫ�����̱߳��빫��ͬһ����
             */
            Object object = new Object();
            synchronized (object) {/**�κ�����󶼿���*/
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "����" + ticket + "��Ʊ");
                    ticket--;
                }
            }
        }
    }
}