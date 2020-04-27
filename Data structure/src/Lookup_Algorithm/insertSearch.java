package Lookup_Algorithm;
/**
 * 插值查找适合大概确定位于前或后的情况，可以从几分之几的情况进行
 * 适合有一定目的的查找
 * 整体代码和二分查找代码类似
 */
import java.util.Arrays;

public class insertSearch {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
	System.out.println(Arrays.toString(arr));
	//对于 有返回值的函数只能采取输出语句将其内容输出
	System.out.println(insertSearch(arr,19));
	}
	/**
	 * 用插值查找查找在nums数组中查找key的index	 
	 * 先用快排对数组进行排序，然后设定begin=0,end=length-1	
	 * mid=begin+(key-nums[begin])/(nums[end]-nums[begin])*(end-begin),查找mid的值与key的大小	
	 * 如果相同，返回index	 * 	
	 * 如果mid<key,那么begin=mid+1，如果mid>key,那么end=mid-1	
	 * 然后循环，直到end<begin,返回-1
	 * @param array要查找的数组
	 * @param key 要查找的值，关键字
	 * @return 返回查找到的数的下标
	 * left  起点
	 * right 终点
	 * middle= left + ((key - array[left]) / (array[right] - array[left])) * (right - left);
	 * 将比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字key
	 */
	public static int insertSearch(int[] arr, int key) {
	    return search(arr, key, 0, arr.length - 1);
	}
	private static int search(int[] arr, int key, int left, int right) {
		//只有当left<right是排序才能进行
	    while (left <= right) {
	    	//正好是中间值的情况
	        if (arr[right] == arr[left]) {
	        	//如果正好是要查找的数，则返回下标
	            if (arr[right] == key)
	                return right;
	            //否则返回-1，表示没有找到
	            else 
	            	return -1;
	        }
	        int middle ;
	        middle= left + ((key - arr[left]) / (arr[right] - arr[left])) * (right - left);
	        if (arr[middle] == key) {
	            return middle;
	        }
	        if (key < arr[middle]) {
	        	//前置，继续寻找
	            right = middle - 1; 
	        } else {
	        	//前置，继续寻找
	            left = middle + 1;
	        }
	    }
	    return -1;
	}

}
