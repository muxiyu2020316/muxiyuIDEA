package Aglog;
//自定义线程默认名字
public class nomalThread implements Runnable{
	
	public void run() {
		        //获取当前线程得对象
				Thread t1=Thread.currentThread();
				//获取当前线程名称  getName()
				System.out.println("当前线程的名字"+t1.getName());
				//获取当前线程优先级       getPriority()
				System.out.println("当前线程的优先级"+t1.getPriority());
				
				/**
				 * sleep  当前正在执行的线程休眠m秒，线程处于阻塞状态
				 */
				for (int m = 0; m <5; m++) {
					if(m>2) {
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				System.out.println(Thread.currentThread().getName()+"m="+m);
				}
				
	}
}
