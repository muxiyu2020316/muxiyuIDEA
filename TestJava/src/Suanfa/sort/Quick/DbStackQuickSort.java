package Suanfa.sort.Quick;

import java.util.Arrays;
import java.util.Stack;

/**
 * �ǵݹ��������,����ջʵ��
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
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * �ǵݹ��������.ʹ��һ��ջ����
     *
     * @param a
     * @param start
     * @param end
     */
    public static void RecrutquickSort(int a[], int start, int end) {
        if (a == null || a.length <= 0) return;
        //ʹ�ü���ջ����ݹ麯��ջ
        Stack<Integer> index = new Stack<>();
        // ���������е���,ֹ�±���ջ
        index.push(start);
        index.push(end);
        // ѭ������������ջΪ��ʱ
        while (!index.isEmpty()) {
            //ջ��Ԫ�س�ջ����ֹ�±�
            end = index.pop();
            start = index.pop();
            // �õ���׼Ԫ��λ��
            int pivotPos = partition(a, start, end);
            // ���ݻ�׼Ԫ�طֳ�������, ��ÿһ���ֵ���ֹ�±���ջ
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
     * �ǵݹ��������,ͨ������ջʵ��
     * һ�����ڴ洢,һ���������溯���ݹ����
     *
     * @param a
     * @param start
     * @param end
     */
    public static void noRecrutquickSort(int a[], int start, int end) {
        //��������ջ��һ�����ڱ���
        if (a == null || a.length < 0) return;
        Stack<Integer> startStack = new Stack<>();//���浱ǰ���ֵ����λ
        Stack<Integer> endStack = new Stack<>();//���浱ǰ���ֵ����λ
        // ���������е���,ֹ�±���ջ
        startStack.push(start);
        endStack.push(end);
        // ѭ������������ջΪ��ʱ
        while (startStack.isEmpty()) {
            //ջ��Ԫ�س�ջ����ֹ�±�
            start = startStack.pop();
            end = endStack.pop();
            // �õ���׼Ԫ��λ��
            int pivotPos = partition(a, start, end);
            // ���ݻ�׼Ԫ�طֳ�������, ��ÿһ���ֵ���ֹ�±���ջ
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
        //�ֿ鷽����������a�У����±��start��end�����н��л���
        int pivot = a[start];
        while (start < end) {
            //�ѱ�pivot������ƶ���pivot���ұ�
            while (start < end && a[end] >= pivot) end--;
            a[start] = a[end];
            //�ѱ�pivot(��ʼ��pivot=a[start]С�����ƶ���pivot�����
            while (start < end && a[start] <= pivot) start++;
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;//���ػ��ֺ��pivot��λ��
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
                swap(arr[mark], arr[i]);
//                int p = arr[mark];
//                arr[mark] = arr[i];
//                arr[i] = p;
            }
        }
        //���߽�λ�úͻ�׼λ���غ���,˵�����߶���������
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    //�������ͺ���
    public static <T> void swap(T t1, T t2) {
        T p = t1;
        t1 = t2;
        t2 = p;
    }
}
