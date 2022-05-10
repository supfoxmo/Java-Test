package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-09-22:33
 */
public class BufferedReaderWriterTest {
    @Test
    public void test(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));
            //方式一：使用char[]数组
//            int len = 0;
//            char[] cbuffer = new char[5];
//            while ((len = br.read(cbuffer)) != -1){
//                bw.write(cbuffer,0,len);
//            }
            //方式二：使用String
            //BufferedReader中的readline():读取文本文件中一整行的数据
            String data;
            while ((data = br.readLine()) != null){
                //方法一：
//                bw.write(data);//data中不包含换行符号\n
                //方法二：
                bw.write(data);//data中不包含换行符号\n
                bw.newLine();//提供换行操作
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
