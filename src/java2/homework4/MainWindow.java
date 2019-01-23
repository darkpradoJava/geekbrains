package java2.homework4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Stanislav Melekhin
 * Created on 23/01/2019
 */

public class MainWindow extends JFrame {

    private String userName;

    private JFrame window;
    private final String TITLE = "MyFirstChat";
    private final int WIDTH = 300;
    private final int HEIGHT = 400;

    private JPanel sendMsgPanel;
    private JButton send;
    private JTextField textSends;
    private JTextArea textArea;
    private JScrollPane scrollPaneTextArea;
    private JMenuBar menu;
    private JMenu file;
    private JMenu user;

    public MainWindow() {

        userName = "Unknow user";

        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setTitle(TITLE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        menu = new JMenuBar();
        file = new JMenu("File");
        user = new JMenu("User");
        menu.add(file);
        menu.add(user);
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem login = new JMenuItem("Login");
        file.add(exit);
        user.add(login);
        window.add(menu, BorderLayout.NORTH);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        sendMsgPanel = new JPanel();
        send = new JButton("Send");
        textSends = new JTextField(18);
        sendMsgPanel.add(textSends);
        sendMsgPanel.add(send);
        window.add(sendMsgPanel, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPaneTextArea = new JScrollPane(textArea);
        window.add(scrollPaneTextArea, BorderLayout.CENTER);

        textSends.requestFocus();
        window.setVisible(true);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        textSends.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    sendMsg();
                }
            }
        });
    }

    public void sendMsg() {
        if (!(textSends.getText().equals(""))) {
            textArea.append(userName + ": " + textSends.getText() + "\n");
            textSends.setText("");
            textSends.requestFocus();
        }
    }

    public void setUserName(String userName) {
        if (!(userName.equals(""))) {
            this.userName = userName;
        }
    }

    public void login() {
        JFrame winLog = new JFrame("login");
        winLog.setSize(300, 80);
        winLog.setLocationRelativeTo(null);
        winLog.setResizable(false);

        JPanel panelLog = new JPanel();
        JTextField login = new JTextField(15);
        JButton sendLogin = new JButton("Login");
        panelLog.add(login);
        panelLog.add(sendLogin);
        winLog.add(panelLog, BorderLayout.CENTER);

        winLog.setVisible(true);

        sendLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUserName(login.getText());
                winLog.setVisible(false);
            }
        });
    }

}
