package ZiFuChuang;

import java.util.Arrays;

public class ResizeLarge {
    /**
     * �Զ����ݣ�����������
     *
     * @param arr
     * @param value
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
