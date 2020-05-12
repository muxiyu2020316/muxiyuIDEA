package Suanfa.sort.MergeOther;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("����ǰ" + Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println("�����" + Arrays.toString(arr));
    }

    /**
     * ���Ϲ鲢�����鲢������,���õ��ź��������
     *
     * @param arr  ����������
     * @param low  ��ʼλ��
     * @param high ����λ��
     */
    public static void merge(int[] arr, int low, int high) {
        //ʹ�õݹ�ķ�ʽ���й鲢��������Ҫ�Ŀռ临�Ӷ���O��N+logN��
        int mid = (low + high) / 2;
        if (low < high) {
            //�ݹ�ض��������߽�������
            merge(arr, low, mid);
            merge(arr, mid + 1, high);
            //�ϲ��������ź��������
            merge(arr, low, mid, high);
        }
    }

    /**
     * merge����ʵ�����ǽ�������������ϲ���һ����������
     *
     * @param arr   ����������
     * @param low   ��ʼλ��
     * @param hight ����λ��
     * @param mid   �м�λ��
     */
    public static void merge(int[] arr, int low, int mid, int hight) {
        //tempָ�������ݴ�ÿ�ι鲢�Ľ��,��С����鲢���������仯
        int[] temp = new int[hight - low + 1];
        //��߹鲢ָ��
        int left = low;
        //�ұ߹鲢ָ��
        int right = mid + 1;
        //�鲢�������ָ��
        int merge = 0;
        //�����������飬ȡ��С�����֣�������ʱ������
        for (; left <= mid && right <= hight; merge++) {
            if (arr[left] < arr[right])
                temp[merge] = arr[left++];
            else
                temp[merge] = arr[right++];
        }
        //������������,����һ�߶�����ĸ������ŵ�temp������
        while (left <= mid)
            temp[merge++] = arr[left++];
        while (right <= hight)
            temp[merge++] = arr[right++];
        //����ʱ�����е��������´洢ԭ����
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }

}
