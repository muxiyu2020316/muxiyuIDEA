package Lookup_Algorithm;
/**
 * ���Բ���
 */

public class SequenceSearch {

	public static void main(String[] args) {
		//Ŀ������
			int []arr= {1,4,6,10,2,3,9,19};
			//Ŀ��Ԫ��
			indexSearch(10,arr);
			System.out.println(SequenceSearch(arr,6));
	}
	public static int indexSearch(int target,int arr[]) {
		//Ŀ��Ԫ�������±�
		 int index=0;
		//��������
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				index=i;
				//��ӡĿ��Ԫ���±�
				System.out.println("��"+(i+1)+"���ҵ���:index:"+index);
				break;
			}else{
				System.out.println("��"+(i+1)+"��û���ҵ�");
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
