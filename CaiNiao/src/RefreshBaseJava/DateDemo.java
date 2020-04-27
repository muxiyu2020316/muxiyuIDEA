package RefreshBaseJava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateDemo {
    public static void main(String[] args) {
//        SimpleDateFormat format=new SimpleDateFormat("GG-yyyy-MM-dd  EE a HH:mm:ss:S");
//        String input=args.length==0? "公元-2020-04-13  周一 下午 15:33:34:137":args[0];
//        System.out.println(input+"\n");
//        Date t;
//        try {
//            t=format.parse(input);
//            System.out.print(t);
//        } catch (ParseException e) {
//            System.out.println("Unparseable using " + format);
//        }
//        System.out.println();
        //testPrintf();
        // testDate();
       // testTime();
        testCalendar();
    }
    static void testPrintf(){
        // 初始化 Date 对象
        Date date = new Date();
        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());
        //格式化日期时间
        SimpleDateFormat format=new
                SimpleDateFormat("GG-yyyy-MM-dd  EE a HH:mm:ss:S z");
        System.out.println("当前时间:"+format.format(date));
        //printf格式化日期时间
        System.out.printf("全部的日期时间信息: %tc%n",date);
        System.out.printf("年-月-日格式: %tF%n",date);
        System.out.printf("月/日/年格式：%tD%n",date);
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        System.out.printf("HH:MM格式（24时制）：%tR",date);
        //格式化字符串指出要被格式化的参数的索引
        //索引必须紧跟在%后面，而且必须以$结束
        // 使用toString()显示日期和时间
        System.out.println();
        System.out.printf("%2$tY,%1$s %2$tB %2$td","Due date:", date);
        // 显示格式化时间
        System.out.println();
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
    }
    static void testDate(){
        Date date=new Date();
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);
    }
    static void testTime(){
        try {
            //起始时间
            long start = System.currentTimeMillis( );
            //System.out.println(new Date( ) + "\n");
            Thread.sleep(1000);
            //System.out.println(new Date( ) + "\n");
            //结束时间
            long end = System.currentTimeMillis( );
            //时间差
            long diff = end - start;
            System.out.println("Difference is : " + diff+"ms");
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }
    }
    static void testCalendar(){
        //默认创建的是当前时间
        Calendar c1=Calendar.getInstance();
        //创建一个代表X年X月X日的Calendar对象
        //一共有四中选择适当的参顺配对就可
        c1.set(2020,04,12);
//日期时间的获取
        int year=c1.get(Calendar.YEAR);
//注意日历的月份是从0开始技术的,也就是说,12月,他表示的是11
        int mouth=c1.get(Calendar.MONTH+1);
// 获得日
        int date = c1.get(Calendar.DATE);
// 获得小时
        int hour = c1.get(Calendar.HOUR_OF_DAY);
// 获得分钟
        int minute = c1.get(Calendar.MINUTE);
// 获得秒
        int second = c1.get(Calendar.SECOND);
// 获得星期几（注意（这个与Date类是不同的）：
// 1代表星期日、2代表星期1、3代表星期二，以此类推）
        int day = c1.get(Calendar.DAY_OF_WEEK);
        System.out.println("本地日期时间"+year+"-"+mouth+"-"+date);
        c1.set(Calendar.YEAR,2030);
        System.out.println("日期设为2020的时间"+year+"-"+mouth+"-"+date);
        c1.set(Calendar.DATE,12);
        System.out.println("日期设为20的时间"+year+"-"+mouth+"-"+date);
        c1.add(Calendar.DATE, 20);
        System.out.println("日期加上10的时间"+year+"-"+mouth+"-"+date);
    }
}
