package lesson6.classwork.Animals;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info(){
        System.out.println(name + " " + age);
    }

    public void jump(){
        System.out.println(name + " jump");
    }

    public abstract void voice();
}
