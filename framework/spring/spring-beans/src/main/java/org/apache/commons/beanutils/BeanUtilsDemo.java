package org.apache.commons.beanutils;

import org.apache.commons.beanutils.entity.Person1;
import org.apache.commons.beanutils.entity.Person2;
import org.springframework.beans.BeanUtils;

/**
 * BeanUtils工具类使用Demo
 *
 */
public class BeanUtilsDemo {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.setName("tom");
        p1.setAge(8);

        Person2 p2 = new Person2();
        // 把Person1的参数值拷贝给Person2
        BeanUtils.copyProperties(p1, p2);

        System.out.println(p1);
        System.out.println(p2);
    }
}
