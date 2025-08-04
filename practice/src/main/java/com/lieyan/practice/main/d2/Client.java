package com.lieyan.practice.main.d2;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket();

        String data = "这是一条信息123";
        byte[] bytes = data.getBytes();

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),6666);
        ds.send(dp);

        Thread.sleep(6000);
        System.out.println("aaa");
        String data2 = "结束";
        bytes = data2.getBytes();

        dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),6666);
        ds.send(dp);

        ds.close();
    }
}
