package Suanfa.sort.BaseCount;

import java.util.Arrays;

//todo ��������
public class countSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = CountSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * ʵ�ֲ���
     * 1.�õ��������ֵmax
     * 2.�������ֵȷ��ͳ�����鳤��
     * 3.��������,�������
     * 4.����ͳ�����飬������
     */
    public static int[] CountSort(int[] array) {
        //1.�õ��������ֵmax
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        //2.�������ֵȷ��ͳ�����鳤�ȳ�����max+1��
        // �Դ�����֤��������һ���±���max
        int[] countArray = new int[max + 1];
        System.out.println(max);
        //3.��������,�������
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        //4.����ͳ�����飬������
        int index = 0;
        int[] sortArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }

}
