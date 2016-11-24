package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlankPage extends BasePage {

    @FindBy(id = "content-title")
    private WebElement titleBar;
    @FindBy(id = "tinymce")
    private WebElement contentBody;
    @FindBy(id = "rte-button-publish")
    private WebElement saveButton;

    public BlankPage(WebDriver driver) {
        super(driver);
    }

    public void fillTitleBar(String title) {
        WebElement titleField = basicOperator.waitForElementClickable(titleBar);
        titleField.sendKeys(title);
    }

    public void fillBody(String body) {
        WebElement bodyField = basicOperator.waitForElementClickable(contentBody);
        bodyField.sendKeys(body);
    }

    public void switchFrame(String frameName) {
        basicOperator.switchFrame(frameName);
    }

    public void selectSaveButton() {
        saveButton.click();
    }
}
