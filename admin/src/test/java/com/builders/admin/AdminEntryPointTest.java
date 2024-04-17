package com.builders.admin;

import com.builders.utils.BuildersUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AdminEntryPointTest {

    @Test
    public void testHello() {
        InputStream stream = BuildersUtil.class.getClassLoader().getResourceAsStream("admin_config_test.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(properties.getProperty("test_hello"));
    }

}
