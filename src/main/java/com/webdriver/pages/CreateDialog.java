package com.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDialog {

    private WebDriver driver;
    @FindBy(className = "select2-choice")
    private WebElement selectSpaceDropdown;
    @FindBy(css = "span.template-preview.icon-blank-page-large")
    private WebElement blankPageIcon;
    @FindBy(css = "span.template-preview.icon-blogpost-large")
    private WebElement blogPostIcon;
    @FindBy(css = "span.template-preview.decisions-blueprint-icon.large")
    private WebElement decisionIcon;
    @FindBy(css = "span.template-preview.file-list-blueprint-icon.large")
    private WebElement fileListIcon;
    @FindBy(css = "span.template-preview.icon-kb-how-to-article-blueprint.large")
    private WebElement howToIcon;
    @FindBy(css = "span.template-preview.meeting-notes-blueprint-icon.large")
    private WebElement meetingNotesIcon;
    @FindBy(css = "span.template-preview.sharelinks-blueprint-icon.large")
    private WebElement shareLinksIcon;
    @FindBy(css = "span.template-preview.task-report-blueprint-icon")
    private WebElement taskReportIcon;
    @FindBy(css = "span.template-preview.icon-kb-troubleshooting-article-blueprint.large")
    private WebElement troubleshootingArticleIcon;
    @FindBy(css = "button.create-dialog-create-button.aui-button.aui-button-primary")
    private WebElement createButton;
    @FindBy(css = "a.button-panel-link.button-panel-cancel-link")
    private WebElement cancelLink;
    @FindBy(css = "a.add-remove-customise-templates-trigger.button-panel-link")
    private WebElement customizeLink;

    public CreateDialog(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBlankPageIcon() {
        blankPageIcon.click();
    }

    public void selectBlogPostIcon() {
        blogPostIcon.click();
    }

    public void selectDecisionIcon() {
        decisionIcon.click();
    }

    public void selectFileListIcon() {
        fileListIcon.click();
    }

    public void selectHowToIcon() {
        howToIcon.click();
    }

    public void selectMeetingNotesIcon() {
        meetingNotesIcon.click();
    }

    public void selectShareLinksIcon() {
        shareLinksIcon.click();
    }

    public void selectTaskReportIcon() {
        taskReportIcon.click();
    }

    public void selectTroubleshootingArticleIcon() {
        troubleshootingArticleIcon.click();
    }

    public void selectCreateButton() {
        createButton.click();
    }

    public void selectCancelLink() {
        cancelLink.click();
    }
}
