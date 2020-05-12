package Suanfa.sort.MergeOther;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 10, 2, 3, 9, 19};
        System.out.println(Arrays.toString(arr));
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertsort(int[] arr) {
        //从第二个元素开始,第一个元素默认有序
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //遍历当前元素前面的元素
            while (j > 0 && arr[j] < arr[j - 1]) {
                //把前一个数字赋值（替换）给后一个数字
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
