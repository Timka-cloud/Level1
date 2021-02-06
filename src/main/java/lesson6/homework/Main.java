package lesson6.homework;



import lesson6.homework.Animals.Animal;
import lesson6.homework.Animals.Cat;
import lesson6.homework.Animals.Dog;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Animal[] animals = {
                new Cat("Barsik"),
                new Dog("Bobik"),
                new Cat("Murzik"),
                new Dog("Tuzik")

        };
        for(Animal a : animals){
            a.run(random.nextInt(600));
            a.swim(random.nextInt(20));
        }

        System.out.println("Кошек " + Cat.getCount()  + " штучек");
        System.out.println("Собак " + Dog.getCount()  + " штучек");
        System.out.println("Животных " + Animal.getCount() + " штучек");

    }
}
