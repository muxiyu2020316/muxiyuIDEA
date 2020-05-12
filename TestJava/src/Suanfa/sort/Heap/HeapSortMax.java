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
        //���������鹹�����С��
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            downAdjust(array, i, array.length);
        }
        //�������������
        System.out.println(Arrays.toString(array));
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for (int i = array.length - 1; i > 0; i--) {
            // ���һ��Ԫ�غ͵�һԪ�ؽ��н���
            swap(array, i, 0);
            // �³���������
            downAdjust(array, 0, i);
        }
    }

    /**
     * ��data���뵽�������
     */
    public static void insert(int data) {

        int[] newArr = new int[arr.length + 1];
        //ԭ�����Ԫ�ظ��Ƶ�������
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = data;
        arr = newArr;
        // ���ϵ�����
        upAdjust(arr);
    }

    /**
     * ����Ԫ��
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
     * �ϸ�����
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //temp ����Ҷ�ӽڵ�ֵ,��������滻
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //���ý���ֵ.ֱ�ӵ��ֵ����
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * ��С���³�
     *
     * @param array       �������Ķ�
     * @param parentIndex Ҫ�³��ĸ��ڵ�
     * @param length      �ѵ���Ч��С
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp ���游�ڵ�,�������ĸ�ֵ
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //��������ӽڵ�,�Һ��Ӵ�������.��λ�Һ���
            if (childIndex + 1 < length && (array[childIndex + 1] > array[childIndex]))
                childIndex++;
            //�������ڵ�����κ�һ���ӽڵ�ֵ,����.
            if (temp >= array[childIndex])
                break;
            //����λ��,����exchage.ֻ�赥�ֵ
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
}
