package com.google.common.collect;

import java.util.Map.Entry;

/**
 *  一个Key可以对应多个Value的数据结构，
 *用于替代类似Map<String,List<String>>的数据结构，
 *避免了判断和新建List<String>的逻辑。
 *
 */
public class MultimapDemo {
    public static void main(String[] args) {
        // testArrayListMultimap();
        // testHashHashMultimap();
        testKeyAndValue();
    }

    /**
     * 1.类似Map<String,List<String>>数据结构
     */
    public static void testArrayListMultimap() {
        // 一个学生对应多个课程
        Multimap<String, String> name2SubjectsMap = ArrayListMultimap.create();
        name2SubjectsMap.put("tom", "Chinese");
        name2SubjectsMap.put("tom", "Math");
        name2SubjectsMap.put("tom", "Math");

        name2SubjectsMap.put("jerry", "Chinese");
        name2SubjectsMap.put("jerry", "English");

        System.out.println(name2SubjectsMap.get("tom"));
        System.out.println(name2SubjectsMap.get("jerry"));
    }

    /**
     * 2.类似Map<String,Set<String>>数据结构,value部分重复的会自动去重
     */
    public static void testHashHashMultimap() {
        Multimap<String, String> name2SubjectsMap = HashMultimap.create();
        name2SubjectsMap.put("tom", "Chinese");
        name2SubjectsMap.put("tom", "Math");
        name2SubjectsMap.put("tom", "Math");

        name2SubjectsMap.put("jerry", "Chinese");
        name2SubjectsMap.put("jerry", "English");

        System.out.println(name2SubjectsMap.get("tom"));
        System.out.println(name2SubjectsMap.get("jerry"));
    }

    /**
     * 3.对Multimap中的key和value进行迭代查看
     */
    public static void testKeyAndValue() {
        Multimap<String, String> name2SubjectsMap = ArrayListMultimap.create();
        name2SubjectsMap.put("tom", "Chinese");
        name2SubjectsMap.put("tom", "Math");
        name2SubjectsMap.put("tom", "Math");

        name2SubjectsMap.put("jerry", "Chinese");
        name2SubjectsMap.put("jerry", "English");

        // 1.查看所有key,不去重
        System.out.println("1.------------------------");
        for (String name : name2SubjectsMap.keys()) {
            System.out.println("name=" + name);
        }
        // 2.查看所有key，去重
        System.out.println("2.------------------------");
        for (String name : name2SubjectsMap.keySet()) {
            System.out.println("name=" + name);
        }
        // 3.查看所有value
        System.out.println("3.------------------------");
        for (String subject : name2SubjectsMap.values()) {
            System.out.println("subject=" + subject);
        }
        // 4.查看所有key和value对
        System.out.println("4.------------------------");
        for (Entry<String, String> name2Subjects : name2SubjectsMap.entries()) {
            System.out.println("name=" + name2Subjects.getKey() + ",subject=" + name2Subjects.getValue());
        }
    }

}
