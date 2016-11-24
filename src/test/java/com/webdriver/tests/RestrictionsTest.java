package com.webdriver.tests;

import com.webdriver.pages.*;
import com.webdriver.runtimes.TestProperty;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.junit.Test;

public class RestrictionsTest extends TestBase {

    private String username = TestProperty.getProperty("test", "username");
    private String password = TestProperty.getProperty("test", "password");

    private LoginPage loginPg;
    private Navigation navPage;
    private PublishedPage publishedPage;
    private RestrictionsDialog resDialog;
    private BlankPage blankPage;


    @Before
    public void setup() {
        loginPg = PageFactory.initElements(driver, LoginPage.class);
        navPage = PageFactory.initElements(driver, Navigation.class);
        publishedPage = PageFactory.initElements(driver, PublishedPage.class);
        resDialog = PageFactory.initElements(driver, RestrictionsDialog.class);
        blankPage = PageFactory.initElements(driver, BlankPage.class);

        // Log In
        loginPg.setUserInfo(username, password);
        loginPg.clickLoginButton();

        // Open Existing Page
        navPage.openExistingPage();

        // Open Restrictions Dialog
        publishedPage.selectRestrictionIcon();
    }

    // Test adding current user to page restrictions
    @Test
    public void CheckEditPermission() throws InterruptedException {
        // Select Restriction Type
        resDialog.setEditPermissionsByIndex(2);
        resDialog.checkSelectedPermission("Everyone can view, only some can edit.");
        resDialog.selectCancelButton();
    }

    // Test adding another user to page restrictions
    @Test
    public void CheckUserAdded() throws InterruptedException {
        // Select Restriction Type
        String userName = "System Administrator";
        resDialog.setEditPermissionsByIndex(3);
        resDialog.searchAndAddUser(userName);
        resDialog.checkUserInTable("System Administrator");
        resDialog.selectCancelButton();
    }

    // Test adding a group to page restrictions
    @Test
    public void CheckConfluenceUserAndDeletePage() throws InterruptedException {
        // Select Restriction Type
        resDialog.setEditPermissionsByIndex(3);
        resDialog.searchAndAddUser("confluence-users");
        resDialog.checkUserInTable("confluence-users");
        resDialog.selectCancelButton();
        // Remove existing page
        publishedPage.deletePage();
    }

}

