package com.lieyan.practice.main.d3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请键入您要发送的信息：");
            String data = sc.nextLine();
            if ("exit".equals(data)){
                System.out.println("退出成功");
                ds.close();
                break;
            }
            byte[] bytes = data.getBytes();

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),6666);
            ds.send(dp);
        }


    }
}
