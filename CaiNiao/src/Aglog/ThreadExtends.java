package Aglog;

public class ThreadExtends {
	public static void main(String[] args) {
   threads t1=new threads();
   t1.start();
   for (int i = 0; i < 10; i++) {
   System.out.println("��"+(i+1)+"��"+"���߳�");
	}
}
}
class threads extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("��"+i+"��"+"���߳�");
		}
	}	
}