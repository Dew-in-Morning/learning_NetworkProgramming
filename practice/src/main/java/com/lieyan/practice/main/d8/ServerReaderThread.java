package com.lieyan.practice.main.d8;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<div style='color:red;font-size:100px;text-align:center'>灼识炽心</div>");
            ps.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
