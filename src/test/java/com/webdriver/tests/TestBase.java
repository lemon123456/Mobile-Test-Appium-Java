package com.webdriver.tests;

// *********************************************************
//  Atlassian automation exercise webdriver tests
// *********************************************************

import com.webdriver.runtimes.TestProperty;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        String siteUrl = TestProperty.getProperty("test", "url");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 850));
        driver.navigate().to(siteUrl);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

}
