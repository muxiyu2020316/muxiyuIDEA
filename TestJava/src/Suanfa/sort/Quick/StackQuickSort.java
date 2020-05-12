package Suanfa.sort.Quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 非递归快速排序,基于栈实现
 */
public class StackQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("排序消耗共" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 真正的区别在于QuickSort的实现
     * 把原本的递归实现转化成一个栈的实现，
     * 在栈中存储每一次方法调用的参数
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //使用集合栈代替递归函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起,止下标，以哈希的形式入栈
        Map rootparam = new HashMap();
        rootparam.put("startIndex", startIndex);
        rootparam.put("endIndex", endIndex);
        quickSortStack.push(rootparam);
        // 循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()) {
            //栈顶元素出栈得起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partion(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (param.get("endIndex") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
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
        //选第一个越苏作为基准元素
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
}
