package cn.hutool.core.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReUtilDemo {
    public static void main(String[] args) {
        assertTrue(ReUtil.isMatch("\\w\\d", "m2"));
        assertFalse(ReUtil.isMatch("\\w\\d", "mn"));
    }
}
