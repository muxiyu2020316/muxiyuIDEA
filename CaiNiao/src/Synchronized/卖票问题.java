package Synchronized;

public class 卖票问题 {

	public static void main(String[] args) {
		//创建线程对象
		trys同步代码块 t=new trys同步代码块();
		//创建代理类对象
		Thread t1=new Thread(t,"a");
		Thread t2=new Thread(t,"b");
		Thread t3=new Thread(t,"c");
		//启动线程
		t1.start();
		t2.start();
		t3.start();

	}
}
