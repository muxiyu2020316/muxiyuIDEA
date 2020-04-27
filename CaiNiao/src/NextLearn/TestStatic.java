package NextLearn;

import RefreshBaseJava.TransientPeople;

public class TestStatic {
    String name="张三";
    static int age;
    public TestStatic() {
        System.out.println("执行构造方法");
    }
    //非静态代码块
    {
        System.out.println("执行非静态代码块");
    }
    //静态代码块
    static{
        age=18;
        System.out.println("执行静态代码块"+age);
    }
    public void test(){
        age=18;
        System.out.println("执行静态代码块"+age+1);
    }

    public static void main(String[] args) {
        TestStatic tst=new TestStatic();
        TestStatic tst1=new TestStatic();
        //匿名内部类
        TestStatic tst2=new TestStatic(){
            //需要静态代码块初始化数据,应为没有构造器,无法访问
            //用代码块代替构造方法
            {
                super.name="沐汐语";
            }
            public void test(){
                System.out.println("执行代码块--->"+name);
            }
        };
        tst2.test();
    }
}
