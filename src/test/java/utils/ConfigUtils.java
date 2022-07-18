package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {

    public static String getProperty(String key) {
        String url = "configuration.properties";

        try (FileInputStream fileInputStream = new FileInputStream(url)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("file not found");
    }

}
