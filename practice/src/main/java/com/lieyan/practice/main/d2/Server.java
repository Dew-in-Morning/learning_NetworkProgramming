package com.lieyan.practice.main.d2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(6666);

        byte[] buffer = new byte[1024*64];

        DatagramPacket dp = new DatagramPacket(buffer,buffer.length);

        while (true){
            ds.receive(dp);

            int length = dp.getLength();
            String data = new String(buffer,0,length);

            System.out.println(data);
            System.out.println(dp.getAddress().getHostAddress());
            System.out.println(dp.getPort());
            if ("结束".equals(data)){
                System.out.println("结束啦~");
                break;
            }
        }

        ds.close();
    }
}
