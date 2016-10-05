package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlankPage {

    private WebDriver driver;
    @FindBy(id = "content-title")
    private WebElement titleBar;
    @FindBy(id = "tinymce")
    private WebElement contentBody;
    @FindBy(id = "rte-button-publish")
    private WebElement saveButton;

    public BlankPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillTitleBar(String title) {
        titleBar.click();
        titleBar.sendKeys(title);
    }

    public void fillBody(String body) {
        contentBody.click();
        contentBody.sendKeys(body);
    }

    public void selectSaveButton() {
        saveButton.click();
    }
}
