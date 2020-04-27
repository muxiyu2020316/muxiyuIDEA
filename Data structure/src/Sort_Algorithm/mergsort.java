package Sort_Algorithm;
/**
 * �鲢����
 */
import java.util.Arrays;

public class mergsort {

	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		mergsort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergsort(int[]arr,int low,int high) {
		int middle=(low+high)/2;
		if(low<high) {
		//�������
		mergsort(arr,low,middle);
		//�����ұ�
		mergsort(arr,middle+1,high);
		//�鲢����
		merge(arr,low,middle,high);
		}
	}
	public static void merge(int arr[],int low,int middle,int high) {
		//���ڴ洢�鲢�����ʱ����
		int temp[]=new int[high-low+1];
		//��¼��һ����������Ҫ�������±�
		int i=low;
		//��¼�ڶ�����������Ҫ�������±�
		int j=middle+1;
		//��¼��ʱ�����ŵ��±�
		int index=0;
		//�����������飬ȡ��С�����֣�������ʱ������
		while(i<=middle&&j<=high) {
			//��һ�������С
			if(arr[i]<=arr[j]) {
				//��С�����ݷ�����ʱ������
				temp[index]=arr[i];
				//���±����һλ
				i++;
			}else {
				temp[index]=arr[j];
				j++;
			}
			index++;
		}
		//������������
		while(j<=high) {
			temp[index]=arr[j];
			j++;
			index++;
		}
		while(i<=middle) {
			temp[index]=arr[i];
			i++;
			index++;
		}
		
		//����ʱ�����е��������´洢ԭ����
		for(int k=0;k<=temp.length-1;k++) {
			arr[k+low]=temp[k];
		}
	}

}
