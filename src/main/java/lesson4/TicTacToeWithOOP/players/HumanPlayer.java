package lesson4.TicTacToeWithOOP.players;


import lesson4.TicTacToeWithOOP.map.Map;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner sc;


    public HumanPlayer(char dot) {
        this.sc = new Scanner(System.in);
        this.dot = dot;
    }


    @Override
    public void turn(Map map) {
        int x, y;
        do {
            System.out.println("Укажите координаты хода в формате 'x y'");
            x = sc.nextInt() - 1; // -1 используем чтобы что преобразовать координату в координату который умеет читать массив
            y = sc.nextInt() - 1; // например индексация массива начинается с 0 а игрок с 1
        } while (!map.isCellEmpty(x, y));
        map.setSym(x, y, dot);
    }
}

