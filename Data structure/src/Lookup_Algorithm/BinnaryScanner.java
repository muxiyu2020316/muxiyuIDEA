package Lookup_Algorithm;
import java.util.Arrays;
import java.util.Scanner;
public class BinnaryScanner {
	    public  static void main(String[] args){
	    int[] arr={80, 53, 63, 5, 81, 84, 88, 91, 94};
	    Arrays.sort(arr);
	        System.out.println("���ҵ�ֵ��");
	        int target = new Scanner(System.in).nextInt();
	        int i = binarySearch(arr, target);
	        System.out.println(i);

	    }
		//�����㷨
	    private static int binarySearch(int[] arr, int target){
	        /**
	         *  1.���������±����
	         *  low= 0
	         *  hight =arr.length-1
	         *  mid;
	         *  2.��low<=hight
	         *       3.�����м�λ���±�浽����mid
	         *       4.���midλ��ֵ��targetС
	         *       low��λ��mid+1
	         *       5.�������midλ��ֵ��target��
	         *       hight��λ��mid-1
	         *       6.���򣬷���mid�±�ֵ
	         * 7.�Ҳ���������-1����ʾ�Ҳ���
	         */
	        int low = 0,mid,hight= arr.length-1;
	        while (low<=hight){
	            mid=(low+hight)/2;
	            if(arr[mid]<target){
	                low=mid+1;
	            }else if (arr[mid]>target){
	                hight=mid-1;
	            }else {
	                return mid;
	            }
	        }
	        return -1;
	    }


}
