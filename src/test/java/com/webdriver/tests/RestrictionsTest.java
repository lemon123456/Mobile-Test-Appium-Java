package com.webdriver.tests;

import com.webdriver.pages.PublishedPage;
import com.webdriver.pages.Navigation;
import com.webdriver.pages.RestrictionsDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.junit.Test;

public class RestrictionsTest extends TestBase {

    private String username = "<add username here>";
    private String password = "<add password here>";

    // Test adding current user to page restrictions
    @Test
    public void Test1() throws InterruptedException {

        // Log In
        d.findElement(By.id("username")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.id("login")).click();
        Thread.sleep(1000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(d, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(1000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(d, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(2000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(d, RestrictionsDialog.class);
        dialog.setEditPermissions();
        dialog.selectCancelButton();

    }

    // Test adding another user to page restrictions
    @Test
    public void Test2() throws InterruptedException {

        // Log In
        d.findElement(By.id("username")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.id("login")).click();
        Thread.sleep(1000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(d, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(1000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(d, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(1000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(d, RestrictionsDialog.class);
        dialog.setViewEditPermissions();
        dialog.searchUser("System Administrator");
        dialog.selectCancelButton();

    }

    // Test adding a group to page restrictions
    @Test
    public void Test3() throws InterruptedException {

        // Log In
        d.findElement(By.id("username")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.id("login")).click();
        Thread.sleep(1000);

        // Open Existing Page
        Navigation nav = PageFactory.initElements(d, Navigation.class);
        nav.openExistingPage();
        Thread.sleep(1000);

        // Open Restrictions Dialog
        PublishedPage page = PageFactory.initElements(d, PublishedPage.class);
        page.selectRestrictionIcon();
        Thread.sleep(1000);

        // Select Restriction Type
        RestrictionsDialog dialog = PageFactory.initElements(d, RestrictionsDialog.class);
        dialog.setViewEditPermissions();
        dialog.searchUser("confluence-users");
        dialog.selectCancelButton();

        // Remove existing page
        Thread.sleep(2000);
        page.deletePage();

    }

}

