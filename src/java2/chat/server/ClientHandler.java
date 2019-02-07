package java2.chat.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 07/02/2019
 */

public class ClientHandler implements Runnable {

    private static final int PORT = 4004;
    private static final String HOST = "localhost";
    private static String NEW_CLIENTS_MSG = "Новый участник! Теперь нас = ";
    private static String EXIT_CLIENT_MSG = "Участник вышел! Теперь нас = ";
    private static int clientsCount = 0;
    private static String KEY_OF_SESSION_END = "session end";

    private PrintWriter outMessage;
    private Scanner inMessage;
    private Socket socket;
    private Server server;

    public ClientHandler(Socket socket, Server server) {

        clientsCount++;
        this.socket = socket;
        this.server = server;
        try {
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            server.sendMsgToAllClients(NEW_CLIENTS_MSG + clientsCount);

            while (true) {
                if (inMessage.hasNext()) {
                    String clientsMsg = inMessage.nextLine();
                    System.out.println(clientsMsg);

                    if (clientsMsg.equalsIgnoreCase(KEY_OF_SESSION_END)) {
                        break;
                    }

                    server.sendMsgToAllClients(clientsMsg);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exitClientSession();
        }
    }

    public void sendMessage(String msgText) {
        outMessage.println(msgText);
        outMessage.flush();
    }

    public void exitClientSession() {
        server.removeClient(this);
        clientsCount--;
        server.sendMsgToAllClients(EXIT_CLIENT_MSG + clientsCount);
    }

}
