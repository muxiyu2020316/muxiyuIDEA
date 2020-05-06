package Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK 5.0新增
 * 与使用Runnable相比， Callable功能更强大些
 * ?call()方法重写
 * ?相比run()方法，可以有返回值
 * ?方法可以抛出异常
 * ?支持泛型的返回值
 * ?需要借助FutureTask类，比如获取返回结果
 * Future接口
 * ?可以对具体Runnable. Callable任务的执行结果进行取消、查询是否完成、获取结果等。
 * ?FutrueTask是Futrue接口的唯一的实现类
 * ?FutureTask同时实现了Runnable, Future接口。它既可以作为
 * 	Runnable被线程执行，又可以作为Future得到Callable的返回值
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
        //编写线程体
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
                    System.out.println(Thread.currentThread().getName() + "卖第" + ticket + "张票");
                    ticket--;
                }
            }
        }
        return null;
    }

}