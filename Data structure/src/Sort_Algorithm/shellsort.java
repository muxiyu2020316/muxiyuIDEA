package Sort_Algorithm;
/**
 * ϣ������
 */
import java.util.Arrays;
public class shellsort {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		shellsort(arr);
	}
	public static void shellsort(int arr[]) {
		int k = 0;
		//�������в�����ֱ������Ϊ0��ÿ�ζ� d/=2���԰�ݼ�
		for(int d=arr.length/2;d>0;d/=2) {
		//��������Ԫ��
		//��ǰԪ��    ��ǰԪ�ؼ��ϲ������Ԫ��,������Ҫ�Ƚϵ�Ԫ��
			for(int i=d;i<arr.length;i++) {
				//������ǰ�������Ԫ�أ�����Ҫһ�β�������
				for(int j=i-d;j>=0;j-=d) {
					//�����ǰԪ�ش��ڼ��ϲ������Ԫ�أ���ô����
					if(arr[j]>arr[j+d]) {
						int temp=arr[j];
						arr[j]=arr[j+d];
						arr[j+d]=temp;
					}	
				}
			}
			System.out.println("��"+(k+1)+"��������"+Arrays.toString(arr));
			k++;
		}
	}

}
