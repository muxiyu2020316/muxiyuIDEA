package Sort_Algorithm;
/**
 * ��������
 */

import java.util.Arrays;

public class quicksort {

	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		//System.out.println(Arrays.toString(arr));
		quicksort(arr, 0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		int []arr1= {1,42,6,102,2,3,91,19};
		quicksort(arr1, 0,arr1.length-1);
		System.out.println(Arrays.toString(arr1));
	}
	public static void quicksort(int arr[],int star,int end) {
		//ֻ����star<end��ǰ���²���ʹ�ã������ջ���
		if(star<end) {
		//��Ҫһ����׼��key,���ʼ�����ֿ�ʼ���Ǹ���ʼ�Ǹ���Ϊ��ʼ
		int key=arr[star];
		//������Ҫ������±�
		int low=star;
		int high=end;
		//ѭ���ұȱ�׼���������ȱ�׼��������
		
		while(low<high) {
			//�ұߵ����ֱȱ�׼����,�±���ǰ�ƶ�
			while(low<high&&key<=arr[high]) {
				high--;
			}
			//ʹ���ұߵ������滻��ߵ�����
			arr[low]=arr[high];
			//��ߵ����ֱȱ�׼��С,�±���ǰ�ƶ�
			while(low<high&&arr[low]<=key) {
				low++;
			}
			//ʹ��������滻�ұߵ�
			arr[high]=arr[low];
		}
		 
		//�ѱ�׼����ֵ����λԪ��
		arr[low]=key;
		//�ݹ�����
		//��������С������
		quicksort(arr,star,low);
		//�������д������
		quicksort(arr,low+1,end);
	}
	}

}
