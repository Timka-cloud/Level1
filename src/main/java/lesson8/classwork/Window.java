package lesson8.classwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame{
    public Window()  {
        this.setBounds(500,300,800,400);
        this.setTitle("Simple Swing app");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        JTextArea textArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(textArea);
        this.add(jsp, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new GridLayout(1,10,5,0));
        this.add(southPanel, BorderLayout.SOUTH);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            southPanel.add(button);

            final int index = i;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(String.valueOf(index) + "\n");
                }
            });
        }

        JTextField textField = new JTextField();
        this.add(textField, BorderLayout.NORTH);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
            }
        });

//        JSlider slider = new JSlider(5,100);
//        this.add(slider, BorderLayout.EAST);
//        slider.addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                //System.out.println(((JSlider)e.getSource()).getValue());
//                textArea.append(String.valueOf(((JSlider) e.getSource()).getValue()) + "\n");
//            }
//        });






        this.setVisible(true);
    }
}
