package com.atguigu.java.exer;

import java.util.Iterator;
import java.util.List;

/**
 * @author lixhui
 * @create 2021-09-9:02
 */
public class DAOTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(21);
        user.setId(20211005);
        user.setName("weijin");

        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(20211001,21,"weijin"));
        dao.save("1002",new User(20211002,27,"lixhui"));
        dao.save("1003",new User(20211003,18,"zhouyini"));
        dao.save("1004",new User(20211004,24,"mahailin"));
        dao.save("1005",user);

        List<User> list = dao.list();

        Iterator<User> iterator = list.iterator();

//      集合遍历方式一：
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }

        System.out.println("****************************************************");
        dao.update("1005",new User(20211005,20,"wukai"));
        User user1 = dao.get("1005");
        System.out.println("\n" + user1 + "\n");

        List<User> list1 = dao.list();

//      集合遍历方式二：
        list1.forEach(System.out :: println);

//        System.out.println("****************************************************");
//        System.out.println(list);

        System.out.println("****************************************************");
        dao.delete("1004");

        List<User> list2 = dao.list();

//      集合遍历方式二：
        list2.forEach(System.out :: println);

    }

}
