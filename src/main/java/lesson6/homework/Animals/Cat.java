package lesson6.homework.Animals;

public class Cat extends Animal{
    static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
        this.maxRunDistance = 200;
        this.maxSwimDistance = 0;
        this.type = "Кот";

    }

    public static int getCount() {
        return count;
    }


}
