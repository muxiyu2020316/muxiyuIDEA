package Suanfa.Heap;

import java.util.Arrays;

/**
 * ����ѻ���ҵ���ʵ��
 * �ϵ�,�³�,������
 * ͨ������˳��洢,��Ȼ��������ȫ������
 */
public class MaxBinaryHeap {
    /**
     * �����ϸ�
     * �ϸ�����,�������ӽڵ������.
     *
     * @param array, �������Ķ�
     */
    public static void upAdjust(int[] array) {
        //���һ���ڵ��±�
        int childIndex = array.length - 1;
        //���һ���ڵ�ĸ��ڵ��±�
        int parentIndex = (childIndex - 1) / 2;
        //temp ��ʳ��������Ҷ�ӽڵ�ֵ,���������ֵ
        int temp = array[childIndex];
        //�����ӽڵ�,�����һ���ڵ㲻�Ǹ��ڵ�ʱ
        while (childIndex > 0 && temp > parentIndex) {
            //����λ��,����exchage.ֻ�赥�ֵ
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            //�ص���һ���ڵ�ĸ��ڵ�,�������ڽڵ�ĸ��ڵ�
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * �����³�
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
            //��������ӽڵ�,�Һ���С������.��λ�Һ���
            if (childIndex + 1 < length && (array[childIndex + 1] > array[childIndex])) {
                childIndex++;
            }
            //�������ڵ�С���κ�һ���ӽڵ�ֵ,����.
            if (temp >= array[childIndex])
                break;
            //����λ��,����exchage.ֻ�赥�ֵ
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * ���ѹ�����
     *
     * @param array �������Ķ�
     */
    public static void buildHeap(int[] array) {
        // �����һ����Ҷ�ӽڵ㿪ʼ�����������³�������
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
