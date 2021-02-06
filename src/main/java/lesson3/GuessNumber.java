package lesson3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number between 0 to 9");
        int counter = 0;
        int input = -1;
        boolean answer = true;
        int randomedNum = random.nextInt(10);
        do{
            while (counter != 3){
                input = scanner.nextInt();
                counter++;
                if(input == randomedNum){
                    System.out.println("You won");
                    break;
                }
                else if (input > randomedNum) {
                    System.out.println("It's less");
                } else if (input < randomedNum) {
                    System.out.println("It's more");
                }
            }
            if(counter == 3 && input != randomedNum){
                System.out.println("You used all attempts");
            }
            counter = 0;
            System.out.println("Repeat? 1-yes 2-no");

            input = scanner.nextInt();
            if(input == 1){
                answer = true;
                System.out.println("Guess the new number");
            }
            else if(input == 2){
                answer = false;
                System.out.println("Thank you, good-bye");
            }


        } while(answer);


    }

}

