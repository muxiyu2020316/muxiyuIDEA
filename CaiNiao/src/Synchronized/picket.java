package Synchronized;

public class picket {

	public static void main(String[] args) {
		//�����̶߳���
		trySync t=new trySync();
		//�������������
		Thread t1=new Thread(t,"a");
		Thread t2=new Thread(t,"b");
		Thread t3=new Thread(t,"c");
		//�����߳�
		t1.start();
		t2.start();
		t3.start();

	}
}
