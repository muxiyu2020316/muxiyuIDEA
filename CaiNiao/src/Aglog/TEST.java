package Aglog;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TEST {

	public static void main(String[] args) {
		Thread t=new Thread(){
			public void run() {
				pong();
			}
		};
		t.run();
		System.out.println(true?false:true==true?false:true);
		System.out.print("ping");
		int counter=0;
		for(counter++;counter++<10;counter++) {
		System.out.println(counter);
		}
		String[] argg={"a","1","b","8","11oo"};
		Set s=new TreeSet();
		s.addAll(Arrays.asList(argg));
		System.out.println(s);

	}
	static void pong(){
		System.out.print("pong");
	}


}
