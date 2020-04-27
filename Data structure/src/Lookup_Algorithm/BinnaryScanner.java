package Lookup_Algorithm;
import java.util.Arrays;
import java.util.Scanner;
public class BinnaryScanner {
	    public  static void main(String[] args){
	    int[] arr={80, 53, 63, 5, 81, 84, 88, 91, 94};
	    Arrays.sort(arr);
	        System.out.println("查找的值：");
	        int target = new Scanner(System.in).nextInt();
	        int i = binarySearch(arr, target);
	        System.out.println(i);

	    }
		//查找算法
	    private static int binarySearch(int[] arr, int target){
	        /**
	         *  1.定义三个下标变量
	         *  low= 0
	         *  hight =arr.length-1
	         *  mid;
	         *  2.当low<=hight
	         *       3.计算中间位置下标存到变量mid
	         *       4.如果mid位置值比target小
	         *       low定位到mid+1
	         *       5.否则如果mid位置值比target大
	         *       hight定位到mid-1
	         *       6.否则，返回mid下标值
	         * 7.找不到，返回-1，表示找不到
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
