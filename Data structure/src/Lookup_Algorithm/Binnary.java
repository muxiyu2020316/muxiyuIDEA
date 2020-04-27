package Lookup_Algorithm;
import java.util.Arrays;
public class Binnary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1,4,6,10,2,3,9,19};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Binnary(9,arr));
	}
    public static int Binnary(int target,int arr[]) {
    	int low=0;
    	int end=arr.length-1;
    	int mid;
    	while(low<=end) {
    		mid=(low+end)/2;
            if(arr[mid]<target){
                low=mid+1;
            }else if (arr[mid]>target){
                end=mid-1;
            }else {
                return mid;
            }
    	}
    	return -1;
    }
}
