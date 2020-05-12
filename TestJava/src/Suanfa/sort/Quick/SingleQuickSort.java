package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * 单边循环快速排序
 * Single 单列
 */
public class SingleQuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partitionV2(arr, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        //边界位置也是从第一个元素开始
        int mark = startIndex;
        //从基准元素的下一个元素开始便利,所以要考虑临界问题,此处是<=
        for (int i = startIndex + 1; i <= endIndex; i++) {
            //当小于基准元素时
            if (arr[i] < pivot) {
                //遍历到的元素小于基准元素.mark指针右移1位
                mark++;
                //边界位置后移最新遍历到的元素和mark指针所在位置的元素交换位置，
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //当边界位置和基准位置重合了,说明两边都是有序了
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }
}
