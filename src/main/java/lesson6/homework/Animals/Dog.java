package lesson6.homework.Animals;

public class Dog extends Animal{
    static int count = 0;

    public Dog(String name){
        super(name);
        count++;
        this.maxRunDistance = 500;
        this.maxSwimDistance = 10;
        this.type = "Собака";

    }

    public static int getCount() {
        return count;
    }


}
