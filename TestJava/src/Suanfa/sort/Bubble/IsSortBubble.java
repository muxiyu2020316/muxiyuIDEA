package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * ð������Ľ���
 * �ж�Ŀǰʱ���ѽ�����,����ͽ�������
 */
public class IsSortBubble {
    //TODO ����ð������
    public static void ProBobble(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            //�Ƚ����б��,ÿһ�ֳ�ʼֵ����true
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                }
            }
            if (isSorted) {
                System.out.println("��" + i + "������,�����Ѿ�����");
                break;
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        ProBobble(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
