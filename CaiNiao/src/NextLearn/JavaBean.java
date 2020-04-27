package NextLearn;

public abstract class JavaBean {
    //就是封装类,又称之为JavaBean
    public JavaBean() {
    }

    private String name;
    private String  sex;
    private int age;
    public abstract void showInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
