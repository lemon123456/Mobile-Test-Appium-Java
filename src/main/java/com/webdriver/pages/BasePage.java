package com.webdriver.pages;

import com.webdriver.runtimes.BasicOperator;
import org.openqa.selenium.WebDriver;

/**
 * Created by Liang on 24/11/2016.
 */
public class BasePage {
    protected BasicOperator basicOperator;

    public BasePage(WebDriver driver) {
        this.basicOperator = new BasicOperator(driver);
    }
}
