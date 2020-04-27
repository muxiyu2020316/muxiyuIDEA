package Lookup_Algorithm;
import java.util.HashMap;

/**算法思想：
 * 哈希的思路很简单，如果所有的键都是整数，那么就可以使用一个简单的无序数组来实现：
 * 将键作为索引，值即为其对应的值，这样就可以快速访问任意键的值。
 * 这是对于简单的键的情况，我们将其扩展到可以处理更加复杂的类型的键。
 * 算法流程：
  1）用给定的哈希函数构造哈希表；
  2）根据选择的冲突处理方法解决地址冲突；
  3）在哈希表的基础上执行哈希查找
 */
public class hashellSearch {
	public static void main(String[] args) {
		int []arr= {1,2,6,10,12,13,19,29};
		System.out.println(hashSearch(arr,29));
	}
	/** 用哈希查找在arr数组中查找key的index
	 * 先将arr数组的元素，放入hashmap中，key为值，value为index
	 * 然后根据key查找有没有这个值
	 * 但是这种方法，如果nums数组有重复的元素，
	 * 只会返回最后的那个index，因为前面的被覆盖了
	 * @param nums
	 * @param key
	 * @return 如果数组中没有这个key，返回-1
	 * 未知代码
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
