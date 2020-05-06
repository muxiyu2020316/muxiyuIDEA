package Aglog;

import java.util.HashSet;
import java.util.Objects;

/***
 * set相关面试题
 */
public class TestSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        System.out.println(set+"\n");
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set+"\n");
        set.add(new Person(1001,"CC"));
        System.out.println(set+"\n");
        set.add(new Person(1001,"AA"));
        System.out.println(set+"\n");
    }
}
class Person{
 int id;
 String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
 * equals和hashcode必须重写
 * 重写方法alt+insert--->equals和hashcode
 * 默认执行下一步,实现重写,不是最下面的重写,那样没用
 * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}