package Lookup_Algorithm;
import java.util.HashMap;

/**�㷨˼�룺
 * ��ϣ��˼·�ܼ򵥣�������еļ�������������ô�Ϳ���ʹ��һ���򵥵�����������ʵ�֣�
 * ������Ϊ������ֵ��Ϊ���Ӧ��ֵ�������Ϳ��Կ��ٷ����������ֵ��
 * ���Ƕ��ڼ򵥵ļ�����������ǽ�����չ�����Դ�����Ӹ��ӵ����͵ļ���
 * �㷨���̣�
  1���ø����Ĺ�ϣ���������ϣ��
  2������ѡ��ĳ�ͻ�����������ַ��ͻ��
  3���ڹ�ϣ��Ļ�����ִ�й�ϣ����
 */
public class hashellSearch {
	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
		System.out.println(hashSearch(arr,29));
	}
	/** �ù�ϣ������arr�����в���key��index
	 * �Ƚ�arr�����Ԫ�أ�����hashmap�У�keyΪֵ��valueΪindex
	 * Ȼ�����key������û�����ֵ
	 * �������ַ��������nums�������ظ���Ԫ�أ�
	 * ֻ�᷵�������Ǹ�index����Ϊǰ��ı�������
	 * @param nums
	 * @param key
	 * @return ���������û�����key������-1
	 * δ֪����
	 * HashMap<Integer, Integer> map=new HashMap<>();
	 */
	public static int hashSearch(int[] arr,int key){
		int length=arr.length;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<length;i++){
			map.put(arr[i], i);
		}
		Integer index=map.get(key);
		if(index==null){
			index=-1;
		}				
		return index;
	}

}
