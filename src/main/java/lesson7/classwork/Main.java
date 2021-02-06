package lesson7.classwork;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball("Red");
        Ball ball2 = new Ball("Blue");
        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog("Tuzik");

        dog1.play(ball);
        dog1.play(ball);
        dog1.play(ball2);
        dog2.stop();
        dog2.play(ball);
        dog2.play(ball2);
        dog1.play(ball2);
        dog1.stop();
        dog2.stop();
    }
}
