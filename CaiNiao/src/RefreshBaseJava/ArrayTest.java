package RefreshBaseJava;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
   static  Scanner input = new Scanner(System.in);
    static int[] num={2,4,9,1,6,7,9,12,63,4,87,54,67,65,4};
    public static void main(String[] args) {
        System.out.println("请输入数组元素个数");
        int n=input.nextInt();
        charToArray();
        System.out.println();
        bubbleAdd();
        System.out.println();
        bubbleDex();
        System.out.println();
        findMax(n);
        double[] myList = new double[n];
        System.out .println(Arrays.toString(reverse(myList)));

    }
    public static void findMax(int n){
        double[] myList = new double[n];
        System.out.println("请输入"+n+"个整数");
        for(int i=0;i<myList.length;i++){
            try {
                if (input.hasNextInt()) {
                    myList[i] = input.nextInt();
                }else{
                    System.out.println("有错误");
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // 查找最大元素
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) max = myList[i];
        }
        System.out.println("The Max is " + max);
        // 打印所有数组元素,foreach循环
        for (double element: myList) {
            System.out.println(element);
        }
    }
    //数组作为函数的返回值
    static int[]reverse(double[] list){
        int []result=new int[list.length];
        for(int i=0,j=result.length-1;i<list.length;i++,j--){
            result[j] = (int) list[i];
        }
        return result;
    }
    static void charToArray(){
        String str="muxiyu i will love you forever";
        //toCharArray 将字符串转换成数组
        char[] data=str.toCharArray();
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + "");
            //转换大小写
            data[x] -= 32;
            System.out.print(data[x] + "");
        }
        System.out.println("/n"+new String(data));
    }
    //冒泡排序递增实现
    static void bubbleAdd(){
        //冒泡
        int totle;
        for(int i=0;i<num.length;i++){
            for(int j=0;j<i;j++){
                if(num[j]>num[i]){
                    totle=num[j];
                    num[j]=num[i];
                    num[i]=totle;
                }
            }
        }
        for (int k : num) {
            System.out.print(k+" ");
        }
    }
    //冒泡排序递减实现
    static void bubbleDex(){
        int totle;
        for(int i=num.length-1;0<=i;i--){
            for(int j=i;0<=j;j--){
                if(num[j]>num[i]){
                    totle=num[j];
                    num[j]=num[i];
                    num[i]=totle;
                }
            }
        }
        for (int k : num) {
            System.out.print(k+" ");
        }
    }
}
