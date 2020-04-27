package RefreshBaseJava;

import java.io.*;

public class TransientPeople {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        People a = new People("muxiyu",22);
        System.out.println(a);
        //对象输出流
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("d://people.txt"));
        //写入文件(序列化)
        os.writeObject(a);
        os.close();
        //对象输入流
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("d://people.txt"));
        //将文件数据转换为对象（反序列化）
        a = (People)is.readObject();
        // 年龄 数据未定义
        System.out.println(a);
        is.close();
        System.out.println(People.Singleton.getInstance());
    }
}
//定义一个需要序列化的类
class People implements Serializable {
    String name; //姓名
    transient Integer age; //年龄
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名 = "+name+" ,年龄 = "+age;
    }
    //单例模式中采用DCL双锁检测
    static class Singleton{
        private static volatile Singleton instance = null;
        private Singleton() {
        }

        public static Singleton getInstance() {
            if(instance==null) {
                synchronized (Singleton.class) {
                    if(instance==null)
                        instance = new Singleton();
                }
            }
            return instance;
        }
    }

}

