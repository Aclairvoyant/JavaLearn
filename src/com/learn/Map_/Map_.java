package com.learn.Map_;

import java.util.*;

public class Map_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("1", 11);
        map.put("2", 22);
        map.put("3", 33);
        map.put(null, null);

        //先取出key，再通过key找到value
        Set keyset = map.keySet();
        for (Object ks : keyset) {
            System.out.println(ks + "-" + map.get(ks));
        }
        System.out.println("==================");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        //把所有的value取出
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

        //通过EntrySet来获取k-v
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            //将entry向下转型map.entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}
