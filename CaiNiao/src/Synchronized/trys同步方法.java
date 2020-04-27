package Synchronized;

public class trys同步方法 implements Runnable {
	private int ticket=5;
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			sale();
		}
		
	}
	public synchronized void sale() {
		
		if(ticket>0) {
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
	            e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"卖第"+(ticket--)+"张票");
		
		}
	}
    
}
