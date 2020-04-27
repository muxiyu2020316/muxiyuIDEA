package NextLearn;

public class TestFanxing {
    public static void main(String[] args) {
       A<String> a1=new A<>();
       a1.getSetKey();
       //在new对象的时候已经指定了类型
       a1.setSetKey("111");
       //不指定泛型相当于指定了一个Object类型
       A a2=new A();
       a2.setSetKey("12");
       //同样的类,泛型指定了不同的数据类型,互相之间不能赋值
        //a1.getScore()=a2.getScore();
        System.out.println(a1.test());
    }
}
//泛型尽量用大写,T=type
class A<T>implements IT<T>{
    private T setKey;

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    private T score;
    public A(){}

    public A(T setKey, T score) {
        this.setKey = setKey;
        this.score = score;
    }

    public T getSetKey() {
        return setKey;
    }

    public void setSetKey(T setKey) {
        this.setKey = setKey;
    }

    @Override
    public T test() {
        return null;
    }
}
interface IT<T>{
    T test();
}
