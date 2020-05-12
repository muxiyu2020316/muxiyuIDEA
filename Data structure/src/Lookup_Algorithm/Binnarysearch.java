package Lookup_Algorithm;
/**
 * 二分查找
 */

public class Binnarysearch {

	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
		System.out.println(Binnarysearch(29,arr));
		// Binnarysearch(2,arr);
	}
	public static int  Binnarysearch(int target,int[]arr) {
		int index=-1 ;
		//记录开始位置
		int begin=0;
		//记录结束位置
		int end=arr.length-1;
		//记录中间位置
		int middle=(begin+end)/2;
		//循环查找
		while(true) {
			//判断中间位置是不是要查找的
			if(arr[middle]==target) {
				index = middle;
				break;	
				//如果中间不是要查找的
			}else{
				//判断在这个元素是不是比中间值大
				if(arr[middle]>target) {
					//把结束的位置调到中间位置的前一个位置
					end=middle-1;
				}else {
					//把结束的位置调到中间位置的后一个位置
					end=middle+1;
				}
				 middle=(begin+end)/2;
		}
			return index;
	}
		return -1;
	}
}
