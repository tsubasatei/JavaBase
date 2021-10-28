package com.xt.se.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xt
 * @Desc
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.size());
//        map.clear();
//        System.out.println(map);
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(2));
        Integer a = map.get("a");
        System.out.println(a);
        Integer a1 = map.remove("a");
        System.out.println(a1);
        System.out.println(map);

        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println(key + " - " + map.get(key));
        }

        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        map.put(null, null);
        map.put(null, 1);
        System.out.println(map);
    }
}
