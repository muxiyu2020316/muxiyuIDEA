package Aglog;

//线程的强制执行
public class join {

	public static void main(String[] args) {
		//创建线程类对象
		nomalThread t4=new nomalThread();
		//创建代理类对象
		Thread t=new  Thread(t4);
		//启动线程类
		t.start();
		//主线程代码
		for (int i = 0; i <5; i++) {
			if(i<2) {
			try {
				/**jion调用此方法，强制执行，
				其他线程处于阻塞状态，结束后，其他进程再回复
				*/
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		System.out.println(Thread.currentThread().getName()+"i="+i);
		}
		System.out.println("**************************************************************");
		nomalThread t2=new nomalThread();
		Thread ts=new Thread(t2,"wangyiyang");
		ts.start();
	
	}
}
