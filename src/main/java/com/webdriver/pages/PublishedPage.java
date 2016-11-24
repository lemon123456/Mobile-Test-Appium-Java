package com.webdriver.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishedPage extends BasePage {

    @FindBy(id = "content-metadata-page-restrictions")
    private WebElement restrictionsIcon;
    @FindBy(id = "action-page-permissions-link")
    private WebElement restrictionsLink;
    @FindBy(id = "watch-content-button")
    private WebElement watchingLink;
    @FindBy(id = "shareContentLink")
    private WebElement shareLink;
    @FindBy(css = "div.restrictions-dialog-option")
    private WebElement optionsButton;
    @FindBy(id = "view-attachments-link")
    private WebElement attachementsLink;
    @FindBy(css = "div.ia-secondary-content")
    private WebElement pageTree;
    @FindBy(css = "div.quick-comment-prompt")
    private WebElement commentBoxPrompt;
    @FindBy(id = "wysiwygTextarea_ifr")
    private WebElement commentBoxTextFrame;
    @FindBy(id = "action-menu-link")
    private WebElement menuItemMore;
    @FindBy(id = "action-remove-content-link")
    private WebElement menuItemDeletePage;
    @FindBy(id = "confirm")
    private WebElement confirmDelete;
    @FindBy(css = "#title-text a")
    private WebElement title;
    @FindBy(css = "#username")
    private WebElement user;
    @FindBy(id = "page-restrictions-dialog-close-button")
    private WebElement cancelLink;

    private String pageTitle = "";

    public PublishedPage(WebDriver driver) {
        super(driver);
    }

    public void selectRestrictionIcon() {
        WebElement resIcon = basicOperator.waitForElementClickable(restrictionsIcon);
        resIcon.click();
    }

    public void validateCommentBoxExists() throws InterruptedException {
        commentBoxPrompt.click();
        basicOperator.waitForElementVisible(commentBoxTextFrame);
    }

    public void validatePageShownInTreeView(String PageTitle) {
        Assert.assertTrue(basicOperator.getCurrentUrl().contains("atlassian.net/wiki/display/"));
        for (WebElement x : pageTree.findElements(By.tagName("a"))) {
            if (PageTitle == x.getText()) {
                Assert.assertTrue("New page found", x.getText().contains(pageTitle));
                break;
            }
        }
    }

    public void validatePageCreated(String[] PageTitle) throws InterruptedException {
        basicOperator.waitForElementText(title, pageTitle);
        if (!basicOperator.getTitle().startsWith(PageTitle[0])) {
            throw new IllegalStateException("Page title does not match expected title");
        } else {
            validatePageShownInTreeView(PageTitle[1]);
        }
    }

    public void deletePage() throws InterruptedException {
        basicOperator.waitForElementClickable(menuItemMore);
        basicOperator.waitForScript("return $('#action-menu-link')[0].click()", null);
        menuItemDeletePage.click();
        confirmDelete.click();
    }
}
