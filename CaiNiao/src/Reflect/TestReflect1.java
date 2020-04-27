package Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;

public class TestReflect1 {
    public static void main(String[] args) {
        try {
            //forNmae()里面的参数是要获取的类名的全路径名,包名.类名
            Class c1=Class.forName("Reflect.Tutor");
            Class superclass=c1.getSuperclass();
            //因为接口有多个,所以获取的是个数组public Class<?>[] getInterfaces()
            Class interfaces[]=c1.getInterfaces();
            System.out.println("父类:"+superclass.getName());
//            List list=new ArrayList();
//            Iterator iterator=list.iterator();
            //getConstructors()构造器数组,getModifiers()取得方法的修饰符,返回1,代表public
            Constructor []cons= c1.getConstructors();
            //遍历构造器数组foreach,接口数组foreach
            for (Constructor o:cons) {
                System.out.println("接口:"+o.getName());
                System.out.println("构造器:"+o.getName()+"的修饰符是:"
                        +o.getModifiers());
            }
            //getDeclaredConstructors()构造器数组,getModifiers()取得方法的修饰符,返回2,代表所有类型
            Constructor []con=c1.getDeclaredConstructors();
            for (Constructor o:con) {
                System.out.println("接口:"+o.getName());
                System.out.println("构造器:"+o.getName()+"的修饰符是:"
                        +o.getModifiers());
                //获取参数类型.返回Class数组
                System.out.println("------");

                TypeVariable[] parem=c1.getTypeParameters();
                for ( TypeVariable t:parem) {
                    System.out.println("构造器:"+t.getName()+"的参数类型:"+t.getName());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class Tutor extends teacher implements Study,Move{
    private String sex;
    private String message;
    protected int Score;
    public Tutor(String school) {
        this.school = school;
        System.out.println("调用public Tutor(String school)");
    }
    private Tutor(String school,int age) {
        super(age);
        this.school = school;
        System.out.println("调用public Tutor(String school)");
    }

    String school;
    public Tutor(){
        super();
        System.out.println("调用public Tutor()");
    }
    public Tutor(int age, String name,String sex) {
        super(age, name);
        this.sex=sex;
        System.out.println("调用public Tutor(int age, String name,String sex)");
    }

    private Tutor(int age) {
        super(age);
        System.out.println("调用private Tutor(int age)");
    }
    private void test(String s){
        System.out.println("私有方法调用 private void test(String s)"+s);
    }
    public String getSchool(String s){
        System.out.println("调用public String getSchool(String s)");
    return s;
    }


    public void showInfo(int age){
        System.out.println("啦啦啦啦啦,我"+age+"岁了");
    }
    @Override
    public void StudyType() {
        System.out.println("学习使我快乐,我爱网课,王珂爱我!");
    }

    @Override
    public void MoveType() {
        System.out.println("上课开飞机");
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
interface Move{
    void MoveType();
}
interface Study{
    void StudyType();
}