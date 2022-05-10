package com.atguigu.exer;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-10-15:14
 */
public class CopyPictureText {
//    public static void main(String[] args) {
//        String srcPath = new String("海贼王.png");
//        String destPath = new String("海贼王1.png");
//
//        CopyPictureText copyPictureText = new CopyPictureText();
//
//        copyPictureText.copyPicture(srcPath,destPath);
//
//    }

    @Test
    //图片的加密复制
    public void copyPicture(){
        BufferedInputStream bfr = null;
        BufferedOutputStream bfw = null;
        try {
            File srcfile = new File("海贼王.png");
            File destfile = new File("海贼王1.png");

            FileInputStream fr = new FileInputStream(srcfile);
            FileOutputStream fw = new FileOutputStream(destfile);

            bfr = new BufferedInputStream(fr);
            bfw = new BufferedOutputStream(fw);

            int len = 0;
            byte[] buffer = new byte[5];
            while ((len = bfr.read(buffer)) != -1){
                //加密操作：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                bfw.write(buffer,0,len);
            }
            System.out.println("图片加密复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfw != null)
                    bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bfr != null)
                    bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void copySrcPicture(){
        BufferedInputStream bfr = null;
        BufferedOutputStream bfw = null;
        try {
            File srcfile = new File("海贼王1.png");
            File destfile = new File("海贼王2.png");

            FileInputStream fr = new FileInputStream(srcfile);
            FileOutputStream fw = new FileOutputStream(destfile);

            bfr = new BufferedInputStream(fr);
            bfw = new BufferedOutputStream(fw);

            int len = 0;
            byte[] buffer = new byte[5];
            while ((len = bfr.read(buffer)) != -1){
                //加密操作：
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                bfw.write(buffer,0,len);
            }
            System.out.println("图片加密复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bfw != null)
                    bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bfr != null)
                    bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
