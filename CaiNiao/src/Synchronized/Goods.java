package Synchronized;
//��Ʒ��
public class Goods {
boolean flag; 
   private String brand;//Ʒ��
   private String name;//��Ʒ����
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
//������Ʒ��ͬ������
public synchronized void set(String name,String brand) {
//boolean flag = true ����Ʒ�����������ߵȴ�
if(flag) {
	try {
		super.wait();
	} catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
//notify()  ���Ѻ��wait()֮��Ĵ��뿪ʼִ��
   this.setBrand(brand);
   try {
		Thread.sleep(100);
		
	} catch (InterruptedException e) {
       e.printStackTrace();
	}
   this.setName(name);
   System.out.println("������������"+this.getBrand()+"------>"+this.getName());
   flag=true;//��������Ʒ
   //֪ͨ�����ߣ������������߳�
   super.notify();
}

//ȡ����Ʒ��ͬ������
public synchronized void get () {
	//boolean flage = true����Ʒ�����������ߵȴ�
	if(!flag) {
		try {
			super.wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
//notify()  ���Ѻ��wait()֮��Ĵ��뿪ʼִ��
	try {
			Thread.sleep(100);

		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	System.out.println("-------->������ȡ����"+this.getBrand()+"---"+this.getName());
	flag=false;//ȡ����Ʒ
	//�����������߳�
	super.notify();
	 }
}
