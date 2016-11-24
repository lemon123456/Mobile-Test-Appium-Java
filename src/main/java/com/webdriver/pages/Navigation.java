package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation extends BasePage {

    @FindBy(id = "quick-create-page-button")
    private WebElement quickCreateButton;
    @FindBy(id = "create-page-button")
    private WebElement createButton;
    @FindBy(id = "user-menu-link")
    private WebElement navMenuLink;
    @FindBy(id = "logout-link")
    private WebElement logoutLink;
    @FindBy(id = "logout")
    private WebElement logoutButton;
    @FindBy(id = "admin-menu-link")
    private WebElement adminMenuLink;
    @FindBy(id = "admin-management-link")
    private WebElement userManagementLink;
    @FindBy(xpath = "(/html//li[@class=\"grouping RecentlyUpdatedContent_grouping_1vX\"]/div/ul/li/div/div/a)[2]")
    private WebElement existingPage;
    @FindBy(css = "button:contains('Return to log in page')")
    private WebElement returnLoginPageLink;

    public Navigation(WebDriver driver) {
        super(driver);
    }

    public void navigateToUserManagement() {
        adminMenuLink.click();
        userManagementLink.click();
    }

    public void selectQuickCreateButton() {
        WebElement quickButton = basicOperator.waitForElementClickable(quickCreateButton);
        quickButton.click();
    }

    public void selectCreateButton() {
        createButton.click();
    }

    public void openExistingPage() {
        WebElement existingPg = basicOperator.waitForElementClickable(existingPage);
        existingPg.click();
    }

    public void logOut() {
        navMenuLink.click();
        logoutLink.click();
        logoutButton.click();
        returnLoginPageLink.click();
    }
}
