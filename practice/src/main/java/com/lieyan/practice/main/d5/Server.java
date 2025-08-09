package com.lieyan.practice.main.d5;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("___________________服务端已启动____________________");
        ServerSocket socket = new ServerSocket(6666);
        Socket accept = socket.accept();
        InputStream is = accept.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        while (true) {
            try {
                String s = dis.readUTF();
                System.out.println(s);
                System.out.println(accept.getRemoteSocketAddress());
            } catch (IOException e) {
                System.out.println(accept.getRemoteSocketAddress()+"客户端断开");
                dis.close();
                accept.close();
                break;
            }
        }

    }
}
