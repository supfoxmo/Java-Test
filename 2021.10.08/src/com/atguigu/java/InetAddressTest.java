package com.atguigu.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lixhui
 * @create 2021-10-15:19
 *
 * 一、网络编程有两个主要问题：
 * 1、如何准确地定位网络上一台或多台主机；定位主机上的特定应用
 * 2、找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1、对应问题一：IP和端口号
 * 2、对应问题二：提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理和链路层)
 *
 * 三、通信要素一：IP和端口号
 * 1、IP：唯一的标识 Internet 上的计算机（通信实体）
 * 2、在Java中使用InetAddress类代表IP
 * 3、IP分类：IPv4 和 IPv6; 万维网 和  局域网
 * 4、域名： www.baidu.com    www.mi.com    www.sina.com   www.atguigu.com
 * 5、本地回路地址：172.0.0.1 对应着 localhost
 * 6、如何实例化InetAddress:
 *      getByName(String host)          getLocalHost()
 *    两个常用方法： getHostName()/getHostAddress()
 * 7、端口号：表示正在计算机上运行的进程
 *       要求：不同的进程有不同的端口号
 *       范围：被规定为一个16位的整数 0~65535
 * 8、端口号和IP地址的组合得到一个网络套接字: Socket
 *
 */


public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.24");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);//www.baidu.com/183.232.231.174

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            System.out.println(inet2.getHostName());//www.baidu.com

            System.out.println(inet2.getHostAddress());//183.232.231.174
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
