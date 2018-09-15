package com.jcg.PageObjectModel;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    protected RemoteWebDriver driver;

    public static By usernameLocator = By.id("username");
    public static By passwordLocator = By.id("password");
    public static By loginButtonLocator = By.id("login-btn");

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = (RemoteWebDriver) driver;
    }

    public static void logInWithUsernameAndPassword
            (String username, String password, WebDriver driver) {

        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    @FindBy(how = How.ID, using = "username")
    private WebElement userName;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "login-btn")
    private WebElement login;

    public void logIn(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login.click();
    }

    public void waitForUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("username")));
    }

    private Query usernameField = new Query(By.id("username"));
    private Query passwordField = new Query(By.id("password"));
    private Query loginButton = new Query(By.id("login-btn"));

    public void logInWithUsernameAndPassword(String username,
                                             String password) {
        usernameField.initQueryObject(driver).findWebElement().sendKeys(username);
        passwordField.initQueryObject(driver).findWebElement().sendKeys(password);
        loginButton.initQueryObject(driver).findWebElement().click();
    }

    public void waitForUserNameByLocator() {
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (usernameField.initQueryObject(driver).locator()));
    }


}
