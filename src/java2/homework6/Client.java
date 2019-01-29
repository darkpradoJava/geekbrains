package java2.homework6;

import java.io.*;
import java.net.Socket;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 29/01/2019
 */

public class Client {

    private static final String HOST_DIR = "localhost";
    private static final int PORT = 4004;

    private Socket socket;
    private BufferedWriter out;
    private BufferedReader reader;
    private BufferedReader in;
    private String msg;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        initClient();
        sendMsgs();
        getMsgs();
        closeClient();
    }

    public void initClient() {
        try {
            socket = new Socket(HOST_DIR, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            reader = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.print("Клиент запущен. Порт ");
            System.out.println(PORT);
        } catch (Exception e) {
        }
    }

    public void closeClient() {
        try {
            in.close();
            out.close();
            socket.close();
            System.out.println("Клиент закрыт.");
        } catch (Exception e) {
        }
    }

    public void getMsgs() {
        Thread gets = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        msg = in.readLine();
                        if (msg.equalsIgnoreCase("close chat")) {
                            break;
                        }
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                }
            }
        });
        try {
            gets.start();
            gets.join();
        } catch (InterruptedException e) {
        }
    }

    public void sendMsgs() {
        Thread sends = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        msg = reader.readLine();
                        out.write(msg + "\n");
                        out.flush();
                    }
                } catch (Exception e) {
                }
            }
        });
        try {
            sends.start();
        } catch (Exception e) {
        }
    }
}