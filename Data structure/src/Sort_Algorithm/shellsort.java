package Sort_Algorithm;
/**
 * 希尔排序
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
		//遍历所有步长，直到增量为0；每次都 d/=2；对半递减
		for(int d=arr.length/2;d>0;d/=2) {
		//遍历所有元素
		//当前元素    当前元素加上步长后的元素,就是需要比较的元素
			for(int i=d;i<arr.length;i++) {
				//遍历当前组的所有元素，都需要一次插入排序
				for(int j=i-d;j>=0;j-=d) {
					//如果当前元素大于加上步长后的元素，那么交换
					if(arr[j]>arr[j+d]) {
						int temp=arr[j];
						arr[j]=arr[j+d];
						arr[j+d]=temp;
					}	
				}
			}
			System.out.println("第"+(k+1)+"次排序结果"+Arrays.toString(arr));
			k++;
		}
	}

}
