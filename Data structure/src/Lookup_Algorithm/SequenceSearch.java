package Lookup_Algorithm;
/**
 * 线性查找
 */

public class SequenceSearch {

	public static void main(String[] args) {
		//目标数组
			int []arr= {1,4,6,10,2,3,9,19};
			//目标元素
			indexSearch(10,arr);
			System.out.println(SequenceSearch(arr,6));
	}
	public static int indexSearch(int target,int arr[]) {
		//目标元素所在下标
		 int index=0;
		//遍历数组
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				index=i;
				//打印目标元素下标
				System.out.println("第"+(i+1)+"次找到了:index:"+index);
				break;
			}else{
				System.out.println("第"+(i+1)+"次没有找到");
			}
			
		}
		return index;
		
	}
	public static int SequenceSearch(int arr[], int value) {
        for(int i=1;i<arr.length-1;i++) {
            if(arr[i]==value) {
                return i;
            }
        }
        return -1;
    }
}
