package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-09-21:51
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提高流的读取、写入的速度
 * 提高读写速度的原因：内部提供里一个缓冲区
 *
 */
public class BufferedInputOutputTest {
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、造文件
            File srcFile = new File("微信图片_20210923201612.jpg");
            File destFile = new File("微信图片2_20210923201612.jpg");
            //2、造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len = 0;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            //要求：先关闭外层的流，在关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //说明：关闭外层的流的同时，内层的流也会自动关闭。故乃曾流的关闭，可以省略
//        fos.close();
//        fis.close();
    }

}
