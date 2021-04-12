package com.google.common.collect;

import java.util.Collections;
import java.util.List;

/**
 * 流畅风格比较器
 */
public class OrderingDemo {
    public static void main(String[] args) {
        // sortString();
        sortInteger();
    }

    public static void sortInteger() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Ordering<Integer> strOrder = Ordering.natural();
        Collections.sort(list, strOrder);
        System.out.println(list);
    }

    public static void sortString() {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        Ordering<String> strOrder = Ordering.natural();
        Collections.sort(list, strOrder);
        System.out.println(list);
    }
}
