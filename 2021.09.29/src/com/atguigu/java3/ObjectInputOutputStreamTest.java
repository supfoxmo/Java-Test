package com.atguigu.java3;

import org.junit.Test;

import java.io.*;

/**
 * @author lixhui
 * @create 2021-10-23:03
 *
 *
 * 对象流的使用：
 * 1、ObjectInputStream和ObjectOutputStream
 * 2、作用：用于储存和读取基本数据类型和对象的处理流。强大之处就是可以把Java中的对象写入到数据原中，也能把对象从数据源中还原回来
 * 3、序列化：用ObjectOutputStream类保存基本数据类型或对象的机制。(将内存中的Java对象保存到磁盘中或通过网络传输出去)
 *    反序列化：用ObjectInputStream类读取基本数据类型或对象的机制。(将磁盘文件中的对象或网络传输过来的对象还原为内存中的一个java对象)
 * 4、
 */
public class ObjectInputOutputStreamTest {
    @Test
    public void test(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));

            person zhouyini = new person("zhouyini", false, 19);
            oos.writeObject(zhouyini);
            oos.flush();
            oos.writeUTF("喜羊羊与灰太狼");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("object.dat")));

            Object o = ois.readObject();
            person p1 = (person) o;
            System.out.println(p1);

            String str = ois.readUTF();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
