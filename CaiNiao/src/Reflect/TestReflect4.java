package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflect4 {
    public static void main(String[] args) {
        //无论是反射调用那个方法,都是调用Object对象的方法.也就是说,invoke(object,"沐汐语");
        //参数第一个只能是object.
        try {
            Class c1 = Class.forName("Reflect.Tutor");
            //获取无参构造
            Constructor con=c1.getConstructor();
            //使用午餐构造创建对象
            Object object=con.newInstance();
            //获取指定名字方法得到名称getShool,类型String的方法
            Method m=c1.getMethod("getSchool",String.class);
            //参数1,需要实例化的对象,后参数,调用当前方法的实际参数
            m.invoke(object,"沐汐语");
            //调用私有方法
            Method m1=c1.getDeclaredMethod("test",String.class);
            //解除占用,解除封装,对私有方法直接调用
            m1.setAccessible(true);
            m1.invoke(object,"考试100分");
            //调用重载方法
            Method m2=c1.getMethod("showInfo",int.class);
            m2.invoke(object,12);
            //调用有返回值的方法....

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
