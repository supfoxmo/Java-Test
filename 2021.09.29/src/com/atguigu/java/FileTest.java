package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * 1、File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2、File类声明在java.io包下
 * 3、File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作 。如果需要读取或写入文件内容，必须使用IO流来完成
 * 4、后续File类的对象常会作为参数传递到流的构造器中，指名读取或写入的终点。
 *
 *
 * @author lixhui
 * @create 2021-09-10:21
 */
public class FileTest {
    @Test
    public void test1(){
//        1、如何创建File类的对象
             //① File(String filePath);
             //② File(String parentPath,String childPath);
             //③ File(File parentPath,String childPath);

        //构造器一：
        //相对路径：相较于某个路径下，指名的路径
        File file = new File("hello.txt");//相对于当前module下
        //绝对路径：包含盘符在内的文件或文件目录的路径
        File file1 = new File("D:\\javacode\\workspace_idea1\\JavaSenior\\2021.09.29");
//        2、路径分割符：
        //window：\\
        //unix:/

        System.out.println(file);
        System.out.println(file1);

        //构造器二：
        File file2 = new File("D:\\javacode\\workspace_idea1", "JavaSenior");
        System.out.println(file2);
        //构造器三：
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);

    }

    /*
     * 1、public String getAbsolutePath():获取绝对路径
     * 2、public String getPath():获取路径
     * 3、public String getname():获取名称
     * 4、public String getParent():获取上层文件目录路径。若无，返回null
     * 5、public long length():获取文件长度(即：字节数)。不能 获取目录的长度
     * 6、public long lastModified():获取最后一次的修改时间(毫秒值)
     * 如下两个方法适用于文件目录：
     * 7、public String[] list():获取指定目录下所有文件或者文件目录的名称数组
     * 8、public File[] listFiles():获取指定目录下所有文件或者文件目录的File数组
     *
     */

    @Test
    public void test2(){
        File file = new File("hello.txt");
        File file1 = new File("D:\\javacode\\io\\hi.txt");

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
        System.out.println(file.list());
        System.out.println(file.listFiles());

        System.out.println("*********************************");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println(file1.list());
        System.out.println(file1.listFiles());
    }

    @Test
    public void test3(){
        File file = new File("D:\\javacode\\workspace_idea1\\JavaSenior");

        String[] listName = file.list();
        for (String s : listName){
            System.out.println(s);
        }
        System.out.println("********************************");
        File[] listFiles = file.listFiles();
        for (File f : listFiles){
            System.out.println(f);
        }
    }


    /*
     * 9、public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * 比如：file1.renameTo(file2)为例
     *     想要保证结果返回ture，需要file1在硬盘中存在，且file2不能在硬盘中存在
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\javacode\\workspace_idea1\\io\\hi.txt");

        boolean result = file1.renameTo(file2);
        System.out.println(result);

    }

    /*
     * 10、public boolean isDirectory():判断是否是文件目录
     * 11、public boolean isFile():判断是否是文件
     * 12、public boolean exists():判断是否存在
     * 13、public boolean canRead():判断受否可读
     * 14、public boolean canWrite():判断是否可写
     * 15、public boolean isHidden():判断是否隐藏
     *
     */

    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println("********************************");

        file1 = new File("hello1.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println("********************************");

        File file2 = new File("D:\\javacode\\workspace_idea1\\io");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /*
     *    一、创建硬盘中对应的文件或目录：
     * 16、public boolean createNewFile():创建文件。若文件存在，则不创建，返回false
     * 17、public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     * 18、public boolean mkdirs():创建文件目录。如果上层文件目录不存在，则一并创建。
     *    二、删除磁盘中的文件或文件目录：
     * 19、public boolean delete():删除文件或者文件夹
     *     删除注意事项：java中的删除不走回收站。
     */

    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        //创建文件
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            System.out.println("文件已存在，创建失败");
        }
        System.out.println(file);//hi.txt

        //删除文件
        if (file.delete()){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void test(){
        //1、创建文件目录
        File file1 = new File("D:\\javacode\\workspace_idea1\\io\\iotest1");

        if (file1.mkdir()) {
            System.out.println("文件目录iotest1创建成功");
        }else {
            System.out.println("文件目录iotest1创建失败");
        }

        File file2 = new File("D:\\javacode\\workspace_idea1\\io\\iotest2");

        if (file2.mkdirs()) {
            System.out.println("文件目录iotest2创建成功");
        }else {
            System.out.println("文件目录iotest2创建失败");
        }

        System.out.println("*************************************");
        File file3 = new File("D:\\javacode\\workspace_idea1\\io\\iotest3\\helloworld");

        if (file3.mkdir()) {
            System.out.println("文件目录iotest3\\helloworld创建成功");
        }else {
            System.out.println("文件目录iotest3\\helloworld创建失败");
        }

        if (file3.mkdirs()) {
            System.out.println("文件目录iotest3\\helloworld创建成功");
        }else {
            System.out.println("文件目录iotest3\\helloworld创建失败");
        }

    }


}
