package Array_List_Way;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestArray {
    static Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5,9};
    static String[] people = { "mxiyu","jiangxiaobai","tongliya"};
    static int[] array = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4,2 };
    static int[] a = { 2,2,11,};
    static ArrayList<String> objArray = new ArrayList<String>();
    static ArrayList<String> objArray2 = new ArrayList<String>();
    public static void main(String[] args) {
    //TestSortSearch(array,3,"����������Ϊ");
        showPreAftArray(array);
        CollectionMinMax();
        ConnectArrays(numbers,people);
        FindRepetetion(a);
        FindNoRepetetion(a);
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");
        objArray.add(0,"common1");
        objArray.add(1,"common2");
        TestContain(objArray,objArray2);
    }
    public static void TestContain(ArrayList objArray1,ArrayList objArray2) {
        //��������
        System.out.println("objArray2 ������Ԫ�أ�" + objArray1);
        System.out.println("objArray2 ������Ԫ�أ�" + objArray2);
        System.out.println("objArray �Ƿ�����ַ���common2? �� "
                + objArray1.contains("common2"));
        System.out.println("objArray2 �Ƿ�������� objArray? ��"
                + objArray2.contains(objArray1));
    }
    public static void ConnectArrays(Object[] a, Object[] b){
        //��������
        Object[] c ;
        List list=new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        c=list.toArray();
        System.out.println(Arrays.toString(c));
    }
    public static void FindRepetetion(int[] a){
        //�����ظ�Ԫ��
        int count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count += 1;
                }
            }
            if (count == 1)
                System.out.println("�ظ�Ԫ�� : " + a[i]);
            count = 0;//��0,���¼���
        }
    }
    public static void FindNoRepetetion(int [] a) {
        int count=0;
        for(int j=0;j<a.length;j++) {
            for (int k = 0; k < a.length; k++) {  //int k =j+1;k<a.length;k++�ĳ� int k=0;k<a.length;k++
                if (a[j] == a[k]) {
                    count++;
                }
            }
            if(count==1)
                System.out.println("���ظ�Ԫ�� : " + a[j]);
            count = 0;
        }
    }
    public static void CollectionMinMax() {
        //��ȡ�����Сָ
        int min = (int) Collections.min(Arrays.asList(numbers));
        int max = (int) Collections.max(Arrays.asList(numbers));
        System.out.println("��Сֵ: " + min);
        System.out.println("���ֵ: " + max);
    }
    public static void showPreAftArray(int array[]) {
        //���鷭ת
        System.out.println("��תǰ����: " + Arrays.toString(array));
        System.out.println("��ת������: " + Arrays.toString(reserve(array)));
    }
    public static int[] reserve( int[] arr ){
        //���鷭ת,�Զ��巽��
        int[] arr1 = new int[arr.length];
        for( int x=0;x<arr.length;x++ ){
            arr1[x] = arr[arr.length-x-1];
        }
        return arr1 ;
    }
    public static void TestSortSearch(int array[],int i,String message){
        //��������Ͳ���
        Arrays.sort(array);
        printArray(message,array);
        Arrays.binarySearch(array,i);
        int index = Arrays.binarySearch(array, i);
        System.out.println("���ֲ���:Ԫ��" + i + "�ڵ� " + index + " ��λ��");

    }
    private static void printArray(String message, int array[]) {
        //�Զ���������Ϣ��ӡ
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(",");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
