package com.atguigu.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-10-20:50
 */
public class DataInputOutputStreamTest {
    @Test
    public void test(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File("Data.txt")));

            dos.writeUTF("zhouyini");
            dos.flush();//刷心操作，将内存中已有的数据写入文件中
            dos.writeBoolean(false);
            dos.flush();
            dos.writeInt(19);
            dos.flush();
            dos.writeUTF("she was marry");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(new File("Data.txt")));
//      读入的顺序必须和写出的顺序相同
            String name = dis.readUTF();
            boolean sex = dis.readBoolean();
            int age = dis.readInt();
            String desrign = dis.readUTF();

            System.out.println("name = " + name);
            System.out.println("sex = " + sex);
            System.out.println("age = " + age);
            System.out.println(desrign);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
