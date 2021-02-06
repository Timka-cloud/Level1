package lesson2;

public class Main {
    public static void main(String[] args) {

        // boolean answer = checkBalance(new int[]{1,1,1,2,1}); for task 6
        // System.out.println(answer); for task 6


    }

    public static void changeValues1to0AndReverse() {
        /**
         * Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else arr[i] = 1;

            System.out.print(arr[i]);
        }

    } // N1

    public static void fillArray() {
        /**
         * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */

        int[] array = new int[8];

        for (int i = 0, j = 0; i < array.length; i++, j += 3) {
            array[i] = j;
            System.out.print(array[i] + " ");
        }

    } // N2

    public static void checkIfLess6ThenMultipleBy2() {
        /**
         * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */


        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 6) {
                array[i] *= 2;
            }
            System.out.print(array[i] + " ");
        }
    } //N3


    public static void fillDiagonals() {
        /**
         * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         * и с помощью цикла(-ов) заполнить его диагональные элементы единицами
         * (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей
         * можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
         */


//            int [][] matrix = new int[3][3];   // 1 variant
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0, j2 = matrix[i].length; j < matrix[i].length; j++, j2--) {
//                    if (i == j || i == (j2 - 1)) {
//                        matrix[i][j] = 1;
//                    }
//                    System.out.print(matrix[i][j] + " ");
//                }
//                System.out.print("\r\n");
//            }

        int[][] matrix2 = new int[5][5];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                if (i == j || j == matrix2.length - 1 - i) {
                    matrix2[i][j] = 1;
                }
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.print("\r\n");
        }


    }


    //N4

    public static void findMaxAndMin() {
        /**
         * ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
         */


        int[] arr = {1, 2, 3, 7, 9, 5};
        int max = arr[1];
        int min = arr[1];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        System.out.println("Max is " + max);
        System.out.println("Min is " + min);

    } //N5

    public static boolean checkBalance(int[] arr) {
        /**
         * ** Написать метод, в который передается не пустой одномерный целочисленный массив,
         * метод должен вернуть true, если в массиве есть место, в котором сумма левой
         * и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
         * checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
         */


//       int left = 0;  // variant 1
//        for (int i = 0; i < arr.length; i++) {
//            left += arr[i];
//            int right = 0;
//            for (int j = i + 1; j < arr.length; j++) {
//                right += arr[j];
//            }
//            if(left == right){
//                return true;
//            }
//        }return false;


        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum * 2 == sum) {
                return true;
            } else if (leftSum * 2 > sum) {
                return false;
            }
        }
        return false;


    } //6


}





