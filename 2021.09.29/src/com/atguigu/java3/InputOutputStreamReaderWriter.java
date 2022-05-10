package com.atguigu.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-10-22:13
 */
public class InputOutputStreamReaderWriter {
    @Test
    public void test(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File srcFile = new File("ASCII.txt");
            File destFile = new File("ASCII_gbk");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

//            编码
            char[] cbuf = new char[10];
            int len = 0;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

//    译码
    @Test
    public void test1(){
        InputStreamReader isr = null;
        try {
            File file = new File("ASCII_gbk");
            FileInputStream fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"gbk");

            char[] cbuf = new char[10];
            int len = 0;
            while ((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
