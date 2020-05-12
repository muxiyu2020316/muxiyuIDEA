package Suanfa.sort.BaseCount;

import java.util.Arrays;

//todo 计数排序
public class countSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = CountSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 实现步骤
     * 1.得到数列最大值max
     * 2.根据最大值确定统计数组长度
     * 3.遍历数组,填充数组
     * 4.遍历统计数组，输出结果
     */
    public static int[] CountSort(int[] array) {
        //1.得到数列最大值max
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        //2.根据最大值确定统计数组长度长度是max+1，
        // 以此来保证数组的最后一个下标是max
        int[] countArray = new int[max + 1];
        System.out.println(max);
        //3.遍历数组,填充数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }

}
