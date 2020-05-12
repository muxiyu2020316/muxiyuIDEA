package Suanfa.sort.MergeOther;

import java.util.Arrays;

/**
 * 优化归并排序，可以使用迭代代替递归
 * 非递归实现归并排序
 * 前往后从最小的序列开始归并，直到完成
 * 边界条件 需要注意
 */
public class MergeSortPro {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("排序前" + Arrays.toString(arr));
        merge(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }

    //使用非递归的方式来实现归并排序
    public static void merge(int arr[]) {
        int len = arr.length;
        int k = 1;
        while (k < len) {
            merge(arr, k, len);
            k *= 2;
        }
    }

    //负责将数组中的相邻的有k个元素的字序列进行归并
    public static void merge(int arr[], int k, int n) {
        int i = 0;
        //从前往后.将2个长度为k的数列合并
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }
        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来
        if (i < n - k)
            merge(arr, i, i + k - 1, n - 1);
    }

    //将两个有序数组合并成一个有序数组
    public static void merge(int[] arr, int low, int mid, int high) {
        //temp指针用来暂存每次归并的结果,大小会岁归并次数发生变化
        int[] temp = new int[high - low + 1];
        //左边归并指针
        int left = low;
        //右边归并指针
        int right = mid + 1;
        //归并后数组的指针
        int hb = 0;
        //遍历两个数组，取出小的数字，放入临时数组中
        for (; left <= mid && right <= high; hb++) {
            if (arr[left] < arr[right])
                temp[hb] = arr[left++];
            else
                temp[hb] = arr[right++];
        }
        //处理多余的数据,比另一边多出来的个数）放到temp数组中
        while (left <= mid)
            temp[hb++] = arr[left++];
        while (right <= high)
            temp[hb++] = arr[right++];
        //把临时数组中的数据重新存储原数组
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }
}
