package RefreshBaseJava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
//序列化和反序列化
public class TesDeserializableDemo {
    public static void main(String[] args) {
        Employement employement = null;
        try {
            FileInputStream filein=new FileInputStream("employement.ser");
            ObjectInputStream objectInputStream=new ObjectInputStream(filein);
            //这里需要强制类型转换,一个是Employement类,一个是ObjectStream,需要强制转换
            employement= (Employement) objectInputStream.readObject();
            objectInputStream.close();
            filein.close();
        } catch (Exception e) {
            System.out.println("Employee class not found");
            e.printStackTrace();
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + employement.name);
        System.out.println("Address: " + employement.address);
        System.out.println("SSMNT: " + employement.SSMNT);
        System.out.println("Number: " + employement.number);
    }
}
