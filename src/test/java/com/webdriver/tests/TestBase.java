package com.webdriver.tests;

// *********************************************************
//  Atlassian automation exercise webdriver tests
// *********************************************************

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

    WebDriver d;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        String siteUrl = "https://<Insert Confluence Cloud instance Domain Name here>.atlassian.net/wiki";
        d = new ChromeDriver();
        d.manage().window().setSize(new Dimension(1200, 850));
        d.navigate().to(siteUrl);
    }

    @After
    public void tearDownTest() {
        d.quit();
    }

}
