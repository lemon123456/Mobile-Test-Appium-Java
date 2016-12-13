package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Liang on 24/11/2016.
 */
public class LoginPage extends BasePage {
    @FindBy(id = "login_username")
    private WebElement usernameField;
    @FindBy(id = "login_pswd")
    private WebElement passwordField;
    @FindBy(id = "login_button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserInfo(String username, String password) {
        basicOperator.waitForElementVisible(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
