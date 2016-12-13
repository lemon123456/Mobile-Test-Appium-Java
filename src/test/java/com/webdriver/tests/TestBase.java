package com.webdriver.tests;

import com.webdriver.runtimes.TestProperty;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class TestBase {

    WebDriver driver;

//    @BeforeClass
//    public static void setupClass() {
//        ChromeDriverManager.getInstance().setup();
//    }

    @Before
    public void setupTest() throws MalformedURLException {
        File appDir = new File("/Users/twer/Documents/Work/My PACD");
        File app = new File(appDir, "app-sit-debug.apkapp-sit-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

}
