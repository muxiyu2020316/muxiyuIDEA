package Synchronized;
//������
public class Consumer implements Runnable {
	//������Դ
		private Goods good;
	    public Consumer(Goods good) {
			super();
			this.good=good;
		}
	//ʵ��run����
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				//������Ʒ����ȡ����Ʒ�ķ���
				good.get();
			}
		}
}
