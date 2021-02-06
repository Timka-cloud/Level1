package lesson8.homework.X0GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {
    private final int CELL_SIZE = 120; // размер одной клетки 100 пикселей
    private final int MAP_SIZE = 3;

    private byte[][] map;

    private boolean isDraw;
    private boolean isAiWon;
    private boolean isHumanWon;

    private final byte aiSign = 2;
    private final byte humanSign = 1;
    private final byte empty = 0;

    private int countAi;
    private int countHuman;
    private int countDraw;

    public GameField() {

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isDraw && isHumanWon && isAiWon) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int cellX = e.getX() / CELL_SIZE;
                        int cellY = e.getY() / CELL_SIZE;
                        if (isCellEmpty(cellX, cellY)) {
                            setSym(cellX, cellY, humanSign);
                            if (checkWin(humanSign)) {
                                isHumanWon = false;
                                return;
                            }
                            checkDraw();
                            aiTurn();
                            if (checkWin(aiSign)) {
                                isAiWon = false;
                                return;
                            }
                            checkDraw();
                        }
                    }
                }
            }
        });
        startGame();


    }



    public void checkDraw() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == 0) {
                    return;
                }
            }
        }
        isDraw = false;
        repaint();
    }

    public void startGame() {
        this.map = new byte[MAP_SIZE][MAP_SIZE];
        this.isDraw = true;
        this.isHumanWon = true;
        this.isAiWon = true;
        this.countDraw = 0;
        this.countAi = 0;

        repaint();
    }

    public void setSym(int x, int y, byte dot) { // этот метод уставнливает нужную клетку на нужный знак
        map[x][y] = dot;
    }


    public boolean checkWin(byte dot) {
        boolean firstDiagonal = true; // проверка для диагоналей
        boolean secondDiagonal = true;
        boolean horizontal;
        boolean vertical;
        for (int i = 0; i < MAP_SIZE; i++) {
            firstDiagonal = (map[i][i] == dot) && firstDiagonal;
            secondDiagonal = (map[MAP_SIZE - i - 1][i] == dot) && secondDiagonal;


        }
        if (firstDiagonal || secondDiagonal) return true;
        repaint();

        for (int i = 0; i < MAP_SIZE; i++) {
            horizontal = true;
            vertical = true;
            for (int j = 0; j < MAP_SIZE; j++) {
                horizontal = (map[j][i] == dot) && horizontal;
                vertical = (map[i][j] == dot) && vertical;
            }
            if (horizontal || vertical) return true;
        }
        repaint();
        return false;


    }


    public void aiTurn() {
        if (isDraw) {

            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (isCellEmpty(i, j)) {
                        setSym(i, j, aiSign);
                        if (checkWin(aiSign)) {
                            return;
                        }
                        setSym(i, j, empty);
                    }
                }
            }

            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (isCellEmpty(i, j)) {
                        setSym(i, j, humanSign);
                        if (checkWin(humanSign)) {
                            setSym(i, j, aiSign);
                            return;
                        }
                        setSym(i, j, empty);
                    }
                }
            }


            int cellX, cellY;
            do {
                cellX = (int) (Math.random() * MAP_SIZE);
                cellY = (int) (Math.random() * MAP_SIZE);
            } while (!isCellEmpty(cellX, cellY));
            setSym(cellX, cellY, aiSign);
            repaint();


        }

    }

    public boolean isCellEmpty(int x, int y) { // этот метод проверяет пустая клетка или нет
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) { // это строка проверяет чтобы не были данные меньше нуля и не больше размера карты
            return false;
        }
        if (map[x][y] == empty) { // если равна пустой клетки то можно ставить туда значение
            return true;
        }
        return false;
    }


    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, MAP_SIZE * CELL_SIZE, MAP_SIZE * CELL_SIZE); // цвет фона прямоугольника


        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                ((Graphics2D) g).setStroke(new BasicStroke(3)); // границы 3 пиксиля толщины
                g.setColor(Color.BLACK); // границы становиться красного цвета
                g.drawRect(i * CELL_SIZE + 2, j * CELL_SIZE + 2, CELL_SIZE, CELL_SIZE);
                if (map[i][j] == 1) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6)); // границы 3 пиксиля толщины
                    g.setColor(Color.GREEN); // границы становиться красного цвета
                    g.drawOval(i * CELL_SIZE + 12, j * CELL_SIZE + 12, CELL_SIZE - 22, CELL_SIZE - 22);
                }
                if (map[i][j] == 2) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6)); // границы 3 пиксиля толщины
                    g.setColor(Color.RED); // границы становиться красного цвета
                    g.drawLine(i * CELL_SIZE + 22, j * CELL_SIZE + 22, (i + 1) * CELL_SIZE - 22, (j + 1) * CELL_SIZE - 22);
                    g.drawLine(i * CELL_SIZE + 22, (j + 1) * CELL_SIZE - 22, (i + 1) * CELL_SIZE - 22, j * CELL_SIZE + 22);
                }
            }

        }

        if (!isHumanWon) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.BOLD, 48));
            g.drawString("HUMAN WON", 25, 190);
            countHuman++;
//            g.setColor(Color.BLACK);
//            g.setFont(new Font("Times New Roman", Font.BOLD, 36));
//            g.drawString("Human won "  + String.valueOf(countHuman), 380,100);
//            g.setColor(Color.WHITE);//background color

        }
        if (!isAiWon) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.BOLD, 48));
            g.drawString("AI WON", 80, 190);
            countAi++;
        }
        if (!isDraw) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.BOLD, 48));
            g.drawString("GAME OVER", 25, 190);
            countDraw++;
        }
    }
}
