package org.springframework.core.io.support;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

/**
 * Properties文件工具类使用Demo
 *
 */
public class PropertiesLoaderUtilsDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "test.properties";
        EncodedResource resource = new EncodedResource(new ClassPathResource(fileName), StandardCharsets.UTF_8);
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        // 读取greet对应的值
        String key = "greet";
        String value = properties.getProperty(key);
        System.out.println(key + "=" + value);
    }
}
