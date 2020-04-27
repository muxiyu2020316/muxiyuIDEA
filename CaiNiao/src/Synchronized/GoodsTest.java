package Synchronized;
//测试类
public class GoodsTest {
	public static void main(String[] args) {
		//创建共享资源对象
	    Goods g=new Goods();
		//创建生产者对象
		Producer p=new Producer(g);
		//创建消费者对象
		Consumer c=new Consumer(g);
		//创建代理类对象，启动线程
		new Thread(p).start();
		new Thread(c).start();
	}
	
}
