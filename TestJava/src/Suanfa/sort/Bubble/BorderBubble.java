package Suanfa.sort.Bubble;

import java.util.Arrays;

public class BorderBubble {
    //TODO 优化冒泡排序,无序边界
    public static void BorderBubble(int array[]) {
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界,比较只需到此为止,后面的都是有序的
        //初始是 ,默认全部无序
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //先进性有标记,每一轮初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //涉及元素交换一定是无序的
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            //更新无序边界位置
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                System.out.println("第" + i + "轮排序,数组已经有序");
                break;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Java计时函数currentTimeMills()
         */
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        long startime = System.currentTimeMillis();
        BorderBubble(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
