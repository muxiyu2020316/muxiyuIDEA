package Synchronized;

public class trysSyncMethod implements Runnable {
	private int ticket=5;
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			sale();
		}
	}
	/**
	 * synchronized (同步方法){需要同步的代码}
	 *  public synchronized void sale(){}
	 *  不适合在run方法中加synchronized关键字
	 *  关于同步方法的总结
	 *  1.同步方法设计同步监视器,不需要显示申明
	 *  2.非静态的同步方法同步监视器是this
	 *     静态的同步方法,同步监视器是类本身
	 */
	public synchronized void sale() {
		if(ticket>0) {
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
	            e.printStackTrace();
			}
			System.out.println(
	Thread.currentThread().getName()+"卖第"+(ticket--)+"张票");
		}
	}
}
