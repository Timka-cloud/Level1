package lesson6.classwork.Animals;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice(){
        System.out.println(name + " gav");
    }
}
