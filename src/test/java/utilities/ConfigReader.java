package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    static {
        String path="configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties=new Properties();
            properties.load(file);
            file.close();
        }catch (Exception e) {
            System.out.println("Configuration file is not exist");
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
