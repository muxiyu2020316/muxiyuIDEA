package RefreshBaseJava;

import java.util.Arrays;
import java.util.Scanner;

public class TestHasNextInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int A[] = new int[10];
        int max, min;

        for (int i = 0; i < 10; i++) {
            System.out.print("请输入一个整数");
            try {
                if (input.hasNextInt()) {
                    A[i] = input.nextInt();
                }else{
                    System.out.println("有错误");
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        min = max = A[0];
        for (int i = 0; i < A.length; i++) {
            for (int j =i; j <A.length - 1 ; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
            if (A[i] >=max)
                max = A[i];
            if (A[i] < min)
                min = A[i];
        }
        System.out.println("最大值是:" + max);
        System.out.println(Arrays.toString(A));
    }
}
