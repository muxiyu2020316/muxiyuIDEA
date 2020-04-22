package ZiFuChuang;

import java.util.StringTokenizer;

public class TestChar {
    static String[] temp;
    //字符串比较函数compareTo
    public static void TestCompareTo(){
        String str="muxiyu";
        String anotherString="Ruxiyu";
        Object obj=str;
      System.out.println( str.compareTo(anotherString) );
        //忽略大小写
      System.out.println( str.compareToIgnoreCase(anotherString) );
      System.out.println( str.compareTo(obj.toString()));
       }
//查找字符串最后一次出现的位置
     public static void TestLastIndexOf(){
        String str="刘yu飞mu育xi";
        int lastindex=str.lastIndexOf("x");
        if(lastindex==-1)
            System.out.println("找不到");
        else
            System.out.println("查找字符位置:"+lastindex);
       }
    //删除字符串中的一个字符
    // 通过字符串函数 substring() 函数来删除字符串中的一个字符
    public static String TestRemoveCharAt(String s, int pos){
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    //字符串替换 使用 java String 类的 replace 方法来替换字符串中的字符
    public static String TestReplace(String a,String old,String fresh){
        return a.replace(old,fresh );
    }
    //字符串反转 reverse() 将字符串反转
    public static String TestRevese(String pre){
        return  new StringBuilder(pre).reverse().toString();
    }
    //字符串分割 ,使用了 split(string)方法,将字符串分割为数组
    public static void TestSplit(String str,String delimeter,String temp[]){
        temp = str.split(delimeter); // 分割字符串
        for(String x :  temp){
            System.out.println(x);
            System.out.print("");
        }
    }
    //字符串分隔(StringTokenizer)
    //StringTokennizer 设置不同分隔符来分隔字符串，
    // 默认的分隔符是：空格、制表符（\t）、换行符(\n）、回车符（\r）
    public static void TestStringTokennizer(String str,String delimeter ){
        StringTokenizer st=new StringTokenizer(str,delimeter);
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
    /*
    * first_str, second_str要比较的两字符串
    * astart,将 first_str 字符串从第11个字符开始和
    * bstart,second_str 字符串的第12个字符开始注意比较
    * DouBle,一共比较多少对
    * Check,是否忽略大小写
    */
    public static void  TestRegionMatch(String first_str, String second_str, int astart, int bstart, int DouBle, String Check){
        boolean match;
        if (Check.equals("忽略")){
            match =first_str.regionMatches(true,astart,second_str,bstart,DouBle);
            System.out.println("不区分大小写返回值：" + match);
        }else{
        match =first_str.regionMatches(astart,second_str,bstart,DouBle);
            System.out.println("区分大小写返回值：" + match);
        }
    }
    public static void main(String[] args) {
        //TestCompareTo();
        //TestLastIndexOf();
        String str = "this is Java";
        String string="https:www.muxiyu";
        String strings1="Welcome to Microsoft";
        String strings2="I work with microsoft";
        System.out.println(TestRemoveCharAt(str, 5));
        System.out.println(TestReplace(str,"ava","c++"));
        System.out.println("字符串反转前:"+str);
        System.out.println("字符串反转后:"+TestRevese(str));
        TestSplit(string,"//.",temp);// 指定分割字符， . 号需要转义
        TestStringTokennizer(string,".");
        TestRegionMatch(strings1,strings2,11,12,9,"");
    }

}
