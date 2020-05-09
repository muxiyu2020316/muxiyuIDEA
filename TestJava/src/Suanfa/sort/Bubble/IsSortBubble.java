package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * 冒泡排序改进版
 * 判断目前时候已近有序,有序就结束排序
 */
public class IsSortBubble {
    //TODO 有序冒泡排序
    public static void ProBobble(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            //先进性有标记,每一轮初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                System.out.println("第" + i + "轮排序,数组已经有序");
                break;
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
        ProBobble(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
