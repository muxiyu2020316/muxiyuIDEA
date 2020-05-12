package Suanfa.sort.Quick;

import java.util.Arrays;

/**
 * ����ѭ����������
 * Single ����
 */
public class SingleQuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // �ݹ����������startIndex�����endIndex��ʱ��
        if (startIndex >= endIndex) {
            return;
        }
        // �õ���׼Ԫ��λ��
        int pivotIndex = partitionV2(arr, startIndex, endIndex);
        // ���ݻ�׼Ԫ�أ��ֳ������ֵݹ�����
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

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

    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
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
