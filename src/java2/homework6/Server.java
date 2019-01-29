package java2.homework6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 29/01/2019
 */

public class Server {

    private static final int PORT = 4004;

    private ServerSocket server;
    private Socket socket;
    private BufferedReader in;
    private BufferedReader reader;
    private BufferedWriter out;
    private String msg;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        initServer();
        sendMsgs();
        getMsgs();
        closeServer();
    }

    public void initServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.print("Сервер запущен. Порт ");
            System.out.println(PORT);
            socket = server.accept();

            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        } catch (Exception e) {
        }
    }

    public void closeServer() {
        try {
            in.close();
            out.close();
            socket.close();
            server.close();
            System.out.println("Сервер закрыт.");
            System.exit(0);
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
                        if (msg.equalsIgnoreCase("close chat")) {
                            break;
                        }
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