package Thread;
/**
 * �̵߳����ú�����stop����
 * yield()  �õ�ǰ�߳�ֹͣһ�Σ����������߳�ִ��
 * yield�������̲߳������������ֱ�ӽ������״̬
 * û�еȴ��̣߳�yield()��������ظ�ִ��
 */
public class TwoStop {

	public static void main(String[] args) {
		//�ڲ������Ĵ������ȴ����ⲿ�����
		TwoStop T=new TwoStop();
		//��ͨ���ⲿ����󴴽��ڲ������
		Test E=T.new Test();
		//�����Զ������ֵĴ����̶߳���
		Thread M1=new Thread(E,"AirFly�߳�1");
		Thread M2=new Thread(E,"AirFly�߳�2");
		//�߳�����
		M1.start();
		M2.start();
		
				
	}

public class Test extends Thread{
	//�߳�����
	public void run() {
		for(int n=0;n<3;n++) {
			if (n==2) {
				System.out.println(Thread.currentThread().getName()+"���ã�");
				Thread.yield();
			}
			System.out.println(Thread.currentThread().getName()+"n="+n);
		}
	}	
}

}