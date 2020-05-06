package Synchronized;

public class trySync implements Runnable {
    private int ticket=5; 
	public void run() {
		//��д�߳���
		for (int i = 0; i <100; i++) {
			/**
			 * synchronized(ͬ��������){��Ҫͬ���Ĵ���}
			 * ˵��:
			 * 1.�����������ݵĴ��룬��Ϊ��Ҫ��ͬ���Ĵ���
			 * 2.��������:����̹߳�ͬ�����ı���������: ticket���ǹ������ݡ�
			 * 3.ͬ�����������׳�:�����κ�һ����Ķ��󣬶����Գ䵱����
			 * 	Ҫ�����̱߳��빫��ͬһ����
			 */
			Object object=new Object();
			synchronized(object) {/**�κ�����󶼿���*/
				if(ticket>0) {
					try {
						Thread.sleep(10);
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
