package org.apache.commons.lang3;

/**
 * 数组工具类
 *
 */
public class ArrayUtilsDemo {
    public static void main(String[] args) {

        // 判断数组是否为空
        String[] array = null;
        boolean result = ArrayUtils.isEmpty(array);
        System.out.println(array + "=" + result);

        array = new String[] {};
        result = ArrayUtils.isEmpty(array);
        System.out.println(array + "=" + result);

        array = new String[] { "a", "b" };
        result = ArrayUtils.isEmpty(array);
        System.out.println(array + "=" + result);
    }
}
