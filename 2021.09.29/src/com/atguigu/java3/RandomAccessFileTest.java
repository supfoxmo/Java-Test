package com.atguigu.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author lixhui
 * @create 2021-10-10:03
 *
 * RandomAccessFile的使用：
 * 1、RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2、RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3、如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *    如果写出的文件存在，则会对原有的文件内容进行覆盖(默认从文件头开始覆盖)
 */
public class RandomAccessFileTest {
    @Test
    public void test(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("海贼王2.png"), "r");
            raf2 = new RandomAccessFile(new File("海贼王3.png"), "rw");

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("hello.txt"), "rw");

            raf.seek(11);//将指针调到角标为11的位置
            raf.write("2021-10-8".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
     * 4、使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");

            raf.seek(11);
            //保存指针11后面的所有数据到StringBuiler中
            StringBuilder Builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[10];
            int len = 0;
            while ((len = raf.read(buffer)) != -1){
                Builder.append(new String(buffer,0,len));
            }
            //返回指针，写出要插入的数据
            raf.seek(11);
            raf.write("2021-10-8".getBytes());
            //将StringBuider中的数据写到文件中
            raf.write(Builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
