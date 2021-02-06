package lesson4.TicTacToeWithoutOOP;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeNoOOP {




        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();

        static final char DOT_PLAYER = 'X';
        static final char DOT_AI = '0';
        static final char DOT_EMPTY = '-';

        static final int SIZE = 3;
        static char[][] map;


        public static void main(String[] args) {
            prepareMap();
            printMap();

            do {
                humanTurn();
                printMap();
                if(checkWin(DOT_PLAYER)){
                    System.out.println("Human won");
                    break;
                }
                if(isMapFull()){
                    System.out.println("Draw");
                    break;
                }

                aiTurn();
                printMap();
                if(checkWin(DOT_AI)){
                    System.out.println("AI won");
                    break;
                }
                if(isMapFull()){
                    System.out.println("Draw");
                    break;
                }
            } while (true);
            System.out.println("Game over");
        }

        public static void setSym(int x, int y, char sym){
            map[x][y] = sym;
        }

        public static boolean checkWin(char symbol){
            boolean firstDiagonal = true;
            boolean secondDiagonal = true;
            boolean horizontal;
            boolean vertical;
            for (int i = 0; i < SIZE; i++) {
                firstDiagonal = (map[i][i] == symbol) && firstDiagonal;
                secondDiagonal = (map[i][SIZE - i - 1] == symbol && secondDiagonal);
            }
            if (firstDiagonal || secondDiagonal) return true;

            for (int i = 0; i < SIZE; i++) {
                horizontal = true;
                vertical = true;
                for (int j = 0; j < SIZE; j++) {
                    horizontal = (map[j][i] == symbol && horizontal);
                    vertical = (map[i][j] == symbol && vertical);
                }
                if (horizontal || vertical) return true;
            }


            return false;
        }

        public static boolean isMapFull(){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(map[i][j] == DOT_EMPTY){
                        return false;
                    }
                }
            }
            return true;
        }

        public static void aiTurn(){

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(isCellEmpty(j,i)){
                        setSym(j,i,DOT_AI);
                        if(checkWin(DOT_AI)){
                            return;
                        }
                        setSym(j,i,DOT_EMPTY);
                    }
                }
            }

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(isCellEmpty(j,i)){
                        setSym(j,i,DOT_PLAYER);
                        if(checkWin(DOT_PLAYER)){
                            setSym(j,i,DOT_AI);
                            return;
                        }
                        setSym(j,i,DOT_EMPTY);
                    }
                }
            }




            int x,y;
            do{
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellEmpty(x,y));
            System.out.printf("AI put in these cells %d, %d\n", x + 1, y + 1);
            map[x][y] = DOT_AI;
        }

        public static void humanTurn(){
            int x,y;
            do {
                System.out.println("Put pls coordinates x and y");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            }while(!isCellEmpty(x,y));

            map[x][y] = DOT_PLAYER;
        }

        public static boolean isCellEmpty(int x, int y){
            if(x < 0 || y < 0 || x >= SIZE || y >= SIZE){
                return false;
            }

            if(map[x][y] == DOT_EMPTY){
                return true;
            }
            return false;
        }

        public static void printMap(){
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

            for (int i = 0; i < SIZE; i++) {
                System.out.print((i+1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[j][i] + " ");
                }
                System.out.println();
            }
        }

        public static void prepareMap(){
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
    }

