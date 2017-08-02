/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.sort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 所谓遍历(Traversal)，是指沿着某条搜索路线，依次对树中每个结点均做一次且仅做一次访问
 * List特点：集合中的元素有顺序，可以重复，而存储同一类的元素才采用它。
 * Set特点：无序不重复的元素集合
 * Map特点：键值对元素集合，可以有序，也可以无序
 * @author wxh
 * @version $Id: ListSort.java, v 0.1 2017年7月14日 下午2:55:02 wxh Exp $
 */
public class CollectionAndMapTraversal {

    public static void main(String[] args) {
        // 遍历List
        traversalList();
        System.out.println("-------------------华丽分割线-------------------------");
        // 遍历map
        traversalMap();
    }

    public static void traversalList() {
        List<String> list = new LinkedList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("xiaoliu");

        for (int i = 0; i < list.size(); i++) {
            String index = list.get(i);
            System.out.println(index);
        }
        System.out.println("------------for each-------------");
        for (String index : list) {
            System.out.println("foreach: " + index);
        }
    }

    /**
     * 1.HashMap不是有序的；
     * 2.TreeMap和LinkedHashMap是有序的（TreeMap默认升序，LinkedHashMap则记录了插入顺序）
     *
     */
    public static void traversalMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "11111");
        map.put("2", "22222");
        map.put("3", "33333");
        map.put("4", "44444");
        map.put("5", "55555");

        // 1.Entry<String, Object> 遍历
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key:" + key + " , " + value);
        }
        System.out.println("---------Entry<String, Object>遍历---------------------");

        // 2.entrySet 迭代遍历
        Iterator setIterator = map.entrySet().iterator();
        while (setIterator.hasNext()) {
            Map.Entry<String, Object> entryMap = (Entry<String, Object>) setIterator.next();
            System.out.println("iterator key:" + entryMap.getKey() + " , " + entryMap.getValue());
        }
        System.out.println("-------------entrySet iterator遍历----------------------");

        // 3.keySet 迭代遍历
        Iterator keySetIterator = map.keySet().iterator();
        while (keySetIterator.hasNext()) {
            String key = (String) keySetIterator.next();
            Object value = map.get(key);
            System.out.println("keySet key:" + key + " , " + value);
        }
        System.out.println("-------------keySet iterator遍历------------------------");

        // 4. values 遍历
        for (String key : map.keySet()) {
            System.out.println("key: " + key);
        }
        for (Object value : map.values()) {
            System.out.println("value: " + value);
        }

        System.out.println("---------------values遍历-------------------------------");

    }
}
