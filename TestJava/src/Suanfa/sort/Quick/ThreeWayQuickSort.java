package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * �����зֿ�������
 * �ʺ��ظ�Ԫ�ؽ϶������
 * ʱ�临�Ӷ� N~NlogN
 */
public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        sort(arr);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * �����зֿ�������
     * ��lt֮ǰ��(lo~lt-1)��С���м�ֵ
     * ��gt֮ǰ��(gt+1~hi)�������м�ֵ
     * ��lt~i-1�Ķ������м�ֵ
     * ��i~gt�Ķ�����ȷ��������i�����gt������ȷ���Ľ��������ڣ�
     */
    private static void sort(int arr[], int low, int hight) {
        if (low >= hight) return;
        int v = arr[low], lt = low, i = low + 1, gt = hight;
        while (i <= gt) {
            if (arr[i] < v) swap(arr, i++, lt++);
                //i~gt֮���������С
            else if (arr[i] > v) swap(arr, i, gt--);
            else i++;
        }
        //����С�ڵĲ���
        sort(arr, low, lt - 1);
        //������ڵĲ���
        sort(arr, gt + 1, hight);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
