package RefreshBaseJava;

public class GenericClass <T>{
    private T t;
    public void Add(T t){
        this.t=t;
    }
    private T get(){
        return t;
    }

    public static void main(String[] args) {
      GenericClass<Integer> interGen=new GenericClass<Integer>();
      GenericClass<String> StringGen=new GenericClass<String>();
      interGen.Add(new Integer(100));
      StringGen.Add(new String("沐汐语,我喜欢你!"));
      System.out.println("整型值为 :\t"+interGen.get());
      System.out.println("字符串为:\t"+StringGen.get());
    }
}
