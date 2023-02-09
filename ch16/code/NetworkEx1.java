package ch16.code;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println("toString() : " + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println( "getAddress() : " + Arrays.toString(ipAddr));
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }


        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName() : " + ip.getHostName());
            System.out.println("getHostAddress() : " + ip.getHostAddress());
            System.out.println("toString() : " + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println( "getAddress() : " + Arrays.toString(ipAddr));
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("comic.naver.com");
            for (InetAddress address : ipArr) {
                System.out.println("address() : " + address);
            }

        } catch(UnknownHostException e) {
            e.printStackTrace();
        }

    }
}