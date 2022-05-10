package com.atguigu.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-10-20:40
 */
public class PrintStreamTest {
    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            File file = new File("ASCII.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ps = new PrintStream(fos, true);

            if (ps != null){
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0){
                    System.out.println();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null){
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
