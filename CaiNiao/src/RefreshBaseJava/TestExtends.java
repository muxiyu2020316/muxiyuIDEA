package RefreshBaseJava;

public class TestExtends {
    public static void main(String[] args) {
        /*Animal a = new Animal(); // Animal
        Animal b = new Dog(); // Dog
        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法
        // b.age;//去掉前注释符号，会编译错误
        // b.bark();//去掉前注释符号，会编译错误
         */
        Salary s = new Salary("员工 A", "北京", 1, 3600.00);
        //e 是 Employee 的引用，所以调用 e 的 mailCheck() 方法时，编译器会去 Employee 类查找 mailCheck() 方法
        Employee e = new Salary("员工 B", "上海", 2, 2400.00);
        Employee f = new Employee("员工 c", "海南", 3);
//        Salary k= (Salary) new Employee("员工D","江西",4);
        System.out.println("使用 Salary 的引用调用 mailCheck -- ");
        s.mailCheck();
        System.out.println("\n使用 Employee 的引用调用 mailCheck--");
        e.mailCheck();
        System.out.println("\n使用 Employee 调用 mailCheck--");
        f.mailCheck();
//        System.out.println("\n使用 Salary 调用 mailCheck--");
//        k.getSalary();
    }
}
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
}
class Dog extends Animal{
    public int age;
    public void move(){
        age = 10;
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
class Employee implements java.io.Serializable{
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public void mailCheck() {
        System.out.println("邮寄支票给： " + this.name
                + " " + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
}
class Salary extends Employee implements java.io.Serializable {
    private double salary; // 全年工资
    public Salary(String name, String address, int number, double salary) {

        super(name, address, number);
        setSalary(salary);
        System.out.println("Salary引用Employee构造函数");
    }
    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + getName()
                + " ，工资为：" + salary);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double newSalary) {
        if(newSalary >= 0.0) {
            salary = newSalary;
        }
    }
    public double computePay() {
        System.out.println("计算工资，付给：" + getName());
        return salary/52;
    }
}

