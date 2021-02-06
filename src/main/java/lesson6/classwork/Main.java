package lesson6.classwork;


import lesson6.classwork.Animals.Animal;
import lesson6.classwork.Animals.Cat;
import lesson6.classwork.Animals.Dog;
import lesson6.classwork.Animals.Horse;

public class Main {
    public static void main(String[] args) {
        Animal[] animal = {
             new Cat("Barsik", 4, 15) ,
             new Dog("Bobik", 2) ,
             new Horse("Bibun", 3)
        };
        for(Animal a : animal){
            a.voice();
            a.info();
        }

        if(animal[0] instanceof Cat) {
            ((Cat) animal[0]).catMethod();
        }






    }
}
