package Sort_Algorithm;
/**
 * ��������
 */
import java.util.Arrays;
public class insertsort {

	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		insertsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void insertsort(int arr[]) {
		//�����������֣�ע���Ǵӵڶ���Ԫ�ؿ�ʼ��
		for(int i=1;i<arr.length;i++) {
			//�����ǰ����С��ǰһ������
			if(arr[i]<arr[i-1]) {
				//�洢��ǰ��������
				int temp=arr[i];
				int j;
				//������ǰԪ��ǰ���Ԫ��
				for(j=i-1;j>=0&&temp<=arr[j];j--) {
					//��ǰһ�����ָ�ֵ���滻������һ������
					arr[j+1]=arr[j];
				}
				//����ʱ������ֵ�������������ĺ�һ��Ԫ��
				arr[j+1]=temp;
			}
		}
	}

}
