package com.lieyan.practice.main.d4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",6666);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeUTF("你爱我我爱你");

        dos.close();
        socket.close();
    }
}
