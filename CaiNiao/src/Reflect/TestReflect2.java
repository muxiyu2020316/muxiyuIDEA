package Reflect;

public class TestReflect2 {
    public static  void main(String[] args) {
        teacher t=new teacher(21,"沐汐语");
        //返回一个类
        //Class对象包含所有所属对象体的信息
        Class azz=t.getClass();
        //1.通过类名创建指定类的Class实例
        Class c0=teacher.class;
        //2.通过一个类的实例对象getclass()方法,获取对应实例class实例
        Class c1=t.getClass();
        //3.通过类的金泰方法formateName()获取一个类的Class实例
        //获取Class实例的常用方法
        try {
            //forNmae()里面的参数是要获取的类名的全路径名,包名.类名
            Class c2=Class.forName("Reflect.teacher");
            System.out.println("c2="+c2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //4.几乎不用
        ClassLoader dl = t.getClass().getClassLoader();
        try {
            //dl.loadClass("类的全类名");
            Class clazz4 = dl.loadClass("Reflect.teacher");
            System.out.println("clazz4="+clazz4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("c0="+c0+"\nc1="+c1);
        System.out.println(t.toString());
    }

}
class teacher{
public int age=18;
public String name="沐汐语";

    public teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public teacher() {

    }

    public teacher(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

