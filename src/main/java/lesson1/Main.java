package lesson1;

public  class Main {
    public static void main(String[] args) {
        determineYear(2020);
    }
    public static float calculateAndReturn(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    public static boolean checkRange(int a, int b){
        int sum = a + b;
        if(sum >= 10 && sum <= 20){
            return true;
        }
        return false;
    }

    public static boolean checkNum(int a){
        if(a >= 0){
            return false;
        }
        return true;
    }
    public static void sayHello(String s){
        System.out.println("Hello " + s);
    }

    public static void determineYear(int a){
        if(a % 4 == 0 || a % 400 == 0 && a % 100 == 0){
            System.out.println("it's a leap year");
        }
        else {
            System.out.println("It's not a leap year");
        }
    }



}
