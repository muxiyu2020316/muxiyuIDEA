package Reflect;

import java.lang.reflect.Field;

public class TestReflect3 {
    //通过反射创建对象
    public static void main(String[] args) {
        try {
            Class<Tutor> c2= (Class<Tutor>) Class.forName("Reflect.Tutor");
            //通过反射的构造方法创建对象
//            Object o1=c2.newInstance();
//            //强制类型转换
//            Tutor t1=(Tutor)o1;
            //调用无参公有构造方法
//            Tutor t2= c2.newInstance();
//            System.out.println(t2);
//            //调用有参构造方法
//            //指定获取一个参数为String类型的公有构造方法
//            Constructor<Tutor> t1=c2.getConstructor(String.class);
//            Tutor t3= t1.newInstance("彤离");
//            System.out.println(t1);
//            t3.showInfo();
//            //通过反射机制强制调用私有的构造方法
//            //指定获取有两个参数的构造方法.
//            Constructor<Tutor> t4=c2.getDeclaredConstructor(int.class,String.class,String.class);
//            //解除封装,对私有方法直接调用
//            t4.setAccessible(true);
//            Tutor t5= t4.newInstance(22,"江小白","男");
//            System.out.println(t5);
            //获取类的所有公有方法
//             Method[]ms=c2.getMethods();
//            for (Method s:ms) {
//                System.out.println("方法名:" + s.getName() + "修饰符:" + s.getModifiers()
//                        + "返回值类型" + s.getReturnType());
//                System.out.println("-------");
//                Class[] cs = s.getParameterTypes();
//                if (cs != null && cs.length > 0) {
//                    for (Class c : cs) {
//                        System.out.println("参数类型"+c.getName());
//                    }
//                }
//            }
            //获取类的所有的方法
//            Method[]msd=c2.getDeclaredMethods();
//            for (Method s:msd) {
//                System.out.println("方法名:" + s.getName() + "修饰符:" + s.getModifiers()
//                        + "返回值类型" + s.getReturnType());
//                Class[] cs = s.getParameterTypes();
//                if (cs != null && cs.length > 0) {
//                    for (Class c : cs) {
//                        System.out.println("参数类型"+c.getName());
//                    }
//                }
//                System.out.println("-------");
//            }
            //获取类的共有属性.包含父类的属性
//         Field[]f1=c2.getFields();
            //获取所有的属性,但是不包含父类的属性
           Field[]f1=c2.getDeclaredFields();
            for (Field f:f1) {
               System.out.println("修饰符"+f.getModifiers());
               System.out.println("属性类型"+f.getType());
               System.out.println("Field的名称"+f.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
