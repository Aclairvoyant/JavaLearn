package com.learn.Exercise;

import java.util.*;

public class HashMap01 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 1200);
        m.put("tom", 650);
        m.put("smith", 2900);
        System.out.println(m);

        Set keySet = m.keySet();
        for (Object o : keySet) {
            m.put(o, (Integer) m.get(o) + 100);
            System.out.println(m.get(o));
        }

        Collection values = m.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getValue());

        }

    }
}
