package com.webdriver.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishedPage {

    private WebDriver driver;
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
    private String pageTitle = "";

    public PublishedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectRestrictionIcon() {
        restrictionsIcon.click();
    }

    public void validateCommentBoxExists() throws InterruptedException {
        commentBoxPrompt.click();
        Thread.sleep(3000);
        Assert.assertTrue("Comment box is working", commentBoxTextFrame.isDisplayed());
    }

    public void validatePageShownInTreeView(String PageTitle) {
        Assert.assertTrue(driver.getCurrentUrl().contains("atlassian.net/wiki/display/"));
        for (WebElement x : pageTree.findElements(By.tagName("a"))) {
            if (PageTitle == x.getText()) {
                Assert.assertTrue("New page found", x.getText().contains(pageTitle));
                break;
            }
        }
    }

    public void validatePageCreated(String[] PageTitle) {
        if (!driver.getTitle().startsWith(PageTitle[0])) {
            throw new IllegalStateException("Page title does not match expected title");
        } else {
            validatePageShownInTreeView(PageTitle[1]);
        }
    }

    public void deletePage() {
        menuItemMore.click();
        menuItemDeletePage.click();
        confirmDelete.click();
    }
}
