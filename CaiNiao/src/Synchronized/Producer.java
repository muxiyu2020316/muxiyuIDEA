package Synchronized;
//生产者
public class Producer implements Runnable{
//共享资源
	private Goods good;
    public Producer(Goods good) {
		super();
		this.good=good;
	}
//实现run方法
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i%2==0) {
				good.set("小馒头", "旺仔");
			}else {
				good.set("矿泉水","娃哈哈");
			}
			
		}
		
	}

}
