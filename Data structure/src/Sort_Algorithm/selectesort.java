package Sort_Algorithm;

import java.util.Arrays;

/**
 * ѡ������
 */
public class selectesort {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		selectesort(arr);
	}
	public static void selectesort(int arr[]) {
		//��������Ԫ��
		for(int i=0;i<arr.length;i++) {
            //ÿһ��ѭ���Ƚ�ʱ��min���ڴ�Ž�СԪ�ص������±꣬
            // ������ǰ���αȽ�������մ�ŵľ��Ǵ�������С��Ԫ�ص��±꣬����ÿ��������СԪ�ض�Ҫ���н���
            int midIndex = i;
            //�ѵ�ǰ�������������б����������ν��бȽϣ���¼��С�����±�
            for (int j = i + 1; j < arr.length; j++) {
                //�������Ƚϵ����ȼ�¼��С������ҪС
                if (arr[midIndex] > arr[j]) {
                    //��ô��¼��С��
                    midIndex = j;
                }
            }
            //�����ǰ���ͼ�¼��С�����±겻һ�£�˵���±�Ϊmidindex�������ȵ�ǰ�����Ļ�ҪС�����н���
			if(i!=midIndex) {
				int temp=arr[i];
				arr[i]=arr[midIndex];
				arr[midIndex]=temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
