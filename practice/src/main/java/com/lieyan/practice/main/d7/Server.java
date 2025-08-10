package com.lieyan.practice.main.d7;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> sockets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        System.out.println("___________________服务端已启动____________________");
        ServerSocket ServerSocket = new ServerSocket(6666);

        while (true) {
            Socket socket = ServerSocket.accept();
            sockets.add(socket);
            System.out.println("!客户端"+socket.getRemoteSocketAddress()+"已上线");
            new ServerReaderThread(socket).start();
        }

    }
}
