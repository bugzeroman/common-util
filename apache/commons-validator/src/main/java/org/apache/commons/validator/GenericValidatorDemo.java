package org.apache.commons.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericValidatorDemo {
    public static void main(String[] args) {
        // null 或 空断言
        assertTrue(GenericValidator.isBlankOrNull(""));
        assertTrue(GenericValidator.isBlankOrNull(null));

        // int，其他类型一样：byte,short，float，double，long
        assertTrue(GenericValidator.isInt("1"));
        // int 在指定范围内，其他类型一样：byte,short，float，double，long
        assertTrue(GenericValidator.isInRange(1, 0, 2));
        // int 最大最小，其他类型一样：float，double，long
        assertTrue(GenericValidator.minValue(1, 1));
        assertTrue(GenericValidator.maxValue(1, 1));

        // 日期
        assertTrue(GenericValidator.isDate("20200829", "yyyyMMdd", true));
        // 字符串 最大最小长度
        assertTrue(GenericValidator.maxLength("daodaotest", 10));
        assertTrue(GenericValidator.minLength("daodaotest", 10));

        // 信用卡验证
        assertTrue(GenericValidator.isCreditCard("6227612145830440"));
        // url
        assertTrue(GenericValidator.isUrl("http://www.baidu.com"));
        // email
        assertTrue(GenericValidator.isEmail("dao@test.com"));

        // 正则表达式
        assertTrue(GenericValidator.matchRegexp("daodaotest", "^d.*t$"));
    }
}
