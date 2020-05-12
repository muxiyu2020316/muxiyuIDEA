package Suanfa.sort.MergeOther;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 10, 2, 3, 9, 19};
        System.out.println(Arrays.toString(arr));
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertsort(int[] arr) {
        //�ӵڶ���Ԫ�ؿ�ʼ,��һ��Ԫ��Ĭ������
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //������ǰԪ��ǰ���Ԫ��
            while (j > 0 && arr[j] < arr[j - 1]) {
                //��ǰһ�����ָ�ֵ���滻������һ������
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
