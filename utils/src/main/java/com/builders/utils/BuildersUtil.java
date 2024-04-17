package com.builders.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuildersUtil {

    public static final String sayHello() {
        InputStream stream = BuildersUtil.class.getClassLoader().getResourceAsStream("utils_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("hello");
    }

}
