package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class JsonUtilsReader {

    private static Properties localConfig = null;

    public static JSONObject readFromJsonBody(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            Object object = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) object;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static void setBrowser() {
        String configuration = "configuration.properties";

        try (FileInputStream fileInputStream = new FileInputStream(configuration)) {
            localConfig = new Properties();
            localConfig.load(fileInputStream);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperties(String key) {
        if (localConfig == null) {
            setBrowser();
        }
        return localConfig.getProperty(key);
    }
}






