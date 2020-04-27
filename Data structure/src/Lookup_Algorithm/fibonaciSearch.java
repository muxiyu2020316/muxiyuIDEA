package Lookup_Algorithm;
import java.util.ArrayList;
import java.util.List;
/**
 * ����쳲��������еĵ�����ǰ���������ı�ֵ��Խ��Խ�ӽ�0.618
 * ͨ�����ûƽ�����ĸ�����������ѡ����ҵ���в��ң���߲���Ч��
 * 쳲�������������һ����������㷨,Ҫ����������������
 * @author 111
 *
 */
public class fibonaciSearch {
	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
	/** ��쳲�����������nums�����в���key��index

	 *  ���ÿ��Ŷ������������ԭ�����鳤��ΪorginalLength

	 *  Ȼ����쳲��������У���list���ϼ��룬ֱ��>orginalLength,

	 *  쳲��������е����һλF(k),newLength=F(k)-1>=orginalLength

	 *  ��ԭ��������������볤��ΪnewLength�������У� �������λ�������һλ����

	 *  Ȼ���趨begin=0,end=newLength-1,k=�����Ӧ��k

	 * 	mid=begin+F(k-1)-1,����mid��ֵ��key�Ĵ�С

	 * 	�����ͬ������index,���index>=orginalLength,����orginalLength-1

	 * 	���mid<key,��ôbegin=mid+1��k=k-2���mid>key,��ôend=mid-1,k=k-1

	 * 	Ȼ��ѭ����ֱ��end<begin,����-1
	 */
	}
	public static int fibonacciSearch(int[] nums,int key){
		int orginalLength=nums.length;
		//Ȼ����쳲��������У���list���ϼ��룬ֱ��>orginalLength
		List<Integer> fiboList=new ArrayList<>();
		fiboList.add(0);
		fiboList.add(1);
		int i=2;
		while(true){
			Integer now=fiboList.get(i-2)+fiboList.get(i-1);
			fiboList.add(now);
			i++;
			if(now>orginalLength){
				break;
			}
		}
		//쳲��������е����һλF(k),newLength=F(k)-1>=orginalLength
		int k=fiboList.size()-1;
		int newLength=fiboList.get(k)-1;
		//��ԭ��������������볤��ΪnewLength�������У� �������λ�������һλ����
		int[] newNums=new int[newLength];
		for(i=0;i<newLength;i++){
			if(i<orginalLength){
				newNums[i]=nums[i];
			}
			else{
				newNums[i]=nums[orginalLength-1];
			}
		}				
		//begin=0,end=newLength-1,k=�����Ӧ��k
		int begin=0;
		int end=newLength-1;
		//ѭ����ֱ��end<begin,����-1
		while(begin<=end){
			int mid=begin+fiboList.get(k-1)-1;
			int now=nums[mid];
			if(now==key){
				//�����ͬ������index,���index>=orginalLength,����orginalLength-1
				if(mid>=orginalLength){
					return orginalLength-1;
				}
				return mid;
			}
			if(now<key){
				//���mid<key,��ôbegin=mid+1��k=k-2
				begin=mid+1;
				k=k-2;
			}
			if(now>key){
				//���mid>key,��ôend=mid-1,k=k-1
				end=mid-1;
				k=k-1;
			}			
		}				
		return -1;
	}
}
