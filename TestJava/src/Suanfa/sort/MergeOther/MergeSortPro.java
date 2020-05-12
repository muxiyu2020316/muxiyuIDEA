package Suanfa.sort.MergeOther;

import java.util.Arrays;

/**
 * �Ż��鲢���򣬿���ʹ�õ�������ݹ�
 * �ǵݹ�ʵ�ֹ鲢����
 * ǰ�������С�����п�ʼ�鲢��ֱ�����
 * �߽����� ��Ҫע��
 */
public class MergeSortPro {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("����ǰ" + Arrays.toString(arr));
        merge(arr);
        System.out.println("�����" + Arrays.toString(arr));
    }

    //ʹ�÷ǵݹ�ķ�ʽ��ʵ�ֹ鲢����
    public static void merge(int arr[]) {
        int len = arr.length;
        int k = 1;
        while (k < len) {
            merge(arr, k, len);
            k *= 2;
        }
    }

    //���������е����ڵ���k��Ԫ�ص������н��й鲢
    public static void merge(int arr[], int k, int n) {
        int i = 0;
        //��ǰ����.��2������Ϊk�����кϲ�
        while (i < n - 2 * k + 1) {
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }
        //��δ��뱣֤�ˣ�����Щ���䵥�ġ����Ȳ�������merge�Ĳ��ֺ�ǰ��merge����
        if (i < n - k)
            merge(arr, i, i + k - 1, n - 1);
    }

    //��������������ϲ���һ����������
    public static void merge(int[] arr, int low, int mid, int high) {
        //tempָ�������ݴ�ÿ�ι鲢�Ľ��,��С����鲢���������仯
        int[] temp = new int[high - low + 1];
        //��߹鲢ָ��
        int left = low;
        //�ұ߹鲢ָ��
        int right = mid + 1;
        //�鲢�������ָ��
        int hb = 0;
        //�����������飬ȡ��С�����֣�������ʱ������
        for (; left <= mid && right <= high; hb++) {
            if (arr[left] < arr[right])
                temp[hb] = arr[left++];
            else
                temp[hb] = arr[right++];
        }
        //������������,����һ�߶�����ĸ������ŵ�temp������
        while (left <= mid)
            temp[hb++] = arr[left++];
        while (right <= high)
            temp[hb++] = arr[right++];
        //����ʱ�����е��������´洢ԭ����
        for (int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }
}
