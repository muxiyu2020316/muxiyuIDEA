package Suanfa.sort.BaseCount;

import java.util.Arrays;

//todo 计数排序优化
public class countSortPro {
    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = CountSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 优化后的实现步骤
     * //1.得到数列的最大值和最小值，并算出差值d
     * //2.创建统计数组并统计对应元素的对应元素个数
     * //3.统计数组做变形，后面的元素等于前面的元素之和
     * //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
     */
    public static int[] CountSort(int[] array) {
        //1.得到数列最大值max和最小值的差值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        // 以此来保证数组的最后一个下标是max
        int d = max - min;
        int[] countArray = new int[d + 1];
        //2.创建统计数组并统计对应元素的个数
        for (int i = 0; i < array.length; i++) {
            //90-99;95的下标就是5/ 95-min
            countArray[array[i] - min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            //对之前的元素进行累计
            countArray[i] += countArray[i - 1];
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            //95第一次遇到.给countArray下标是5的元素值减1，从4变成3，代表下次再遇到
            //95分的成绩时，最终排名是第3
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortArray;
    }
}
