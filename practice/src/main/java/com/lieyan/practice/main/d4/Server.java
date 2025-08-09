package com.lieyan.practice.main.d4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("___________________服务端已启动____________________");
        ServerSocket socket = new ServerSocket(6666);
        Socket accept = socket.accept();
        InputStream is = accept.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        String s = dis.readUTF();
        System.out.println(s);
        System.out.println(accept.getRemoteSocketAddress());

        dis.close();
        socket.close();
        accept.close();
    }
}
