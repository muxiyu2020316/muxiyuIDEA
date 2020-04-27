package NextLearn;
public class TestAnnotation extends T{
    //抑制编辑器警告
    @SuppressWarnings("lll")
    @Override//重写
    void test(){}

    public static void main(String[] args) {
        T t=new T();
        t.test();
    }
}
class T{
    @Deprecated//方法过时
    void test(){System.out.println("方法过时@Deprecated");}
}
class C{

    public void name(int a){}
}