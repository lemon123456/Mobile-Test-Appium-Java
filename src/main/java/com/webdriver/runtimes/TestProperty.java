package com.webdriver.runtimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Liang on 24/11/2016.
 */
public class TestProperty {


    private static final String propPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

    public static String getProperty(String props, String key) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(propPath + props + ".properties");
            prop.load(is);
        } catch (Exception e) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return prop.getProperty(key);
    }
}
