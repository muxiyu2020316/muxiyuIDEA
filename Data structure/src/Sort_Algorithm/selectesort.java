package Sort_Algorithm;

import java.util.Arrays;

/**
 * 选择排序
 */
public class selectesort {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		selectesort(arr);
	}
	public static void selectesort(int arr[]) {
		//遍历所有元素
		for(int i=0;i<arr.length;i++) {
            //每一趟循环比较时，min用于存放较小元素的数组下标，
            // 这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换
            int midIndex = i;
            //把当前遍历的数和所有遍历的数依次进行比较，记录最小数的下标
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面比较的数比记录最小的数还要小
                if (arr[midIndex] > arr[j]) {
                    //那么记录最小数
                    midIndex = j;
                }
            }
            //如果当前数和记录最小的数下标不一致，说明下标为midindex的数，比当前遍历的还要小，进行交换
			if(i!=midIndex) {
				int temp=arr[i];
				arr[i]=arr[midIndex];
				arr[midIndex]=temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
