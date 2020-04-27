package RefreshBaseJava;

import java.util.ArrayList;
import java.util.List;

public class TestGenericity {
//泛型数组
    public static void main(String[] args) {
        //创建不同类型的数组测试
        Integer[] intArray = { 12, 32, 23,44, 51};
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        String[] StringArray={"沐汐语","江小白","彤离","燕兰","可爱多","软软冰"};
        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组
        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组
        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
        System.out.println( "\n字符串型数组元素为:" );
        printArray( StringArray ); // 传递一个字符型数组
        System.out.printf("%d,%d和%d的最大值是:%d\n",3,5,8,maximum(3,5,8));
        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n",6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );
        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear","apple", "orange", maximum( "pear", "apple", "orange" ) );
        System.out.println("测试通配符");
        List<String> name=new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        name.add("沐汐语");
        age.add(22);
        number.add(2324);
//获取集合中的数据
        getData(name);
        getData(age);
        getData(number);


    }
    //泛型方法
    public static <E> void printArray(E[] Array){
    // 输出数组元素
        for (E element:Array) {
            System.out.print(element+" ");
        }
        System.out.println(" ");
    }
    public static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T max=x;
        if(y.compareTo(max)>0){
            max=y;
        }
        if(z.compareTo(max)>0){
            max=z;
        }
        return max;
    }
    public static void getData(List<?> data){
        System.out.println("data :" + data.get(0));
    }
}
