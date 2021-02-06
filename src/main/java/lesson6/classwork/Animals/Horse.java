package lesson6.classwork.Animals;

public class Horse extends Animal{
    public Horse(String name, int age) {
        super(name,age);
    }


    @Override
    public void voice(){
        System.out.println(name + " fr-fr-fr");
    }
}
