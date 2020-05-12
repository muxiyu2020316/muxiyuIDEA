package Suanfa.sort.BaseCount;

import java.util.Arrays;

//todo ���������Ż�
public class countSortPro {
    public static void main(String[] args) {
        int[] array = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int[] sortedArray = CountSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * �Ż����ʵ�ֲ���
     * //1.�õ����е����ֵ����Сֵ���������ֵd
     * //2.����ͳ�����鲢ͳ�ƶ�ӦԪ�صĶ�ӦԪ�ظ���
     * //3.ͳ�����������Σ������Ԫ�ص���ǰ���Ԫ��֮��
     * //4.�������ԭʼ���У���ͳ�������ҵ���ȷλ�ã�������������
     */
    public static int[] CountSort(int[] array) {
        //1.�õ��������ֵmax����Сֵ�Ĳ�ֵ
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        // �Դ�����֤��������һ���±���max
        int d = max - min;
        int[] countArray = new int[d + 1];
        //2.����ͳ�����鲢ͳ�ƶ�ӦԪ�صĸ���
        for (int i = 0; i < array.length; i++) {
            //90-99;95���±����5/ 95-min
            countArray[array[i] - min]++;
        }
        //3.ͳ�����������Σ������Ԫ�ص���ǰ���Ԫ��֮��
        for (int i = 1; i < countArray.length; i++) {
            //��֮ǰ��Ԫ�ؽ����ۼ�
            countArray[i] += countArray[i - 1];
        }
        //4.�������ԭʼ���У���ͳ�������ҵ���ȷλ�ã�������������
        int[] sortArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            //95��һ������.��countArray�±���5��Ԫ��ֵ��1����4���3�������´�������
            //95�ֵĳɼ�ʱ�����������ǵ�3
            sortArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortArray;
    }
}
