package com.atguigu.java4;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-09-21:01
 *
 *
 * 结论：
 * 1、对于文本文件（.txt, .java, .c, .cpp），使用字符流处理
 * 2、对于非文本文件（.jpg, .mp3, .mp4, .avi, .doc, .ppt...）,使用字节流处理
 *
 */
public class FileInputOutputStreamTest {
    @Test
    public void test1(){
        FileInputStream ips = null;
        FileOutputStream ops = null;
        try {
            File srcfile = new File("微信图片_20210923201612.jpg");
            File destfile = new File("微信图片1_20210923201612.jpg");

            ips = new FileInputStream(srcfile);
            ops = new FileOutputStream(destfile);

            byte[] buffer = new byte[5];
            int len = 0;
            while ((len = ips.read(buffer)) != -1) {
                ops.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ips != null)
                    ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ops != null)
                    ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //指定路径下的文本复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream ips = null;
        FileOutputStream ops = null;
        try {
            File srcfile = new File(srcPath);
            File destfile = new File(destPath);

            ips = new FileInputStream(srcfile);
            ops = new FileOutputStream(destfile);

            byte[] buffer = new byte[5];
            int len = 0;
            while ((len = ips.read(buffer)) != -1) {
                ops.write(buffer,0,len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ips != null)
                    ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ops != null)
                    ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test3(){

    }
}
