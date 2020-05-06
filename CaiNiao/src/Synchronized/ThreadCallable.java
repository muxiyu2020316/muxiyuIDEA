package Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK 5.0����
 * ��ʹ��Runnable��ȣ� Callable���ܸ�ǿ��Щ
 * ?call()������д
 * ?���run()�����������з���ֵ
 * ?���������׳��쳣
 * ?֧�ַ��͵ķ���ֵ
 * ?��Ҫ����FutureTask�࣬�����ȡ���ؽ��
 * Future�ӿ�
 * ?���ԶԾ���Runnable. Callable�����ִ�н������ȡ������ѯ�Ƿ���ɡ���ȡ����ȡ�
 * ?FutrueTask��Futrue�ӿڵ�Ψһ��ʵ����
 * ?FutureTaskͬʱʵ����Runnable, Future�ӿڡ����ȿ�����Ϊ
 * 	Runnable���߳�ִ�У��ֿ�����ΪFuture�õ�Callable�ķ���ֵ
 */
public class ThreadCallable {
    public static void main(String[] args) {
        packge pack=new packge();

        FutureTask ftk=new FutureTask(pack);
        new Thread(ftk).start();
        try {
            Object bag=ftk.get();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class packge implements Callable{
    private int ticket = 20;
    @Override
    public Object call(){
        //��д�߳���
        for (int i = 0; i < 20; i++) {
            Object object = new Object();
            synchronized (object) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.currentThread().setName("bag"+i);
                    System.out.println(Thread.currentThread().getName() + "����" + ticket + "��Ʊ");
                    ticket--;
                }
            }
        }
        return null;
    }

}