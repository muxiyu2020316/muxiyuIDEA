package Sort_Algorithm;
/**
 * 快速排序
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
		//只有在star<end的前提下才能使用，否则会栈溢出
		if(star<end) {
		//需要一个基准数key,用最开始的数字开始，那个开始那个就为初始
		int key=arr[star];
		//计入需要排序的下标
		int low=star;
		int high=end;
		//循环找比标准书大的数，比标准数晓得数
		
		while(low<high) {
			//右边的数字比标准数大,下标往前移动
			while(low<high&&key<=arr[high]) {
				high--;
			}
			//使用右边的数字替换左边的数字
			arr[low]=arr[high];
			//左边的数字比标准数小,下标往前移动
			while(low<high&&arr[low]<=key) {
				low++;
			}
			//使用左边数替换右边的
			arr[high]=arr[low];
		}
		 
		//把标准数赋值给高位元素
		arr[low]=key;
		//递归排序
		//处理所有小的数字
		quicksort(arr,star,low);
		//处理所有大的数字
		quicksort(arr,low+1,end);
	}
	}

}
