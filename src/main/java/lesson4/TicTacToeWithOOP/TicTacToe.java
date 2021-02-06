package lesson4.TicTacToeWithOOP;

import lesson4.TicTacToeWithOOP.map.Map;
import lesson4.TicTacToeWithOOP.players.AIPlayer;
import lesson4.TicTacToeWithOOP.players.HumanPlayer;
import lesson4.TicTacToeWithOOP.players.Player;

public class TicTacToe {

    public static void main(String[] args) {
        Map map = new Map();
        map.prepare();
        map.print();

        Player player1 = new HumanPlayer('X');
        Player player2 = new AIPlayer('0');

        while (true) {
            player1.turn(map);
            map.print();
            if(map.checkWin(player1.getDot())){
                System.out.println("Player1 WON");
                break;
            }
            if(map.isFull()){
                System.out.println("Ничья");
                break;
            }

            player2.turn(map);
            map.print();
            if(map.checkWin(player2.getDot())){
                System.out.println("Player2 WON");
                break;
            }
            if(map.isFull()){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра завершена");

    }




}

