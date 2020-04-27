package Lookup_Algorithm;
import java.util.ArrayList;
import java.util.List;
/**
 * 随着斐波那契数列的递增，前后两个数的比值会越来越接近0.618
 * 通过运用黄金比例的概念在数列中选择查找点进行查找，提高查找效率
 * 斐波那契查找属于一种有序查找算法,要求数组必须是有序的
 * @author 111
 *
 */
public class fibonaciSearch {
	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
	/** 用斐波那契查找在nums数组中查找key的index

	 *  先用快排对数组进行排序，原先数组长度为orginalLength

	 *  然后建立斐波那契数列，用list不断加入，直到>orginalLength,

	 *  斐波那契数列的最后一位F(k),newLength=F(k)-1>=orginalLength

	 *  将原来排序后的数组加入长度为newLength的数组中， 多出来空位的用最后一位填满

	 *  然后设定begin=0,end=newLength-1,k=上面对应的k

	 * 	mid=begin+F(k-1)-1,查找mid的值与key的大小

	 * 	如果相同，返回index,如果index>=orginalLength,返回orginalLength-1

	 * 	如果mid<key,那么begin=mid+1，k=k-2如果mid>key,那么end=mid-1,k=k-1

	 * 	然后循环，直到end<begin,返回-1
	 */
	}
	public static int fibonacciSearch(int[] nums,int key){
		int orginalLength=nums.length;
		//然后建立斐波那契数列，用list不断加入，直到>orginalLength
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
		//斐波那契数列的最后一位F(k),newLength=F(k)-1>=orginalLength
		int k=fiboList.size()-1;
		int newLength=fiboList.get(k)-1;
		//将原来排序后的数组加入长度为newLength的数组中， 多出来空位的用最后一位填满
		int[] newNums=new int[newLength];
		for(i=0;i<newLength;i++){
			if(i<orginalLength){
				newNums[i]=nums[i];
			}
			else{
				newNums[i]=nums[orginalLength-1];
			}
		}				
		//begin=0,end=newLength-1,k=上面对应的k
		int begin=0;
		int end=newLength-1;
		//循环，直到end<begin,返回-1
		while(begin<=end){
			int mid=begin+fiboList.get(k-1)-1;
			int now=nums[mid];
			if(now==key){
				//如果相同，返回index,如果index>=orginalLength,返回orginalLength-1
				if(mid>=orginalLength){
					return orginalLength-1;
				}
				return mid;
			}
			if(now<key){
				//如果mid<key,那么begin=mid+1，k=k-2
				begin=mid+1;
				k=k-2;
			}
			if(now>key){
				//如果mid>key,那么end=mid-1,k=k-1
				end=mid-1;
				k=k-1;
			}			
		}				
		return -1;
	}
}
