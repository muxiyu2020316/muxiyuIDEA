package Suanfa.sort.Heap;

import java.util.Arrays;

public class HeapSortMax {
    static int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        insert(12);
        heapSortMax(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heapSortMax(int[] array) {
        //把无序数组构造成最小堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            downAdjust(array, i, array.length);
        }
        //输出构造后的最大堆
        System.out.println(Arrays.toString(array));
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            swap(array, i, 0);
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    /**
     * 将data插入到二叉堆中
     */
    public static void insert(int data) {

        int[] newArr = new int[arr.length + 1];
        //原数组的元素复制到新数组
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = data;
        arr = newArr;
        // 向上调整堆
        upAdjust(arr);
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 上浮调整
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp 保存叶子节点值,最后用来替换
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //不用交换值.直接单项赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 最小堆下沉
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp 保存父节点,用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右子节点,右孩子大于左孩子.定位右孩子
            if (childIndex + 1 < length && (array[childIndex + 1] > array[childIndex]))
                childIndex++;
            //若果父节点大于任何一个子节点值,跳出.
            if (temp >= array[childIndex])
                break;
            //交换位置,无需exchage.只需单项赋值
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
}
