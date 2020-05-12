package Sort_Algorithm;
/**
 * 插入排序
 */
import java.util.Arrays;
public class insertsort {

	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		insertsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void insertsort(int arr[]) {
		//遍历所有数字，注意是从第二个元素开始，
		for(int i=1;i<arr.length;i++) {
			//如果当前数字小于前一个数字
			if(arr[i]<arr[i-1]) {
				//存储当前遍历数字
				int temp=arr[i];
				int j;
				//遍历当前元素前面的元素
				for(j=i-1;j>=0&&temp<=arr[j];j--) {
					//把前一个数字赋值（替换）给后一个数字
					arr[j+1]=arr[j];
				}
				//把临时变量赋值给不满足条件的后一个元素
				arr[j+1]=temp;
			}
		}
	}

}
