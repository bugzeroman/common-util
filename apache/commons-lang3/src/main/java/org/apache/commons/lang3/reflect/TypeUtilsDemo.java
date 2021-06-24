package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;

/**
 * 反射Type相关的工具类
 *
 */
public class TypeUtilsDemo {
    public static void main(String[] args) {
        // List的Field类型
        Object obj = new Object() {
            List<String> list = new ArrayList<>();
        };
        Class<?> clazz = obj.getClass();
        Field[] felds = clazz.getDeclaredFields();
        for (Field field : felds) {
            Class<?> fieldType = field.getType();

            // 是否是List
            boolean isList = ClassUtils.isAssignable(List.class, fieldType);
            if (isList) {
                Type genericType = field.getGenericType();
                System.out.println(genericType);
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType pType = (ParameterizedType) genericType;
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(pType);
                    for (Type type : typeArguments.values()) {
                        if (type instanceof Class) {
                            // 获得List内部的泛型类型
                            Class<?> typeClass = (Class<?>) type;
                            System.out.println(typeClass);
                        }
                    }
                }
            }
        }
    }
}
