package Suanfa.Heap;

import java.util.Arrays;

/**
 * 二叉堆基本业务的实现
 * 上调,下沉,构建堆
 * 通过数组顺序存储,虽然本身是完全二叉树
 */
public class MaxBinaryHeap {
    /**
     * 最大堆上浮
     * 上浮调整,交换父子节点的数据.
     *
     * @param array, 待调整的堆
     */
    public static void upAdjust(int[] array) {
        //最后一个节点下标
        int childIndex = array.length - 1;
        //最后一个节点的父节点下标
        int parentIndex = (childIndex - 1) / 2;
        //temp 零食保存插入的叶子节点值,最后用来赋值
        int temp = array[childIndex];
        //当有子节点,且最后一个节点不是根节点时
        while (childIndex > 0 && temp > parentIndex) {
            //交换位置,无需exchage.只需单项赋值
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            //回到上一个节点的父节点,就是现在节点的父节点
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 最大堆下沉
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
            //如果有右子节点,右孩子小于左孩子.定位右孩子
            if (childIndex + 1 < length && (array[childIndex + 1] > array[childIndex])) {
                childIndex++;
            }
            //若果父节点小于任何一个子节点值,跳出.
            if (temp >= array[childIndex])
                break;
            //交换位置,无需exchage.只需单项赋值
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 最大堆构建堆
     *
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做“下沉”调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
