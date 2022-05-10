package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixhui
 * @create 2021-10-21:19
 *
 * TCP的网络编程
 * 例题三：从客户端发送文件给服务端，服务端保存到本地。
 * 并返回 “发送成功 ” 给客户端。并关闭相应的连接
 */
public class TCPTest2 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 60000);

            os = socket.getOutputStream();

            fis = new FileInputStream(new File("gangtiexia.jpg"));

            int len = 0;
            byte[] buffer = new byte[10];
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0, len);
            }
            //关闭数据的输出
            socket.shutdownOutput();

            //接收来自服务器端的数据，并显示在控制台上
            is = socket.getInputStream();

            baos = new ByteArrayOutputStream();

            int len1 = 0;
            byte[] buffer1 = new byte[1024];
            while ((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0, len1);
            }
            System.out.println(baos.toString());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(60000);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("gangtiexia2.jpg"));

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

            //服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write("照片我已经接收到，非常的酷！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
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
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
