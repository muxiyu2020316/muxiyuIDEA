package com.muxiyu.RefreshBaseJava;

public class MultipleFever {
    public static void main(String[] args) {
     Monkey();
     MultipleFever multipleFever=new MultipleFever();
     multipleFever.RhomBus2();
     multipleFever.TestMut1();
     multipleFever.TestMut2();
    }
    public static void Monkey(){
        /*
         * 一只小猴子一天摘了许多桃子，第一天吃了一半，然后忍不住又吃了一个；
         * 第二天又吃了一半，再加上一个；后面每天都是这样吃。到第10天的时候，
         * 小猴子发现只有一个桃子了。问小猴子第一天共摘了多少个桃子
         */
        int sum1=1;
        int i;
        for(i=9;i>=0;i--){
          sum1=(sum1+1)*2;
        }
        System.out.println("sum1="+sum1);
        // 方法二
        int sum2=1;
        for (int k=1;k<=10;k++){
            sum2=(sum2+1)*2;
        }
        System.out.println("sum2="+sum2);
    }

    public void TestMut1() {
        for (int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print("" + i + j +"  ");
            }
            System.out.println("\n");
        }
        System.out.println("输出完毕！");
    }
    public void TestMut2() {
        lable://标记体的意思
        for (int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if (i*10+j>29){
                    break lable;
                }
                System.out.print("" + i + j +"  ");
            }
            System.out.println("\n");
        }
        System.out.println("输出完毕！");
    }
    public  void RhomBus2() {
/*
         菱形为上下两个等腰三角形（用两个外层for循环分别代表上下两部分）
上部     分为倒直角三角形 + 等腰三角形。外层for以要嵌套两个for循环分别打印出倒直角三角形（直角三角形打印空格）和等腰三角形
下部     分为直角三角形和倒等腰三角形。外层for同样要嵌套两个for循环打印直角三角形（直角三角形打印空格）和倒的等腰三角形
*/
        //定义变量
        int i,j,q;
        //打印菱形的上半部分，左边打印倒直角三角形的空格，右边打印等腰三角形
        for( i = 1;i < 6; i ++) //外循环控制行数，共打印五行
        {
            //左边打印倒直角三角形空格
            for( j = 5; j > i; j--) //与外循环关联，初始值不变，表达式变化，控制打印的列数
            {
                System.out.print(" ");
            }
            //右边等腰三角形
            for( q = 1;q < i*2; q++) //与外循环关联，初始值不变，表达式变化，打印奇数列1，3，5，7，9
            {
                System.out.print("*");
            }
            System.out.println();    //换行
        }
        //打印菱形的下半部分，左边为直角三角形的空格，右边为倒的等腰三角形
        for(i = 1; i < 5; i++) //外循环控制行数，共打印四行
        {
            //左边直角三角形空格
            for(j = 1;j <= i; j++) {    //与外循环关联，初始值不变，表达式变化，共打印五行
                System.out.print(" ");
            }
            //右边倒直角三角形
            for( q = i*2; q < 9 ; q++) {    //与外循环关联，初始值变化，表达式不变，打印奇数列7，5，3，1
                System.out.print("*");
            }
            System.out.println();    //换行
        }
    }

}