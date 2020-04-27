package Lookup_Algorithm;
/**
 * ��ֵ�����ʺϴ��ȷ��λ��ǰ������������ԴӼ���֮�����������
 * �ʺ���һ��Ŀ�ĵĲ���
 * �������Ͷ��ֲ��Ҵ�������
 */
import java.util.Arrays;

public class insertSearch {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
	System.out.println(Arrays.toString(arr));
	//���� �з���ֵ�ĺ���ֻ�ܲ�ȡ�����佫���������
	System.out.println(insertSearch(arr,19));
	}
	/**
	 * �ò�ֵ���Ҳ�����nums�����в���key��index	 
	 * ���ÿ��Ŷ������������Ȼ���趨begin=0,end=length-1	
	 * mid=begin+(key-nums[begin])/(nums[end]-nums[begin])*(end-begin),����mid��ֵ��key�Ĵ�С	
	 * �����ͬ������index	 * 	
	 * ���mid<key,��ôbegin=mid+1�����mid>key,��ôend=mid-1	
	 * Ȼ��ѭ����ֱ��end<begin,����-1
	 * @param arrayҪ���ҵ�����
	 * @param key Ҫ���ҵ�ֵ���ؼ���
	 * @return ���ز��ҵ��������±�
	 * left  ���
	 * right �յ�
	 * middle= left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
	 * ����������1/2�Ľ�Ϊ����Ӧ�ģ����ݹؼ����������������������λ�ã���midֵ�ı仯�������ؼ���key
	 */
	public static int insertSearch(int[] arr, int key) {
	    return search(arr, key, 0, arr.length - 1);
	}
	private static int search(int[] arr, int key, int left, int right) {
		//ֻ�е�left<right��������ܽ���
	    while (left <= right) {
	    	//�������м�ֵ�����
	        if (arr[right] == arr[left]) {
	        	//���������Ҫ���ҵ������򷵻��±�
	            if (arr[right] == key)
	                return right;
	            //���򷵻�-1����ʾû���ҵ�
	            else 
	            	return -1;
	        }
	        int middle ;
	        middle= left + ((key - arr[left]) / (arr[right] - arr[left])) * (right - left);
	        if (arr[middle] == key) {
	            return middle;
	        }
	        if (key < arr[middle]) {
	        	//ǰ�ã�����Ѱ��
	            right = middle - 1; 
	        } else {
	        	//ǰ�ã�����Ѱ��
	            left = middle + 1;
	        }
	    }
	    return -1;
	}

}
