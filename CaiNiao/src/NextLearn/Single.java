package NextLearn;

public class Single {
    /**饿汉式单例模式*/
    //1.构造方法私有化,调用类的人，不能new创建对象
    private Single(){

    }
    //2.私有的Single类型的类变量
    private static Single single=new Single();
    //3.设置公共方法访问本类的实例
    public static Single getInstance(){
        return  single;
    }

    public static void main(String[] args) {
        //无论调用几次getInstance。single都只调用一次
        Single single=Single.getInstance();
    }
}
class Signleton{
    /**懒汉式单例模式*/
    //1.构造器私有化,外部类无法访问本类构造器
    private Signleton(){}
    //先声明类的引用,有时配合static修饰类的引用
    private static Signleton instance=null;
    //3.设置公共方法访问本类的实例
    public static Signleton getInstance(){
        //4.如果类的实例为创建,现创建,返回给调用者需要static修饰,保证得到的是最新的数据
        if (instance==null){
            instance=new Signleton();
        }
        //5.如果有了累的实例,直接返回给调用者
        return instance;
    }
}
