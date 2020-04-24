package HashTable;

public class StudentInfo {
    public StudentInfo(int age) {
        this.age = age;
    }

    private int age;
    private int count;

    StudentInfo(int age,int count){
        this.age=age;
        this.count=count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }
    //返回哈希值,散列函数
    public int Hashcode(int n){
        return age%n;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "StudentInfo{" + "age=" + age + ", count=" + count + '}';
    }
}
