package Aglog;
//�Զ����߳�Ĭ������
public class nomalThread implements Runnable{
	
	public void run() {
		        //��ȡ��ǰ�̵߳ö���
				Thread t1=Thread.currentThread();
				//��ȡ��ǰ�߳�����  getName()
				System.out.println("��ǰ�̵߳�����"+t1.getName());
				//��ȡ��ǰ�߳����ȼ�       getPriority()
				System.out.println("��ǰ�̵߳����ȼ�"+t1.getPriority());
				
				/**
				 * sleep  ��ǰ����ִ�е��߳�����m�룬�̴߳�������״̬
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
