package com.atguigu.java4;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lixhui
 * @create 2021-09-14:53
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsoluteFile());//D:\javacode\workspace_idea1\JavaSenior\hello.txt

        File file2 = new File("2021.09.29\\hello.txt");
        System.out.println(file2.getAbsoluteFile());//D:\javacode\workspace_idea1\JavaSenior\2021.09.29\hello.txt
    }

//    将2021.09.29下的hello.txt文件内容读入程序中，并输入到控制台
    //1. read()的理解：返回读入的一个字符。如果达到文件的末尾，返回-1
    //2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    //3. 读入的文件一定要存在，否则就会报异常：FileNotFroundException
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指定要操作的文件
            File file1 = new File("hello.txt");
            //2.提供具体的流
            fr = new FileReader(file1);
            //3.数据的读取
            //read():返回读入的一个字符。如果达到文件的末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二：
            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.流的关闭操作
                if (fr != null){
                   fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    raed(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到末尾，返回-1

    @Test
    public void test2(){
        FileReader fr = null;
        try {
            File file1 = new File("hello.txt");
            fr = new FileReader(file1);
            int len = 0;
            char[] cbuf = new char[5];

            while ((len = fr.read(cbuf)) != -1){
                //方式一：
//                for (int i =0;i < len;i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//    从内存中写出数据到硬盘的文件里
    // 1.输出操作，对应的File可以不存在的。并不会报异常
    // 2.File对应的硬盘中的文件如果不存在，在输出过程中，会自动创建此文件。
    //   File对应的硬盘中的文件如果不存在:
    //          如果流使用的构造器是：FileWriter(file,false)/FileWriter():对原有文件进行覆盖操作
    //          如果流使用的构造器是：FileWriter(file,true):不会对原有文件进行覆盖，而是在原有文件商进行追加
    @Test
    public void test3(){
        FileWriter fw1 = null;
        FileWriter fw2 = null;
        try {
            File file = new File("hello1.txt");
            fw1 = new FileWriter(file, false);
            fw2 = new FileWriter(file, true);
            fw1.write("I have a dream!\n");
            fw1.write("you need to have a dream!\n");
            fw2.write("I am lixhui.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw1 != null)
                    fw1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw2 != null)
                    fw2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file1 = new File("hello1.txt");
            File file2 = new File("hello2.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            int len = 0;
            char[] cbuf = new char[5];
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

}
