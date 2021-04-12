package com.google.common.collect;

import java.util.List;

public class ListsDemo {
    // 分页大小
    private static final int PAGE_SIZE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        // guava工具对list进行拆分
        partitionList(list);
    }

    /**
     * 使用guava工具对list进行拆分分页
     */
    private static void partitionList(List<String> list) {
        // 分页拆分集合
        List<List<String>> pageList = Lists.partition(list, PAGE_SIZE);
        // 循环打印看看
        pageList.forEach(System.out::println);
    }

}
