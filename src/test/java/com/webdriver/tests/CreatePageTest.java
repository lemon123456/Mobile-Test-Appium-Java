package com.webdriver.tests;

import com.webdriver.pages.BlankPage;
import com.webdriver.pages.LoginPage;
import com.webdriver.pages.Navigation;
import com.webdriver.pages.PublishedPage;
import com.webdriver.runtimes.TestProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.junit.Test;

public class CreatePageTest extends TestBase {
    private String username = TestProperty.getProperty("test", "username");
    private String password = TestProperty.getProperty("test", "password");
    long randomString = System.currentTimeMillis();

    private LoginPage loginPg;
    private Navigation navPage;
    private PublishedPage publishedPage;
    private BlankPage blankPage;

    //Test the page quick create function in Confluence
    @Test
    public void testCreatePage() throws InterruptedException {
        loginPg = PageFactory.initElements(driver, LoginPage.class);
        navPage = PageFactory.initElements(driver, Navigation.class);
        publishedPage = PageFactory.initElements(driver, PublishedPage.class);
        blankPage = PageFactory.initElements(driver, BlankPage.class);

        // Log In
        loginPg.setUserInfo(username, password);
        loginPg.clickLoginButton();

        // Go to Create Page
        navPage.selectQuickCreateButton();

        // Add content to the page & save
        String[] testData = {"test page title" + randomString, "test page body" + randomString};
        blankPage.fillTitleBar(testData[0]);
        blankPage.switchFrame("wysiwygTextarea_ifr");
        blankPage.fillBody(testData[1]);
        blankPage.switchFrame("default");
        blankPage.selectSaveButton();

        // Check the page
        publishedPage.validatePageCreated(testData);
        publishedPage.validateCommentBoxExists();
    }


}

