package org.springframework.util;

import java.math.BigInteger;

/**
 * Class工具类使用Demo
 *
 */
public class ClassUtilsDemo {
    public static void main(String[] args) {
        // 基本数据类型
        isPrimitive("void.class", void.class);

        isPrimitive("boolean.class", boolean.class);
        isPrimitive("byte.class", byte.class);
        isPrimitive("char.class", char.class);

        isPrimitive("short.class", short.class);
        isPrimitive("int.class", int.class);
        isPrimitive("long.class", long.class);

        isPrimitive("float.class", float.class);
        isPrimitive("double.class", double.class);
        System.out.println();

        // 基本包装类型
        isPrimitive("Void.class", Void.class);

        isPrimitive("Boolean.class", Boolean.class);
        isPrimitive("Byte.class", Byte.class);
        isPrimitive("Character.class", Character.class);

        isPrimitive("Short.class", Short.class);
        isPrimitive("Integer.class", Integer.class);
        isPrimitive("Long.class", Long.class);

        isPrimitive("Float.class", Float.class);
        isPrimitive("Double.class", Double.class);
        System.out.println();

        // 非基本数据类型
        isPrimitive("BigInteger.class", BigInteger.class);
        isPrimitive("String.class", String.class);
        isPrimitive("Class.class", Class.class);
    }

    /**
     * 判断基本数据类型以及基本包装类型
     */
    public static void isPrimitive(String name, @SuppressWarnings("rawtypes") Class clazz) {
        boolean result = ClassUtils.isPrimitiveOrWrapper(clazz);
        System.out.println(name + "=" + result);
    }
}
