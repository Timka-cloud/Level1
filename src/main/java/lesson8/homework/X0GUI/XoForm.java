package lesson8.homework.X0GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XoForm extends JFrame {
    private GameField gameField;
    public XoForm()  {
        this.setTitle("Tic-Tac-Toe");
        this.setBounds(500,300,383,451);
//        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.gameField = new GameField();

        this.add(gameField);


        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        Button btnStart = new Button("Start New Game");
        Button btnEnd = new Button("Exit Game");
        bottomPanel.add(btnStart);
        bottomPanel.add(btnEnd);
        bottomPanel.setPreferredSize(new Dimension(1,40));
        this.add(bottomPanel, BorderLayout.SOUTH);

        btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnEnd.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameField.startGame();
            }
        });
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new XoForm();
    }
}
