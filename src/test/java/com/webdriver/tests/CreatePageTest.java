package com.webdriver.tests;

import com.webdriver.pages.BlankPage;
import com.webdriver.pages.Navigation;
import com.webdriver.pages.PublishedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.junit.Test;

public class CreatePageTest extends TestBase {

    // Test the page quick create function in Confluence
    @Test
    public void testCreatePage() throws InterruptedException {

        // Log In
        String username = "<add username here>";
        String password = "<add password here>";

        d.findElement(By.id("username")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.id("login")).click();
        Thread.sleep(1000);

        // Go to Create Page
        Navigation nav = PageFactory.initElements(d, Navigation.class);
        nav.selectQuickCreateButton();
        Thread.sleep(1000);

        // Add content to the page & save
        String[] testData = {"test page title", "test page body"};
        BlankPage page = PageFactory.initElements(d, BlankPage.class);
        page.fillTitleBar(testData[0]);
        d.switchTo().frame("wysiwygTextarea_ifr");
        page.fillBody(testData[1]);
        d.switchTo().defaultContent();
        page.selectSaveButton();
        Thread.sleep(5000);

        // Check the page
        PublishedPage newPage = PageFactory.initElements(d, PublishedPage.class);
        newPage.validatePageCreated(testData);
        newPage.validateCommentBoxExists();

    }


}

