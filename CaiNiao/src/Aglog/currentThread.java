package Aglog;

public class currentThread {
	public static void main(String[] args) {
		//��ȡ��ǰ�̵߳ö���
		Thread t1=Thread.currentThread();
		//��ȡ��ǰ�߳�����  getName()
		System.out.println("��ǰ�̵߳�����"+t1.getName());
		//��ȡ��ǰ�߳����ȼ�       getPriority()
		System.out.println("��ǰ�̵߳����ȼ�"+t1.getPriority());
		//�̵߳�������ȼ�   Thread.MAX_PRIORITY
		System.out.println("������ȼ�"+Thread.MAX_PRIORITY);
		//�̵߳�������ȼ�  Thread.MIN_PRIORITY
		System.out.println("�̵߳�������ȼ�"+Thread.MIN_PRIORITY);
		//�̵߳�Ĭ�����ȼ�   Thread.NORM_PRIORITY
		System.out.println("�̵߳�Ĭ�����ȼ�"+Thread.NORM_PRIORITY);
		//�޸��̵߳����ȼ�   setPriority()
		t1.setPriority(9);
		System.out.println("��ǰ�̵߳����ȼ�"+t1.getPriority());
		System.out.println("*****************************************************************");


		//�����Զ����߳�����
		nomalThread t4=new nomalThread();
		nomalThread t2=new nomalThread();
		nomalThread t3=new nomalThread();
		Thread t=new  Thread(t4);
		new  Thread(t2).start();
		System.out.println("�߳�����ǰ�Ƿ��ڻ״̬"+t.isAlive());
		t.start();
		new  Thread(t3).start();
		System.out.println("******************************************************************");
		System.out.println("�߳��������Ƿ��ڻ״̬"+t.isAlive());

		for (int k = 0; k < 3; k++) {
			System.out.println(Thread.currentThread().getName()+"k="+k);
		}
		System.out.println("���߳̽������Ƿ��ڻ״̬"+t.isAlive());
	}
}
