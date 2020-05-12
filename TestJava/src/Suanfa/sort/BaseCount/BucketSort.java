package Suanfa.sort.BaseCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static double[] bucketSort(double[] array) {
        //1.得到数列最大值max和最小值的差值
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
        //2.初始化桶,数量等于原始数组的大小
        int bucketNum = array.length;
        //用一个集合来初始化同bucket
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //3.遍历原始数组，将每个元素放入桶中
        for (double v : array) {
            //放入对应的区间筒
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }
        //4.对每个桶内部进行排序
        for (LinkedList<Double> doubles : bucketList) {
            //JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(doubles);
        }
        //5.输出全部元素
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
