package lesson5.homework.HomeWork;

public class Employees {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employees(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.printf("Name: %s,position: %s,email: %s, phoneNumber: %s, salary: %d, age: %d", name, position, email
        , phoneNumber,salary,age);
    }

    public int getAge() {
        return age;
    }
}
