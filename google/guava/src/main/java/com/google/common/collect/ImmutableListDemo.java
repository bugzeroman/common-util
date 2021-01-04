package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Google提供的不变集合类，与JDK提供的不变集合类的区别
 *
 */
public class ImmutableListDemo {
    public static void main(String[] args) {
        List<String> originList = new ArrayList<>();
        originList.add("a");
        originList.add("b");
        originList.add("c");

        List<String> jdkList = Collections.unmodifiableList(originList);
        ImmutableList<String> googleList = ImmutableList.copyOf(originList);

        originList.add("e");
        // 不可变类无法添加元素，下面的代码抛出异常UnsupportedOperationException
        // jdkList.add("e");
        // googleList.add("e");

        print(originList);
        print(jdkList);
        print(googleList);
    }

    private static void print(List<String> list) {
        System.out.println(list);

    }
}
