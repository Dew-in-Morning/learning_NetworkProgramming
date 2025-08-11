package com.lieyan.practice.main.d8;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static List<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("___________________服务端已启动____________________");
        ServerSocket ServerSocket = new ServerSocket(8080);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(16*2,16*2,0, TimeUnit.SECONDS,  new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            Socket socket = ServerSocket.accept();
            System.out.println("!客户端" + socket.getRemoteSocketAddress() + "已上线");
            pool.execute(new ServerReaderRunnable(socket));
        }

    }
}
