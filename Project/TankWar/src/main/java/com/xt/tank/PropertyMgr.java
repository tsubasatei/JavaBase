package com.xt.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author xt
 * @Desc
 */
public class PropertyMgr {
    private static final PropertyMgr instance = new PropertyMgr();
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyMgr() {
    }

    public static PropertyMgr getInstance() {
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
