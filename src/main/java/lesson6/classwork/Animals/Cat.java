package lesson6.classwork.Animals;

public class Cat extends Animal {
    private int weight;

    public Cat(String name, int age, int weight) {
        super(name, age);
        this.weight = weight;
    }

    @Override
    public void voice(){
        System.out.println(name + " meow");
    }

    public void catMethod(){
        System.out.println("cat method");
    }
}
