package com.lieyan.practice.main.d1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class d1_id {
    public static void main(String[] args) throws IOException {
        System.out.println("---测试开始---");
        System.out.println("test-1");
        InetAddress ip1=InetAddress.getLocalHost();
        System.out.println(ip1);
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());

        System.out.println("test-2");
        InetAddress ip2=InetAddress.getByName("www.baidu.com");
        System.out.println(ip2);
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        System.out.println("test-3");
        boolean reachable = ip2.isReachable(6000);
        System.out.println("测试结束");
    }
}
