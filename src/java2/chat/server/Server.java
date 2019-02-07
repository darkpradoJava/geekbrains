package java2.chat.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Stanislav Melekhin
 * email darkprado@yandex.ru
 * Created on 07/02/2019
 */

public class Server {

    private final static int PORT = 4004;

    private ServerSocket server = null;
    private Socket socket = null;
    private ClientHandler newClient = null;
    private List<ClientHandler> clients = new ArrayList<>();
    private Scanner inMessage;

    public Server() {

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен...");
            while (true) {
                socket = server.accept();
                System.out.println("Введите свой ник");
                newClient = new ClientHandler(socket, this, inMessage.next());
                clients.add(newClient);
                new Thread(newClient).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void sendMsgToAllClients(String msgText) {
        clients.forEach(clientHandler -> clientHandler.sendMessage(msgText));
    }

    public void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

}
