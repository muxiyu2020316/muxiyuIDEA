package Synchronized;
//������
public class Producer implements Runnable{
//������Դ
	private Goods good;
    public Producer(Goods good) {
		super();
		this.good=good;
	}
//ʵ��run����
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i%2==0) {
				good.set("С��ͷ", "����");
			}else {
				good.set("��Ȫˮ","�޹���");
			}
			
		}
		
	}

}
