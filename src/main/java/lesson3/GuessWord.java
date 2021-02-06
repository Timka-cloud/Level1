package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    public static void main(String[] args) {
        char[] symbols = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#',};
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                "potato"};
        char sym = '#';
        int input2;
        String input = "";
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int ran = random.nextInt(words.length);
        String word = words[ran];
        System.out.println(words[ran]);

        while (!input.equals(word)) {
            input = scanner.nextLine();
            if (word.equals(input)) {
                System.out.println("You won");
            }
            char[] r = word.toCharArray();
            char[] t = input.toCharArray();
            for (int i = 0; i < r.length; i++) {
                for (int j = 0; j < t.length; j++) {
                    if (r[i] == t[j]) {
                        symbols[i] = r[i];
                    }
                }
            }
            System.out.println(Arrays.toString(symbols));
        }


    }

}

