package org.apache.commons.validator.routines;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * IP地址校验工具类
 * @author yuwen
 *
 */
public class InetAddressValidatorDemo {
    public static void main(String[] args) {
        InetAddressValidator inetAddressValidator = InetAddressValidator.getInstance();
        String ipv4 = "192.168.1.255";
        String ipv6 = "CDCD:910A:2222:5498:8475:1111:3900:2020";
        // 可以校验IPv4
        assertTrue(inetAddressValidator.isValidInet4Address(ipv4));

        // 可以校验IPv6
        assertTrue(inetAddressValidator.isValidInet6Address(ipv6));

        // 可以校验IPv4或者IPv6
        assertTrue(inetAddressValidator.isValid(ipv4));
        assertTrue(inetAddressValidator.isValid(ipv6));
    }
}
