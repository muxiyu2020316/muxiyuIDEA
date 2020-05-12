package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * 三项切分快速排序
 * 适合重复元素较多的排序
 * 时间复杂度 N~NlogN
 */
public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        sort(arr);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * 三项切分快速排序
     * 在lt之前的(lo~lt-1)都小于中间值
     * 在gt之前的(gt+1~hi)都大于中间值
     * 在lt~i-1的都等于中间值
     * 在i~gt的都还不确定（最终i会大于gt，即不确定的将不复存在）
     */
    private static void sort(int arr[], int low, int hight) {
        if (low >= hight) return;
        int v = arr[low], lt = low, i = low + 1, gt = hight;
        while (i <= gt) {
            if (arr[i] < v) swap(arr, i++, lt++);
                //i~gt之间会慢慢缩小
            else if (arr[i] > v) swap(arr, i, gt--);
            else i++;
        }
        //处理小于的部分
        sort(arr, low, lt - 1);
        //处理大于的部分
        sort(arr, gt + 1, hight);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
