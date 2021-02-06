package lesson8.homework.guessNumberGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {
    private JTextField textField;
    private boolean isWon;
    private boolean isLost;
    private int randomNum;
    private int myNum;
    private int count;
    private Random random = new Random();
    public Main() {
        randomNum = random.nextInt(10) + 1;
        System.out.println(randomNum);
        this.setTitle("Guess Number");
        this.setBounds(500,300,400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField = new JTextField();
        this.add(textField, BorderLayout.NORTH);
        textField.setPreferredSize(new Dimension(1,50));

        JPanel panel = new JPanel(new GridLayout(2,3));
        this.add(panel, BorderLayout.CENTER);

        //
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
                startGame();
                System.out.println(randomNum);
            }
        });
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            panel.add(button);

            final int index = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    textField.setText(String.valueOf(index));
                    count++;
                    myNum = index;
                    if(myNum == randomNum){
                        isWon = true;
                        textField.setText("You WON");

                        return;
                    }
                    if(count >= 3){
                        isLost = true;
                        textField.setText("You Lost");
                        randomNum = 0; // чтобы когда все три попытки ушли он нажимал кнопки и не нашел правильный ответ

                        return;
                    }

                }
            });
        }


        
        this.setVisible(true);
    }

    public void startGame(){
        randomNum = random.nextInt(10) + 1;
        textField.setText("");
        count = 0;
        isLost = false;
        isWon= false;
    }

    public static void main(String[] args) {
        new Main();
    }
}
