package RefreshBaseJava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class TestSerializableDemo {
    public static void main(String[] args) {
    Employement employement=new Employement();
    employement.name="江小白";
    employement.address="山海金戈";
    employement.SSMNT=71252993;
    employement.number=10023186;
    try{
        FileOutputStream fileout=new FileOutputStream("employement.ser");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileout);
        objectOutputStream.writeObject(employement);
        objectOutputStream.close();
        System.out.println("Serialized data is saved incemployement.ser");
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
