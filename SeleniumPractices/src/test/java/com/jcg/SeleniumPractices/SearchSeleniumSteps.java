package com.jcg.SeleniumPractices;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SearchSeleniumSteps {


    GoogleHomePage googleHomePage;


    @Given("^I open chrome browser$")
    public void iOpenChromeBrowser() throws Throwable {
        googleHomePage = new GoogleHomePage(new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), new ChromeOptions()));
    }

    @When("^I navigate to google search page$")
    public void iNavigateToGoogleSearchPage() throws Throwable {
        googleHomePage.openPage();
    }

    @When("^I provide search text as selenium and enter$")
    public void iProvideSearchTextAsSeleniumAndEnter() throws Throwable {
        googleHomePage.searchText("Selenium", Keys.ENTER);
    }

    @Then("^Selenium should be in page title$")
    public void seleniumShouldBeInPageTitle() throws Throwable {
        Assert.assertEquals("Selenium - Google Search", googleHomePage.getWebDriver().getTitle());
        googleHomePage.getWebDriver().quit();
    }

    @When("^I provide search text as \"([^\"]*)\" and enter$")
    public void iProvideSearchTextAsAndEnter(String searchTerm) throws Throwable {
        googleHomePage.searchText(searchTerm, Keys.ENTER);
    }

    @Then("^\"([^\"]*)\" should be in page title$")
    public void shouldBeInPageTitle(String searchTerm) throws Throwable {
        try{
            Assert.assertEquals(searchTerm + " - Google Search", googleHomePage.getWebDriver().getTitle());
        }catch (AssertionError error){
            googleHomePage.takeScreenShot(searchTerm+".png");
            throw error;
        }
        finally {
            googleHomePage.getWebDriver().quit();
        }
    }

    @Given("^I open \"([^\"]*)\" browser$")
    public void iOpenBrowser(String browser) throws Throwable {
        if ("chrome".equalsIgnoreCase(browser)) {
            googleHomePage = new GoogleHomePage(new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"), new ChromeOptions()));
        } else if ("firefox".equalsIgnoreCase(browser)) {
            googleHomePage = new GoogleHomePage(new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"), new FirefoxOptions()));
        }

    }

}
