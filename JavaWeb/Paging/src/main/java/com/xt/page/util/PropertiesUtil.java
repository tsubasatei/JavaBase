package com.xt.page.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author xt
 * @Desc
 */
public class PropertiesUtil {
    private Properties properties = new Properties();

    public PropertiesUtil(String path) {
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String key) {
        return (String) properties.get(key);
    }
}
