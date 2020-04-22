package com.muxiyu.Learn;

import java.util.Enumeration;
import java.util.Vector;
public class TestEnumeration {
    public static void main(String[] args) {
        Enumeration<String > days;
        Vector<String> dayNames=new Vector<>();
        dayNames.add("星期天/Sunday");
        dayNames.add("星期一/Monday");
        dayNames.add("星期二/Tuesday");
        dayNames.add("星期三/Wednesday");
        dayNames.add("星期四/Thursday");
        dayNames.add("星期五/Friday");
        dayNames.add("星期六/Saturday");
        days=dayNames.elements();
        while(days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }
}
