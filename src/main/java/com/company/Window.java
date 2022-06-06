package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {
    JFrame frame = new JFrame();
    JButton[] button;

    RandomWords randomWords = new RandomWords();
    JPanel panel = new JPanel();

    Window() {
        for (int i = 0; i < 4; i++) {
            button[i] = new JButton();
        }
        panel.setSize(200, 100);
        panel.setLocation(200, 200);
        button[0].setText("Add words");
        button[0].setSize(200, 100);
        button[0].setFocusable(false);
        button[0].addActionListener(this);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flashcards");
        panel.add(button[0]);
        panel.add(button[1]);
        frame.add(panel);
    }

    public static void popUpMessage() {
        JOptionPane.showMessageDialog(null, "No more words");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button[0]) randomWords.getNewWords();
        if(e.getSource() == button[1]);
        if(e.getSource() == button[2]);
        if(e.getSource() == button[3]);
    }
}
