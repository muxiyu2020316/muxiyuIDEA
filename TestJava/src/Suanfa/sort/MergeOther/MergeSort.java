package Suanfa.sort.MergeOther;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前" + Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
    }

    /**
     * 不断归并引进归并的数组,最后得到排好序的数组
     *
     * @param arr  带排序数组
     * @param low  起始位置
     * @param high 结束位置
     */
    public static void merge(int[] arr, int low, int high) {
        //使用递归的方式进行归并排序，所需要的空间复杂度是O（N+logN）
        int mid = (low + high) / 2;
        if (low < high) {
            //递归地对左右两边进行排序
            merge(arr, low, mid);
            merge(arr, mid + 1, high);
            //合并两个已排好序的数组
            merge(arr, low, mid, high);
        }
    }

    /**
     * merge函数实际上是将两个有序数组合并成一个有序数组
     *
     * @param arr   带排序数组
     * @param low   起始位置
     * @param hight 结束位置
     * @param mid   中间位置
     */
    public static void merge(int[] arr, int low, int mid, int hight) {
        //temp指针用来暂存每次归并的结果,大小会岁归并次数发生变化
        int[] temp = new int[hight - low + 1];
        //左边归并指针
        int left = low;
        //右边归并指针
        int right = mid + 1;
        //归并后数组的指针
        int merge = 0;
        //遍历两个数组，取出小的数字，放入临时数组中
        for (; left <= mid && right <= hight; merge++) {
            if (arr[left] < arr[right])
                temp[merge] = arr[left++];
            else
                temp[merge] = arr[right++];
        }
        //处理多余的数据,比另一边多出来的个数）放到temp数组中
        while (left <= mid)
            temp[merge++] = arr[left++];
        while (right <= hight)
            temp[merge++] = arr[right++];
        //把临时数组中的数据重新存储原数组
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }

}
