package Sort_Algorithm;
/**
 * ц╟ещеепР
 */
import java.util.Arrays;

public class bubblesort {
	public static void main(String[] args) {
		int []arr= {1,4,6,10,2,3,9,19};
		System.out.println(Arrays.toString(arr));
		 bubblesort(arr);
	}
	public static void bubblesort(int arr[]) {
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
