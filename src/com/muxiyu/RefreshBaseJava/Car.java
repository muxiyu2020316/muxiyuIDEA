package com.muxiyu.RefreshBaseJava;
 class Vehicle {
}
public class Car extends Vehicle{
    public static void main(String[] args) {
        Car c1 = new Car();
        //父类型的实例不能声明为子类型
        Vehicle c2 = new Vehicle(); //c2是Vehicle类型
        Vehicle v1 = new Car();    // v2 是 Car 类型
        Vehicle v2 = new Vehicle(); //多态的表现形式
        //Car（子类）是Vehicle（父类）类型, Vehicle（父类）不是Car（子类）类型
        boolean result1 =  c1 instanceof Vehicle;    // true
        boolean result2 =  c1 instanceof Car;        // true
        boolean result3 =  v1 instanceof Vehicle;    // true
        boolean result4 =  v1 instanceof Car;        // false
        boolean result5 =  v2 instanceof Vehicle;    // true
        boolean result6 =  v2 instanceof Car;        // true
        boolean result7 =  c2 instanceof Car;        // false
        boolean result8 =  c2 instanceof Vehicle;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
    }
}

