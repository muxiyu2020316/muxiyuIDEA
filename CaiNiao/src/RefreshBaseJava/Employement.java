package RefreshBaseJava;

    public class Employement implements java.io.Serializable{
        public String name;
        public String address;
        public transient int SSMNT;
        public int number;
        public Employement(){};
        public Employement(String name, String address, int number) {
            this.name = name;
            this.address = address;
            this.number = number;
        }
        public void mailCheck(){
            System.out.println("Mailing a Check to"+name+" "+address+" "+number);
        }

        public static void main(String[] args) {
            Employement employement=new Employement("沐汐语","云南大理",200100);
            employement.mailCheck();
        }
    }
