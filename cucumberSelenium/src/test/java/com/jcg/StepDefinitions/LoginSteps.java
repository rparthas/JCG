package com.jcg.StepDefinitions;

import com.jcg.PageObjectModel.DriverInitializer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    WebDriver webDriver = null;

    @Given("^I open firefox browser$")
    public void iOpenFirefoxBrowser() throws Throwable {
        webDriver = DriverInitializer.getDriver("firefox");
    }

    @When("^I navigate to login\\.html page$")
    public void iNavigateToLoginHtmlPage() throws Throwable {
        webDriver.get(DriverInitializer.getProperty("login.url"));
    }

    @When("^I provide username as hi and password as hi$")
    public void iProvideUsernameAsHiAndPasswordAsHi() throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("username"));
        webElement.sendKeys("hi");
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys("hi");
    }

    @When("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("login-btn"));
        webElement.click();
    }

    @Then("^hi should be name$")
    public void hiShouldBeName() throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("name"));
        try {
            assertThat(webElement.getText()).isEqualTo("hi");
        } finally {
            webDriver.quit();
        }
    }

    @When("^I provide username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iProvideUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("username"));
        webElement.sendKeys(username);
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys(password);
    }

    @Then("^name should be \"([^\"]*)\"$")
    public void nameShouldBe(String name) throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("name"));
        try {
            assertThat(webElement.getText()).isEqualTo(name);
        } finally {
            webDriver.quit();
        }
    }
}