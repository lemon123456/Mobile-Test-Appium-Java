package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestrictionsDialog extends BasePage {

    @FindBy(className = "select2-arrow")
    private WebElement restrictionArrow;
    @FindBy(css = "button#page-restrictions-dialog-save-button.aui-button")
    private WebElement applyButton;
    @FindBy(id = "page-restrictions-dialog-close-button")
    private WebElement cancelLink;
    @FindBy(xpath = "//li[@class='select2-search-field']/input[@type='text']")
    private WebElement searchTextField;
    @FindBy(id = "page-restrictions-add-button")
    private WebElement addButton;
    @FindBy(css = "div.select2-result-label")
    private WebElement userDropDown;
    @FindBy(css = ".restrictions-dialog-option")
    private List<WebElement> dialogOptions;
    @FindBy(css = "span.page-restrictions-dialog-explanation")
    private WebElement permissionInfo;
    @FindBy(css = ".restrictions-dialog-table .entity-row")
    private List<WebElement> usersInTable;


    public RestrictionsDialog(WebDriver driver) {
        super(driver);
    }

    public void setNoPermissions() throws InterruptedException {
        WebElement resArrow = basicOperator.waitForElementClickable(restrictionArrow);
        resArrow.click();
        dialogOptions.get(1).click();
    }

    public void setEditPermissionsByIndex(int index) {
        WebElement resArrow = basicOperator.waitForElementClickable(restrictionArrow);
        resArrow.click();
        basicOperator.waitForElementVisible(userDropDown);
        dialogOptions.get(index).click();
    }

    public void checkSelectedPermission(String text) {
        basicOperator.waitForElementText(permissionInfo, text);
    }

    public void searchAndAddUser(String userName) throws InterruptedException {
        try {
            searchTextField.clear();
            searchTextField.sendKeys(userName);
            basicOperator.waitForElementText(userDropDown, userName);
            userDropDown.click();
            addButton.click();
        } catch (Exception e) {
            System.err.println("Failed to find user. Error: " + e.getMessage());
        }
    }

    public void checkUserInTable(String userName) {
        basicOperator.waitForScript("return $('.restrictions-dialog-table .entity-row').text()", returnResult -> ((String) returnResult).contains(userName));
    }

    public void selectApplyButton() {
        applyButton.click();
    }

    public void selectCancelButton() {
        cancelLink.click();
    }
}
