package Synchronized;
//������
public class GoodsTest {
	public static void main(String[] args) {
		//����������Դ����
	    Goods g=new Goods();
		//���������߶���
		Producer p=new Producer(g);
		//���������߶���
		Consumer c=new Consumer(g);
		//������������������߳�
		new Thread(p).start();
		new Thread(c).start();
	}
	
}
