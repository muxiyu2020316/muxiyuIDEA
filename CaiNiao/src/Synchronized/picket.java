package Synchronized;

public class picket {

	public static void main(String[] args) {
		//创建线程对象
		trySync t=new trySync();
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
