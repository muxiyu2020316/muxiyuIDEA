package Synchronized;

public class trysͬ������� implements Runnable {
    private int ticket=5; 
	public void run() {
		//��д�߳���
		for (int i = 0; i <100; i++) {
			synchronized(this) {
				if(ticket>0) {
					try {
						Thread.sleep(110);
						
					} catch (InterruptedException e) {
			            e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"����"+ticket+"��Ʊ");
					ticket--;
				}
			}
		}
	}
	   
   } 
