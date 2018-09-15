package com.jcg.pageObjectModel.test;


import com.jcg.PageObjectModel.DriverInitializer;
import com.jcg.PageObjectModel.IndexPage;
import com.jcg.PageObjectModel.LoginPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.*;

public class TestLogin {

    static WebDriver webDriver;

    @BeforeClass
    public static void setUp() throws Exception {
        webDriver = DriverInitializer.getDriver();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
    }

    @Before
    public void navigate() {
        webDriver.get(DriverInitializer.getProperty("login.url"));
    }

    @Test
    public void login() {
        WebElement webElement = webDriver.findElement(By.id("username"));
        webElement.sendKeys("hi");
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys("hi");
        webElement = webDriver.findElement(By.id("login-btn"));
        webElement.click();
        webElement = webDriver.findElement(By.id("name"));
        assertThat(webElement.getText()).isEqualTo("hi");

    }

    @Test
    public void loginPageModel() {
        LoginPage.logInWithUsernameAndPassword("hi", "hi", webDriver);
        assertThat(webDriver.findElement(IndexPage.usernameLocator).getText()).isEqualTo("hi");
    }

    @Test
    public void loginPageFactory() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitForUserName();
        loginPage.logIn("hi", "hi");
        assertThat(webDriver.findElement(IndexPage.usernameLocator).getText()).isEqualTo("hi");
    }

    @Test
    public void loginQueryObject() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.waitForUserNameByLocator();
        loginPage.logInWithUsernameAndPassword("hi", "hi");
        assertThat(webDriver.findElement(IndexPage.usernameLocator).getText()).isEqualTo("hi");
    }

}
