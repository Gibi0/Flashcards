package com.company;

import javax.swing.*;

public class Window {
    JFrame frame = new JFrame();

    Window() {
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flashcards");
    }
}
