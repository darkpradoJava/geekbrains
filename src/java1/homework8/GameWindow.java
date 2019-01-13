package java1.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;
    private JPanel panelBottom;
    private JButton btnStartNewGame;
    private JButton btnExit;
    private static Field field;

    GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        panelBottom = new JPanel(new GridLayout(1, 2));
        btnStartNewGame = new JButton("Start new game");
        btnExit = new JButton("Exit game");
        panelBottom.add(btnStartNewGame);
        panelBottom.add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        field = new Field();
        add(field, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

}
