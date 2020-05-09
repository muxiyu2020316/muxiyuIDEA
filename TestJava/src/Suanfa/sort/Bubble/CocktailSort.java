package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * 鸡尾酒排序 Cocktail
 * 基于冒泡排序的最优冒泡算法
 */
public class CocktailSort {
    public static void cocktailSort(int array[]) {
        int temp = 0;
        int i = 0;
        //有序标记，每一轮的初始值都是true
        boolean isSorted = true;
        for (; i < array.length / 2; i++) {
            //奇数轮，从左向右比较和交换
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("第" + i + "轮排序,数组已经有序");
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        cocktailSort(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
