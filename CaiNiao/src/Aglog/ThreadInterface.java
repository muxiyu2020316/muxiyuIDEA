package Aglog;

public class ThreadInterface {

	public static void main(String[] args) {
		 ThreadTest t2=new ThreadTest();
		 ThreadTest t22=new ThreadTest();
		 Thread t33=new Thread(t22);
		 Thread t3=new Thread(t2,"feiyu");
		 t3.start();
		 t33.start();
		    for (int j = 0; j < 10; j++) {
		    	System.out.println(t3.currentThread().getName()+"第"+(j+1)+"次"+"主线程");
			}
	}
}
class ThreadTest implements Runnable{
	public void run() {
		for (int i = 0; i < 10; i++) {
		System.out.println("第"+i+"次"+"子线程");
	}
	}
}