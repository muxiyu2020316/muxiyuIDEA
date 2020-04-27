package Synchronized;

public class trys同步代码块 implements Runnable {
    private int ticket=5; 
	public void run() {
		//编写线程体
		for (int i = 0; i <100; i++) {
			synchronized(this) {
				if(ticket>0) {
					try {
						Thread.sleep(110);
						
					} catch (InterruptedException e) {
			            e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"张票");
					ticket--;
				}
			}
		}
	}
	   
   } 
