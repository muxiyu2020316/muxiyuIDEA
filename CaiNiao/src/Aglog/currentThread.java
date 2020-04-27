package Aglog;

public class currentThread {
	public static void main(String[] args) {
		//获取当前线程得对象
		Thread t1=Thread.currentThread();
		//获取当前线程名称  getName()
		System.out.println("当前线程的名字"+t1.getName());
		//获取当前线程优先级       getPriority()
		System.out.println("当前线程的优先级"+t1.getPriority());
		//线程的最高优先级   Thread.MAX_PRIORITY
		System.out.println("最高优先级"+Thread.MAX_PRIORITY);
		//线程的最低优先级  Thread.MIN_PRIORITY
		System.out.println("线程的最低优先级"+Thread.MIN_PRIORITY);
		//线程的默认优先级   Thread.NORM_PRIORITY
		System.out.println("线程的默认优先级"+Thread.NORM_PRIORITY);
		//修改线程的优先级   setPriority()
		t1.setPriority(9);
		System.out.println("当前线程的优先级"+t1.getPriority());
		System.out.println("*****************************************************************");


		//测试自定义线程名字
		nomalThread t4=new nomalThread();
		nomalThread t2=new nomalThread();
		nomalThread t3=new nomalThread();
		Thread t=new  Thread(t4);
		new  Thread(t2).start();
		System.out.println("线程启动前是否处于活动状态"+t.isAlive());
		t.start();
		new  Thread(t3).start();
		System.out.println("******************************************************************");
		System.out.println("线程启动后是否处于活动状态"+t.isAlive());

		for (int k = 0; k < 3; k++) {
			System.out.println(Thread.currentThread().getName()+"k="+k);
		}
		System.out.println("主线程结束，是否处于活动状态"+t.isAlive());
	}
}
