package RefreshBaseJava;

import java.util.Arrays;

public class VarargsDemo {
    //可变参数的使用;
    /**
     在方法声明中，在指定参数类型后加一个省略号(...) 。
     一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。
     任何普通的参数必须在它之前声明
     对于可变参数，编译器会将其转型为一个数组，故在函数内部，可变参数名可看作数组名。
     */
    public static void main(String[] args) {
        double []a=new double[]{2,3,4,5,6,8,};
        printMax(a, new double[]{1, 2, 3});
//调用可变参数方法,相当于一个数组
        printMax(a, 2,3,14,33,89,104,234);
    }
    //可变参数方法
    static void printMax(double[] a, double... number){
        int i;
        if(number.length==0){
            System.out.println("No argument paseed!");
            return;
        }
        if (a.length<number.length){
            a= Arrays.copyOf(a,a.length*2);
        }
        double result=number[0];
        for (i = 0; i <number.length ; i++) {
            number[i]=a[i];
            if(number[i]>result){
                result=number[i];
            }
        }
        System.out.println("扩容后的数组a的容量是"+a.length);
        System.out.print(a[i]+"");
        System.out.println("\nThe max value is " + result);
    }

}
