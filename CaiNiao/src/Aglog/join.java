package Aglog;

//�̵߳�ǿ��ִ��
public class join {

	public static void main(String[] args) {
		//�����߳������
		nomalThread t4=new nomalThread();
		//�������������
		Thread t=new  Thread(t4);
		//�����߳���
		t.start();
		//���̴߳���
		for (int i = 0; i <5; i++) {
			if(i<2) {
			try {
				/**jion���ô˷�����ǿ��ִ�У�
				�����̴߳�������״̬�����������������ٻظ�
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
