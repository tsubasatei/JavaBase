package v1;

import java.io.IOException;
import java.util.Properties;

/**
 * @author xt
 * @Desc
 */
public class PropertyMgr {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static String getString(String key) {
        return properties.getProperty(key);
    }

    public static Object get(String key) {
        return properties.getProperty(key);
    }
}
