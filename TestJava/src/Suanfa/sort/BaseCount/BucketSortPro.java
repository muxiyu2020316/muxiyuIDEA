package Suanfa.sort.BaseCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSortPro {
    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12};
        System.out.println(Arrays.toString(array));
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static double[] bucketSort(double[] array) {
        //1.�õ��������ֵmax����Сֵ�Ĳ�ֵ
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        double d = max - min;
        System.out.println("max=" + max + "\tmin=" + min + "\tbuck=" + d);
        //2.��ʼ��Ͱ,��������ԭʼ����Ĵ�С
        int bucketNum = array.length;
        //��һ����������ʼ��ͬbucket
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //3.����ԭʼ���飬��ÿ��Ԫ�ط���Ͱ��
        double border = (max - min) / (bucketNum - 1);
        for (double v : array) {
            //������ = �����ֵ-��Сֵ��/ ��Ͱ������ - 1��
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            System.out.println("num=" + num);
            bucketList.get(num).add(v);
            System.out.println(bucketList.get(num));
        }
        System.out.println("������" + border);
        /**4.��ÿ��Ͱ�ڲ���������*/
        for (LinkedList<Double> doubles : bucketList) {
            //JDK �ײ�����˹鲢�����鲢���Ż��汾
            Collections.sort(doubles);
        }
        //�鿴ͬ˳��
        System.out.println(bucketList);
        //5.���ȫ��Ԫ��
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }
}
