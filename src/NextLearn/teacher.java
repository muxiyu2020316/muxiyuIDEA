package NextLearn;
/*
* 子类只能继承一个父类
* 接口可UI实现多个接口,中间用,分开
* 实现接口类,必须实现所有的接口方法
* */
public class teacher extends JavaBean implements Sing,Cooking {
    public teacher() {
    }

    @Override
    public void showInfo() {
     System.out.println("会唱歌的厨子的老师的信息:");
     System.out.println(super.getSex());
     System.out.println(super.getAge());
     System.out.println(super.getName());
    }


    @Override
    public void sing() {
     System.out.println("擅长古风歌曲唱法");
    }

    @Override
    public void cook() {
    System.out.println("会做红烧肉");
    }

    public static void main(String[] args) {
       teacher teacher=new teacher();
        Sing s=new teacher();
        s.sing();
    }
}
