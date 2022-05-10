package com.atguigu.java.exer;

import java.util.*;

/**
 * @author lixhui
 * @create 2021-09-23:30
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    //保存 T类型的对象到 Map成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从 map中获取 id 对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替代 map 中 key 为 id 的内容，改为 entity 对象
    public void update(String id,T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }
    //返回 map 中存放的所有 T 对象
    public List<T> list(){
        Collection<T> values = map.values();
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : values){
            arrayList.add(t);
        }
        return arrayList;
    }
    //删除指定 id 对象
    public void delete(String id){
        map.remove(id);
    }

}
