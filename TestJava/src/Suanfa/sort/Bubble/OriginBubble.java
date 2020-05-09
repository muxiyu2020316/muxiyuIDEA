package Suanfa.sort.Bubble;

import java.util.Arrays;

//TODO ‘≠ º√∞≈›≈≈–Ú
public class OriginBubble {
    public static void OriBobble(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        OriBobble(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("≈≈–Úœ˚∫ƒπ≤" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
