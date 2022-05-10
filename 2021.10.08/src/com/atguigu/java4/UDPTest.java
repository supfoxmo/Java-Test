package com.atguigu.java4;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author lixhui
 * @create 2021-10-22:06
 *
 * UDP协议的网络编程
 */
public class UDPTest {
    @Test
    public void semder(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "我是通过UDP方式发送的导弹";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 10086);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void receive(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(10086);

            byte[] buffer = new byte[100];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}

