package lesson7.homework;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 70),
                new Cat("Barni", 80),
                new Cat("Zaika", 30)
        };
        Plate plate = new Plate(100);
        plate.info();
        for(Cat c : cats){
            c.eat(plate);
            plate.info();
            if(!c.getSatiety()){
                int n = c.getAppetite() - plate.getFood();
                plate.addFood(n);
                plate.info();
                c.eat(plate);
                plate.info();
            }
        }


    }

}
