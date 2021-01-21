package cn.hutool.core.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdcardUtilDemo {
    public static void main(String[] args) {
        // 身份证校验，支持18位、15位和港澳台的10位
        // 支持：10位（isValidCard10），15位（isValidCard15），18位（isValidCard18），香港（isValidHKCard），台湾（isValidTWCard）
        assertTrue(IdcardUtil.isValidCard("11010119900307299X"));
        assertTrue(IdcardUtil.isValidCard18("11010119900307299X"));
    }
}
