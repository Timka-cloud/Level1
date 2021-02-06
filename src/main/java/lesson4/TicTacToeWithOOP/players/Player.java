package lesson4.TicTacToeWithOOP.players;

import lesson4.TicTacToeWithOOP.map.Map;

public abstract class Player {
    char dot;

    public char getDot() {
        return dot;
    }

    public abstract void turn(Map map);
}

