package com.lieyan.practice.main.d6;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("___________________服务端已启动____________________");
        ServerSocket ServerSocket = new ServerSocket(6666);

        while (true) {
            Socket socket = ServerSocket.accept();
            System.out.println("!客户端"+socket.getRemoteSocketAddress()+"已上线");
            new ServerReaderThread(socket).start();
        }

    }
}
