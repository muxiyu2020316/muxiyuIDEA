package muxiyu.Learn;

public class TestThread implements Runnable{
    @Override
    public void run() {
        // 打印出当前线程的名字
        System.out.printf(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        Thread thread1=new Thread(testThread,"我是沐汐语!  ");
        Thread thread2=new Thread(testThread,"一个随遇而安的少年  ");
        //thread2.setDaemon(false);
        thread1.setDaemon(true);
        thread1.start();
        thread1.setPriority(10);
        thread2.setPriority(2);
        thread2.start();
        // 打印当前线程的名字
        System.out.println(Thread.currentThread().getName()+thread1.getPriority());
        thread1.setName("江小白");
        System.out.println(thread1.getName()+thread2.getPriority());
    }
}
