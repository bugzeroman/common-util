package org.springframework.util;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.entity.Person;

/**
 * 反射工具类使用Demo
 *
 */
public class ReflectionUtilsDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("tom");
        p.setAge(8);

        // 通过反射获取字段的名称和值
        FieldCallback fc = new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
                Object value = ReflectionUtils.getField(field, p);
                System.out.println(field.getName() + "=" + value);
            }
        };
        ReflectionUtils.doWithFields(p.getClass(), fc);
    }
}
