package ZiFuChuang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestDateFormate {
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        Date date = new Date();
        String strDateFormat = "G YYYY-MM-dd HH:mm:ss:ms";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));
        // 输出已经格式化的现在时间（24小时制）
        System.out.println("现在时间：" + sdf.format(date));
        FromBirthtoAge("1999年3月18日","YYYY年MM月DD日");
        FromCalendartoYM();
        TimeMillisToTime("yyyy年MM月dd日");
        TimeMillisToTime("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
    }
    public static void  TimeMillisToTime(String strDateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        //获取当前时间戳
        Long timeStamp=System.currentTimeMillis();
        System.out.println("请选择转换时间戳的方式:" +
                "\n1.sd = sdf.format(Long.parseLong(String.valueOf(timeStamp)));"+
                "\n2.sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));"+
                "\n3.sdf.format(timeStamp);"
        );
        int choose=input.nextInt();
        String sd=null;
        switch (choose){

            case 1:
                 sd= sdf.format(Long.parseLong(String.valueOf(timeStamp)));
                break;
            case 2:
                 sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
            break;
                 case 3:
                sd = sdf.format(timeStamp);
                break;
        }
        System.out.println("格式化结果：" + sd);
    }
    public static void FromBirthtoAge(String birthday,String strDateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            Date date1=sdf.parse(birthday);
            //获得时间毫秒值
            long myTime = date1.getTime();
            //当前日期毫秒值
            long currentTime = new Date().getTime();
            System.out.println((currentTime-myTime)/1000/60/60/24/365);
        } catch (ParseException e) {
            System.out.println("日期格式有误,亲,重新输入!");
        }
    }
    public static void FromCalendartoYM(){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        //月份从0开始记
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        //从周日作为一周的第一天
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一周的第几天: " + dow);
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);

    }

}
