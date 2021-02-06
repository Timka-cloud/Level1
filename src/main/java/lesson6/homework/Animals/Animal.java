package lesson6.homework.Animals;

public class Animal {
    static int count = 0;
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    String type;


    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int length) {
        if (length < maxRunDistance) {
            System.out.println(type + " " + name + " пробежал " + length + "м");
        } else {
            System.out.println(type + " " + name +  " не смог пробежать " + length + "м");
        }
    }


    public void swim(int length){
        if(maxSwimDistance == 0){
            System.out.println(type + " " + name + " не умеет плавать");
            return;
        }
        if(length < maxSwimDistance){
            System.out.println(type + " " + name + " проплыл " + length + "м");
        } else {
            System.out.println(type +  " " + name + " не смог проплыть " + length + "м");
        }
    }


}
