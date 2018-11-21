package sample.model;

public class User {

    private String name;
    private int age;
    private boolean isMale;

    public User() {
        name = "Sample Name";
        age = 42;
        isMale = true;
    }

    public User(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getMale() {
        return isMale;
    }

}
