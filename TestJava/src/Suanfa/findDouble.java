package Suanfa;

import java.util.HashMap;

public class findDouble {
    static int a[]={2,3,1,2,5,3,4,9,7};
    public static void main(String[] args) {
       method1();
       method2();
    }

    private static void  method2() {
        HashMap<Integer, Integer> a=new HashMap<>();
        a.put(2,1);
        a.put(3,1);
        a.put(1,1);
        a.put(2,1);
        a.put(5,1);
        a.put(3,1);
        a.put(4,1);
        a.put(9,1);
        a.put(7,1);
    }

    private static void method1() {
    }
}
