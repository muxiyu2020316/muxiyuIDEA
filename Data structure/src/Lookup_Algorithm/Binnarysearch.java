package Lookup_Algorithm;
/**
 * ���ֲ���
 */

public class Binnarysearch {

	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
		System.out.println(Binnarysearch(29,arr));
		// Binnarysearch(2,arr);
	}
	public static int  Binnarysearch(int target,int[]arr) {
		int index=-1 ;
		//��¼��ʼλ��
		int begin=0;
		//��¼����λ��
		int end=arr.length-1;
		//��¼�м�λ��
		int middle=(begin+end)/2;
		//ѭ������
		while(true) {
			//�ж��м�λ���ǲ���Ҫ���ҵ�
			if(arr[middle]==target) {
				index = middle;
				break;	
				//����м䲻��Ҫ���ҵ�
			}else{
				//�ж������Ԫ���ǲ��Ǳ��м�ֵ��
				if(arr[middle]>target) {
					//�ѽ�����λ�õ����м�λ�õ�ǰһ��λ��
					end=middle-1;
				}else {
					//�ѽ�����λ�õ����м�λ�õĺ�һ��λ��
					end=middle+1;
				}
				 middle=(begin+end)/2;
		}
			return index;
	}
		return -1;
	}
}
