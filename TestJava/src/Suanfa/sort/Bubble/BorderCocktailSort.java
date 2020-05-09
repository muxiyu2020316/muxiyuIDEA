package Suanfa.sort.Bubble;

import java.util.Arrays;

/**
 * ��β������ Cocktail
 * ����ð�����������ð���㷨
 * ��������������Ż�,ȷ������߽�.���ٱȽϴ���
 * ǰ���߽�
 * ����ǰ�߽�
 */
public class BorderCocktailSort {
    //TODO ˫������߽缦β������
    public static void BordercocktailSort(int array[]) {
        int temp;
        boolean isSorted;
        //��ǰ������������������±�index
        int QTHIndex = array.length - 1;
        //�Ӻ���ǰ���������������±�index
        int HTQIndex = 0;
        //�ڱ���ѭ�������һ�ν���Ԫ�ص��±�index������Ϊ����������߽�
        int changeQthIndex = 0;
        int changeHtqIndex = 0;
        for (int i = 0; i < array.length / 2; i++) {
            isSorted = true;
            //�����֣��������ұȽϺͽ���
            for (int j = HTQIndex; j < QTHIndex; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                    //��¼ǰ������һ�ν������±�
                    changeQthIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            //ѭ�������һ�ν���Ԫ��ʱ���±������������߽�
            QTHIndex = changeQthIndex;
            //��ż����֮ǰ����isSorted���±��Ϊtrue
            isSorted = true;
            //ż���֣���������ȽϺͽ���
            for (int k = QTHIndex; k > HTQIndex; k--) {
                if (array[k] < array[k - 1]) {
                    temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                    //�漰Ԫ�ؽ���һ���������
                    isSorted = false;
                    //��¼����ǰ���һ�ν������±�
                    changeHtqIndex = k;
                }
            }
            if (isSorted) {
                break;
            }
            HTQIndex = changeHtqIndex;
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[]{5,8,6,3,9,2,1,7};
        int[] array = new int[200];
        for (int i = 0; i < 200; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startime = System.currentTimeMillis();
        BordercocktailSort(array);
        long endtime = System.currentTimeMillis();
        long TotalTime = endtime - startime;
        System.out.println("�������Ĺ�" + TotalTime + "ms");
        System.out.println(Arrays.toString(array));
    }
}
