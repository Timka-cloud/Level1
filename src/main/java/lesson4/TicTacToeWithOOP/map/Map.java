package lesson4.TicTacToeWithOOP.map;



import java.util.Random;
import java.util.Scanner;public class Map {
    private char[][] data;
    private int size;
    char DOT_EMPTY = '-';

    public int getSize() {
        return size;
    }

    public char getDOT_EMPTY() {
        return DOT_EMPTY;
    }

    public boolean checkWin(char symbol){
        boolean firstDiagonal = true; // проверка для диагоналей
        boolean secondDiagonal = true;
        boolean horizontal;
        boolean vertical;
        for (int i = 0; i < size; i++) {
            firstDiagonal = (data[i][i] == symbol) && firstDiagonal;
            secondDiagonal = (data[size - i - 1][i] == symbol) && secondDiagonal;


        }
        if(firstDiagonal || secondDiagonal) return true;

        for (int i = 0; i < size; i++) {
            horizontal = true;
            vertical = true;
            for (int j = 0; j < size; j++) {
                horizontal = (data[j][i] == symbol) && horizontal;
                vertical = (data[i][j] == symbol) && vertical;
            }
            if(horizontal || vertical) return true;
        }
        return false;


    }

    public boolean isFull(){
        for (int i = 0; i < size; i++) {  //этот метод проверяет карта заполнена или нет, если есть dot_empty то вернем false
            for (int j = 0; j < size; j++) {
                if(data[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public  void setSym(int x, int y, char sym) { // этот метод уставнливает нужную клетку на нужный знак
        data[x][y] = sym;
    }

    public boolean isCellEmpty(int x, int y) { // этот метод проверяет пустая клетка или нет
        if (x < 0 || y < 0 || x >= size || y >= size) { // это строка проверяет чтобы не были данные меньше нуля и не больше размера карты
            return false;
        }
        if (data[x][y] == DOT_EMPTY) { // если равна пустой клетки то можно ставить туда значение
            return true;
        }
        return false;
    }

    public  void print() {
        for (int k = 0; k <= size; k++) { // этот цикл чтобы также расспечатать координаты по горизонтали
            System.out.print(k + " ");

        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " "); // чтобы для пользователя было видна координаты по вертикали
            for (int j = 0; j < size; j++) {

                System.out.print(data[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println(); // это если два раза вызовем метод чтобы они не склеивались
    }

    public  void prepare() {  // I prepared the map but didn't print it
        size = 3;
        data = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = DOT_EMPTY;
            }
        }
    }
}
