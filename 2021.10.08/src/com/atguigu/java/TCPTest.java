package com.atguigu.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixhui
 * @create 2021-10-16:27
 */

// 例一：客户端发送信息给服务端，服务端将数据显示在控制台上
public class TCPTest {
//    客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1、创建Socket对象，知名服务端的IP和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8898);
            //2、获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3、写出数据的操作
            os.write("你好！我是客户端 lixhui".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源的关闭
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    服务端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1、创建服务器端的ServerSocket，知名自己的端口号
            ss = new ServerSocket(8898);
            //2、调用 accept() 方法接收来自客户端的 Socket
            socket = ss.accept();
            //3、获取输入流
            is = socket.getInputStream();

//            不建议，可能会出现乱码
//            byte[] buffer = new byte[10];
//            int len = 0;
//            while ((len = is.read(buffer)) != -1){
//                String str = new String(buffer, 0, len);
//                System.out.print(str);
//            }
            //4、读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len = 0;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5、资源的关闭
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
