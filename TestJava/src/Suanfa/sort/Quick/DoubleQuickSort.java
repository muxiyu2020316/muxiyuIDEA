package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * ˫��ѭ������
 */
public class DoubleQuickSort {
    /**
     * ��������ĺ���
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //�ݹ����
        while (startIndex >= endIndex) {
            return;
        }
        //��ȡ��׼Ԫ��
        int pivotIndex = partion(arr, startIndex, endIndex);
        //�ֱ��ջ�׼Ԫ�ط������ֵݹ�����
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
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
        //ѡ��һ����Ϊ��׼Ԫ��
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

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");

        System.out.println(Arrays.toString(arr));
    }
}
