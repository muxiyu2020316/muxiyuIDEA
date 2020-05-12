package Suanfa.sort.Quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * �ǵݹ��������,����ջʵ��
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
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ��������������QuickSort��ʵ��
     * ��ԭ���ĵݹ�ʵ��ת����һ��ջ��ʵ�֣�
     * ��ջ�д洢ÿһ�η������õĲ���
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //ʹ�ü���ջ����ݹ麯��ջ
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // �������е���,ֹ�±꣬�Թ�ϣ����ʽ��ջ
        Map rootparam = new HashMap();
        rootparam.put("startIndex", startIndex);
        rootparam.put("endIndex", endIndex);
        quickSortStack.push(rootparam);
        // ѭ������������ջΪ��ʱ
        while (!quickSortStack.isEmpty()) {
            //ջ��Ԫ�س�ջ����ֹ�±�
            Map<String, Integer> param = quickSortStack.pop();
            // �õ���׼Ԫ��λ��
            int pivotIndex = partion(arr, param.get("startIndex"), param.get("endIndex"));
            // ���ݻ�׼Ԫ�طֳ�������, ��ÿһ���ֵ���ֹ�±���ջ
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
     * ���� ˫��ѭ��
     *
     * @param arr        ,����������
     * @param startIndex ,��ʼ�±�
     * @param endIndex   ,�����±�
     * @return
     */
    public static int partion(int[] arr, int startIndex, int endIndex) {
        //ѡ��һ��Խ����Ϊ��׼Ԫ��
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //����ֹһ��Ԫ��ʱ
        while (left != right) {
            //�ȿ���rightָ�����ƱȽ�
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //����leftָ��Ƚϲ�����
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //�����涼��������left==right
            // ��ָ�벻���ƶ�,����left��rightָ���Ԫ��
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //������ָ���غ�ʱ,�����ȽϽ���
        arr[startIndex] = arr[right];
        arr[right] = pivot;
        //����
        //arr[right]=pivot;
        return left;
    }

    /**
     * ����  ����ѭ��
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        // ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ�أ�Ҳ����ѡ�����λ�ã�
        int pivot = arr[startIndex];
        //�߽�λ��Ҳ�Ǵӵ�һ��Ԫ�ؿ�ʼ
        int mark = startIndex;
        //�ӻ�׼Ԫ�ص���һ��Ԫ�ؿ�ʼ����,����Ҫ�����ٽ�����,�˴���<=
        for (int i = startIndex + 1; i <= endIndex; i++) {
            //��С�ڻ�׼Ԫ��ʱ
            if (arr[i] < pivot) {
                //��������Ԫ��С�ڻ�׼Ԫ��.markָ������1λ
                mark++;
                //�߽�λ�ú������±�������Ԫ�غ�markָ������λ�õ�Ԫ�ؽ���λ�ã�
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //���߽�λ�úͻ�׼λ���غ���,˵�����߶���������
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
