package com.muxiyu.RefreshBaseJava;

import java.io.Console;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestScanner {
    public static void main(String[] args) {
// 从键盘接收数据
//            int i = 0;
//            float f = 0.0f;
//            System.out.print("输入整数：");
//            if (scan.hasNextInt()) {
//                // 判断输入的是否是整数
//                i = scan.nextInt();
//                // 接收整数
//                System.out.println("整数数据：" + i);
//            } else {
//                f = scan.nextFloat();
//                scan.nextLine();  // 没接收到整数，把其他类型收掉，否则会影响到后边接受小数的逻辑
//                // 输入错误的信息
//                System.out.println("输入的不是整数！是" + f);
//            }
        Scanner scan = new Scanner(System.in);
        System.out.println("输入数据：");
        StringTokenizer stringTokenizer=new StringTokenizer(scan.nextLine());
        System.out.println("分隔后：");
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
//    Console console=System.console();
//    String username=console.readLine("User name: ");
//    char[] passwd = console.readPassword("Password: ");

}
