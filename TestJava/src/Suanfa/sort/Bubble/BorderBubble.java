package Suanfa.sort.Bubble;

import java.util.Arrays;

public class BorderBubble {
    //TODO �Ż�ð������,����߽�
    public static void BorderBubble(int array[]) {
        //��¼���һ�ν�����λ��
        int lastExchangeIndex = 0;
        //�������еı߽�,�Ƚ�ֻ�赽��Ϊֹ,����Ķ��������
        //��ʼ�� ,Ĭ��ȫ������
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            //�Ƚ����б��,ÿһ�ֳ�ʼֵ����true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                    // ����Ϊ���һ�ν���Ԫ�ص�λ��
                    lastExchangeIndex = j;
                }
            }
            //��������߽�λ��
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                System.out.println("��" + i + "������,�����Ѿ�����");
                break;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Java��ʱ����currentTimeMills()
         */
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        long startime = System.currentTimeMillis();
        BorderBubble(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
