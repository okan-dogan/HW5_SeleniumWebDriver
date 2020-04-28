package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties configFile;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    public static String getProperty(String keyValue){
        return configFile.getProperty(keyValue);
    }


}
