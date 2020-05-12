package Suanfa.sort.Quick;

import java.util.Arrays;
import java.util.Stack;

/**
 * 非递归快速排序,基于栈实现
 */
public class DbStackQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        RecrutquickSort(arr, 0, arr.length - 1);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 非递归快速排序.使用一个栈处理
     *
     * @param a
     * @param start
     * @param end
     */
    public static void RecrutquickSort(int a[], int start, int end) {
        if (a == null || a.length <= 0) return;
        //使用集合栈代替递归函数栈
        Stack<Integer> index = new Stack<>();
        // 将整个数列的起,止下标入栈
        index.push(start);
        index.push(end);
        // 循环结束条件：栈为空时
        while (!index.isEmpty()) {
            //栈顶元素出栈得起止下标
            end = index.pop();
            start = index.pop();
            // 得到基准元素位置
            int pivotPos = partition(a, start, end);
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if (start < pivotPos - 1) {
                index.push(start);
                index.push(pivotPos - 1);
            }
            if (end > pivotPos + 1) {
                index.push(pivotPos + 1);
                index.push(end);
            }
        }
    }

    /**
     * 非递归快速排序,通过两个栈实现
     * 一个用于存储,一个用来代替函数递归调用
     *
     * @param a
     * @param start
     * @param end
     */
    public static void noRecrutquickSort(int a[], int start, int end) {
        //设置两个栈，一个用于保存
        if (a == null || a.length < 0) return;
        Stack<Integer> startStack = new Stack<>();//保存当前划分的最高位
        Stack<Integer> endStack = new Stack<>();//保存当前划分的最低位
        // 将整个数列的起,止下标入栈
        startStack.push(start);
        endStack.push(end);
        // 循环结束条件：栈为空时
        while (startStack.isEmpty()) {
            //栈顶元素出栈得起止下标
            start = startStack.pop();
            end = endStack.pop();
            // 得到基准元素位置
            int pivotPos = partition(a, start, end);
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if (start < pivotPos - 1) {
                startStack.push(start);
                endStack.push(pivotPos - 1);
            }
            if (end > pivotPos + 1) {
                startStack.push(pivotPos + 1);
                endStack.push(end);
            }
        }
    }

    public static int partition(int[] a, int start, int end) {
        //分块方法，在数组a中，对下标从start到end的数列进行划分
        int pivot = a[start];
        while (start < end) {
            //把比pivot大的数移动到pivot的右边
            while (start < end && a[end] >= pivot) end--;
            a[start] = a[end];
            //把比pivot(初始的pivot=a[start]小的数移动到pivot的左边
            while (start < end && a[start] <= pivot) start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;//返回划分后的pivot的位置
    }

    /**
     * 分治  单边循环
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
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
                swap(arr[mark], arr[i]);
//                int p = arr[mark];
//                arr[mark] = arr[i];
//                arr[i] = p;
            }
        }
        //当边界位置和基准位置重合了,说明两边都是有序了
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    //交换泛型函数
    public static <T> void swap(T t1, T t2) {
        T p = t1;
        t1 = t2;
        t2 = p;
    }
}
