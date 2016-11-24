package com.webdriver.runtimes;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by twe on 24/11/2016.
 */
public class BasicOperator {
    private WebDriver driver;
    private Long timeout = Long.parseLong(TestProperty.getProperty("test", "timeout"));

    public BasicOperator(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public Object waitForScript(String script, Predicate<Object> checker) {
        return this.waitForScript(script, checker, timeout, "Some errors happen.");
    }

    public Object waitForScript(String script, Predicate<Object> checker, Long timeout, String error_template) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long start = System.currentTimeMillis();
        Object value = "";
        while (System.currentTimeMillis() - start < timeout * 1000) {
            value = js.executeScript(script);
            if (checker == null) {
                return value;
            }
            if (checker.test(value)) {
                return value;
            }
        }
        throw new AssertionError(String.format(error_template, value));
    }

    public void switchFrame(String frame) {
        if (frame == "default") {
            driver.switchTo().defaultContent();
        } else {
            driver.switchTo().frame(frame);
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
