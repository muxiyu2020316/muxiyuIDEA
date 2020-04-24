package HashTable;

import java.util.Arrays;

public class HashTable {
    //哈希表的底层是通过数组实现的,攒在哪一个位置,取决于散列函数
    private StudentInfo[] data=new StudentInfo[100];
    //向散列表添加元素
    public void put(StudentInfo stuInfo){
        //调用散列函数,获取存储位置
        int index=stuInfo.Hashcode(10);
        data[index]=stuInfo;
    }
    public StudentInfo get(StudentInfo stuInfo){
        return data[stuInfo.Hashcode(10)];
    }

    @Override
    public String toString() {
        return "HashTable{" + "data=" + Arrays.toString(data) + '}';
    }
}
