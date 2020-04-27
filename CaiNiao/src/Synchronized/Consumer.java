package Synchronized;
//消费者
public class Consumer implements Runnable {
	//共享资源
		private Goods good;
	    public Consumer(Goods good) {
			super();
			this.good=good;
		}
	//实现run方法
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				//调用商品类中取走商品的方法
				good.get();
			}
		}
}
