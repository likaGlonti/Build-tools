package com.builders.services;

import com.builders.utils.BuildersUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuilderService {

    public String sayHello() {
        InputStream stream = BuilderService.class.getClassLoader().getResourceAsStream("service_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String hello = properties.getProperty("hello");
        String helloFromUtils = BuildersUtil.sayHello();
        return hello + " " + helloFromUtils;
    }

}
