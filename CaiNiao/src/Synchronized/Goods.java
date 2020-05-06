package Synchronized;
//商品类
public class Goods {
boolean flag; 
   private String brand;//品牌
   private String name;//商品名称
   public Goods() {
	   
   }
private Goods(String brand, String name) {
	this.brand = brand;
	this.name = name;
}

public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
//生产商品的同步方法
public synchronized void set(String name,String brand) {
//boolean flag = true 有商品，所有生产者等待
if(flag) {
	try {
		super.wait();
	} catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
//notify()  唤醒后从wait()之后的代码开始执行
   this.setBrand(brand);
   try {
		Thread.sleep(100);
		
	} catch (InterruptedException e) {
       e.printStackTrace();
	}
   this.setName(name);
   System.out.println("生产者生产了"+this.getBrand()+"------>"+this.getName());
   flag=true;//生产完商品
   //通知消费者，唤醒消费者线程
   super.notify();
}

//取走商品的同步方法
public synchronized void get () {
	//boolean flage = true有商品，所有生产者等待
	if(!flag) {
		try {
			super.wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
//notify()  唤醒后从wait()之后的代码开始执行
	try {
			Thread.sleep(100);

		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	System.out.println("-------->消费者取走了"+this.getBrand()+"---"+this.getName());
	flag=false;//取走商品
	//唤醒生产者线程
	super.notify();
	 }
}
