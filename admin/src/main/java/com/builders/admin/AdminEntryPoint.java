package com.builders.admin;


import com.builders.services.BuilderService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class AdminEntryPoint {

    public static void main(String[] args) {
        String helloFromService = new BuilderService().sayHello();
        InputStream stream = AdminEntryPoint.class.getClassLoader().getResourceAsStream("admin_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String hello = properties.getProperty("hello");
        System.out.println("You say " + Arrays.deepToString(args) + ", I say " + hello + " " + helloFromService);
    }

}
