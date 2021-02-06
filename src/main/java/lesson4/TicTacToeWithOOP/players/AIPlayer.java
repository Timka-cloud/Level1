package lesson4.TicTacToeWithOOP.players;

import lesson4.TicTacToeWithOOP.map.Map;

import java.util.Random;

public class AIPlayer extends Player{
    private Random random;
    private char specialDot = 'X';

    public AIPlayer(char dot) {
        this.random = new Random();
        this.dot = dot;
    }

    @Override
    public void turn(Map map) {

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.isCellEmpty(j,i)){
                    map.setSym(j,i,dot);
                    if(map.checkWin(dot)){
                        return;
                    }
                    map.setSym(j,i,map.getDOT_EMPTY());
                }
            }
        }

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if(map.isCellEmpty(j,i)){
                    map.setSym(j,i,specialDot);
                    if(map.checkWin(specialDot)){
                        map.setSym(j,i,dot);
                        return;
                    }
                    map.setSym(j,i,map.getDOT_EMPTY());
                }
            }
        }

        int x, y;
        do {
            x = random.nextInt(map.getSize());
            y = random.nextInt(map.getSize());
        } while (!map.isCellEmpty(x, y));
        map.setSym(x,y,dot);
        System.out.printf("Ход ИИ: [%d, %d]\n", x + 1, y + 1); // + 1 нужен чтобы на экране отображалась правильно
    }
}
