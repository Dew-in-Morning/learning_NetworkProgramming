package com.lieyan.practice.main.d7;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                try {
                    String msg = dis.readUTF();
                    System.out.println("客户端"+socket.getRemoteSocketAddress()+"说："+msg);
                    sendMsgtoAll(msg);
                } catch (Exception e) {
                    Server.sockets.remove(socket);
                    System.out.println("!客户端"+socket.getRemoteSocketAddress()+"已下线");
                    dis.close();
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sendMsgtoAll(String msg) throws IOException {
        for (Socket soc : Server.sockets) {
            OutputStream os = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
