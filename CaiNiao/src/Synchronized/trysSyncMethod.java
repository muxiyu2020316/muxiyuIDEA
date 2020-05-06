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
	 * synchronized (ͬ������){��Ҫͬ���Ĵ���}
	 *  public synchronized void sale(){}
	 *  ���ʺ���run�����м�synchronized�ؼ���
	 *  ����ͬ���������ܽ�
	 *  1.ͬ���������ͬ��������,����Ҫ��ʾ����
	 *  2.�Ǿ�̬��ͬ������ͬ����������this
	 *     ��̬��ͬ������,ͬ�����������౾��
	 */
	public synchronized void sale() {
		if(ticket>0) {
			try {
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
	            e.printStackTrace();
			}
			System.out.println(
	Thread.currentThread().getName()+"����"+(ticket--)+"��Ʊ");
		}
	}
}
