package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.*;

public class Window implements ActionListener {
    GetWords getWords = new GetWords();
    JFrame frame = new JFrame();
    JButton[] button = new JButton[4];
    Font font = new Font("Dialog", Font.ITALIC, 38);
    RandomWords randomWords = new RandomWords();
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    boolean temp = false;

    Window() {
        getWords.firstWord();
        for (int i = 0; i < 4; i++) {
            button[i] = new JButton();
        }
        button[0].setText("Add words");
        button[0].setSize(200, 100);
        button[0].setFocusable(false);
        button[0].addActionListener(this);
        button[1].setText((String) GetWords.currentWord.get("English_word"));
        button[1].setFocusable(false);
        button[1].setPreferredSize(new Dimension(500, 100));
        button[1].addActionListener(this);
        button[1].setFont(font);
        button[2].setText("Know");
        button[2].setFocusable(false);
        button[2].setSize(200, 100);
        button[2].addActionListener(this);
        button[3].setText("Don't know");
        button[3].setFocusable(false);
        button[3].setSize(200, 100);
        button[3].addActionListener(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flashcards");
        frame.setLayout(new GridLayout(3,1));

//        frame.setResizable(false);

        panel.add(button[0],BorderLayout.NORTH);
        panel1.add(button[1]);
        panel2.add(button[2]);
        panel2.add(button[3]);
        frame.add(panel);
        frame.add(panel1);
        frame.add(panel2);
        frame.pack();
    }

    public static void popUpMessage() {
        JOptionPane.showMessageDialog(null, "No more words");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]) randomWords.getNewWords();
        if (e.getSource() == button[1]) {
            if (!temp) {
                button[1].setText((String) GetWords.currentWord.get("Polish_word"));
                temp = true;
            } else {
                button[1].setText((String) GetWords.currentWord.get("English_word"));
                temp = false;
            }
        }
        if (e.getSource() == button[2]) {
            Box.boxUpdateUp();
            getWords.getWord();
            button[1].setText((String) GetWords.currentWord.get("English_word"));
        }
        if (e.getSource() == button[3]) {
            Box.boxReturnToFirst();
            getWords.getWord();
            button[1].setText((String) GetWords.currentWord.get("English_word"));
        }
    }
}
