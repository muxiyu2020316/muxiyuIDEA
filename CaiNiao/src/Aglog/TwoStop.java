package Thread;
/**
 * 线程的礼让和两种stop方法
 * yield()  让当前线程停止一次，允许其他线程执行
 * yield（）的线程不会进入阻塞，直接进入就绪状态
 * 没有等待线程，yield()进程立马回复执行
 */
public class TwoStop {

	public static void main(String[] args) {
		//内部类对象的创建，先创建外部类对象
		TwoStop T=new TwoStop();
		//在通过外部类对象创建内部类对象
		Test E=T.new Test();
		//创建自定义名字的代理线程对象
		Thread M1=new Thread(E,"AirFly线程1");
		Thread M2=new Thread(E,"AirFly线程2");
		//线程启动
		M1.start();
		M2.start();
		
				
	}

public class Test extends Thread{
	//线程礼让
	public void run() {
		for(int n=0;n<3;n++) {
			if (n==2) {
				System.out.println(Thread.currentThread().getName()+"礼让！");
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+"n="+n);
		}
	}	
}

}