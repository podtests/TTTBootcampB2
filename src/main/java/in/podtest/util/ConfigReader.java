package in.podtest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties = new Properties();

    //src/main/resources/config.properties
    public static void loadProperty(String filePath) {

        File file = new File(filePath);
        FileInputStream fileInputStream = null;

        try {
             fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String propName){

        return properties.getProperty(propName);

    }

}
