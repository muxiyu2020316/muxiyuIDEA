package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * 鸡尾酒排序 Cocktail
 * 基于冒泡排序的最优冒泡算法
 * 针对有序区进行优化,确认无需边界.减少比较次数
 * 前向后边界
 * 后向前边界
 */
public class BorderCocktailSort {
    //TODO 双重无序边界鸡尾酒排序
    public static void BordercocktailSort(int array[]) {
        int temp;
        boolean isSorted;
        //从前往后遍历的有序无序下标index
        int QTHIndex = array.length - 1;
        //从后往前遍历的有序无序下标index
        int HTQIndex = 0;
        //在遍历循环中最后一次交换元素的下标index即可认为是有序无序边界
        int changeQthIndex = 0;
        int changeHtqIndex = 0;
        for (int i = 0; i < array.length / 2; i++) {
            isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = HTQIndex; j < QTHIndex; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                    //记录前向后最后一次交换的下标
                    changeQthIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            //循环中最后一次交换元素时的下标就是有序无序边界
            QTHIndex = changeQthIndex;
            //在偶数轮之前，将isSorted重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int k = QTHIndex; k > HTQIndex; k--) {
                if (array[k] < array[k - 1]) {
                    temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                    //记录后向前最后一次交换的下标
                    changeHtqIndex = k;
                }
            }
            if (isSorted) {
                break;
            }
            HTQIndex = changeHtqIndex;
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        BordercocktailSort(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
