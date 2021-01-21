package cn.hutool.core.lang;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorDemo {
    public static void main(String[] args) {
        // null 空字符串
        assertTrue(Validator.isNull(null));
        assertTrue(Validator.isNotNull("daodaotest"));
        assertTrue(Validator.isEmpty(""));
        assertTrue(Validator.isNotEmpty("daodaotest"));
        // 布尔
        assertTrue(Validator.isTrue(true));
        assertTrue(Validator.isFalse(false));
        // 相等
        assertTrue(Validator.equal("daodaotest", "daodaotest"));

        // 是否汉字，包含汉字
        assertTrue(Validator.hasChinese("daodaotest叨叨软件测试"));
        assertTrue(Validator.isChinese("叨叨软件测试"));
        // 是否为数字
        assertTrue(Validator.isNumber("1.1"));
        // 检查给定的数字是否在指定范围内
        assertTrue(Validator.isBetween(1, 1, 1));
        // 是否字母，包括大写和小写字母
        assertTrue(Validator.isWord("daodaotest"));
        // 是否为英文字母 、数字和下划线， 还支持：大写和小写字母和汉字（isLetter）
        assertTrue(Validator.isGeneral("dao_1"));
        // 是否全为大写或小写字母
        assertTrue(Validator.isLowerCase("daodaotest"));
        assertTrue(Validator.isUpperCase("DAODAOTEST"));

        // 生日
        assertTrue(Validator.isBirthday("20200830"));
        // 18位 身份证号格式校验，已经提 PR，改为调用 IdcardUtil 的方法，估计5.4.1 版本更新
        assertTrue(Validator.isCitizenId("11010119900307299X"));

        // 统一社会信用代码（营业执照注册号）
        assertTrue(Validator.isCreditCode("91350500676532779B"));
        // 中国车牌号
        assertTrue(Validator.isPlateNumber("京A88888"));
        // 邮编
        assertTrue(Validator.isZipCode("100000"));
        // uuid
        assertTrue(Validator.isUUID(UUID.randomUUID().toString()));
        // 手机号
        assertTrue(Validator.isMobile("13888888888"));
        // url
        assertTrue(Validator.isUrl("http://www.baidu.com"));
        // email
        assertTrue(Validator.isEmail("dao@test.com"));
        // ip
        assertTrue(Validator.isIpv4("192.168.1.1"));
        assertTrue(Validator.isIpv6("CDCD:910A:2222:5498:8475:1111:3900:2020"));

        // 正则表达式
        assertTrue(Validator.isMatchRegex("^d.*t$", "daodaotest"));
    }
}
