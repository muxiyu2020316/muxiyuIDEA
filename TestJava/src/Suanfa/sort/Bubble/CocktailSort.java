package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * ��β������ Cocktail
 * ����ð�����������ð���㷨
 */
public class CocktailSort {
    public static void cocktailSort(int array[]) {
        int temp = 0;
        int i = 0;
        //�����ǣ�ÿһ�ֵĳ�ʼֵ����true
        boolean isSorted = true;
        for (; i < array.length / 2; i++) {
            //�����֣��������ұȽϺͽ���
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //��ż����֮ǰ����isSorted���±��Ϊtrue
            isSorted = true;
            //ż���֣���������ȽϺͽ���
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("��" + i + "������,�����Ѿ�����");
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        cocktailSort(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
