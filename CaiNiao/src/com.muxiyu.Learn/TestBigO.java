package com.muxiyu.Learn;

public class TestBigO {
    // 全局变量，大小为10的数组array，长度len，下标i。
    static int array[] = new int[10];
    static  int len = 10;
    static int i = 0;
    public static void main(String[] args) {
        add(12);
    }
    static  void add(int element) {
        if (i >= len) { // 数组空间不够了
            // 重新申请一个2倍大小的数组空间
            int new_array[] = new int[len*2];
            // 把原来array数组中的数据依次copy到new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array复制给array，array现在大小就是2倍len了
            array = new_array;
            len = 2 * len;
        }
        // 将element放到下标为i的位置，下标i加一
        array[i] = element;
        ++i;
    }
}
