package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * 双边循环排序法
 */
public class DoubleQuickSort {
    /**
     * 快速排序的核心
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //递归结束
        while (startIndex >= endIndex) {
            return;
        }
        //获取基准元素
        int pivotIndex = partion(arr, startIndex, endIndex);
        //分别按照基准元素分两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 分治 双边循环
     *
     * @param arr        ,带交换数组
     * @param startIndex ,起始下标
     * @param endIndex   ,结束下标
     * @return
     */
    public static int partion(int[] arr, int startIndex, int endIndex) {
        //选第一个作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //当不止一个元素时
        while (left != right) {
            //先控制right指针左移比较
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //当上面都不满足了left==right
            // 当指针不再移动,交换left和right指向的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //当左右指针重合时,结束比较交换
        arr[startIndex] = arr[right];
        arr[right] = pivot;
        //或者
        //arr[right]=pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
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
