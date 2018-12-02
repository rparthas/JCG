package com.jcg.selenium;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest extends TestBase {

    public GoogleSearchTest(MutableCapabilities capabilities) {
       super(capabilities);
    }

    @Before
    public void setUp() throws Exception {
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.set(webDriver);
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    public static void remove() {
        driver.remove();
    }


    @Test
    public void openGoogle() {
        log("openGoogle-start");
        WebDriver webDriver = getDriver();
        webDriver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", webDriver.getTitle());
        log("openGoogle-end");
    }

    @Test
    public void enterGoogleSearchAndViewResults() {
        log("enterGoogleSearchAndViewResults-start");
        WebDriver webDriver = getDriver();
        By searchLocator = By.cssSelector("input[value='Google Search']");
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("hi");
        WebElement searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
        Assert.assertEquals("hi - Google Search", webDriver.getTitle());
        log("enterGoogleSearchAndViewResults-end");
    }

    @Test
    public void enterGoogleSearchAndImageSearch() {
        log("enterGoogleSearchAndImageSearch--start");
        WebDriver webDriver = getDriver();
        By searchLocator = By.cssSelector("input[value='Google Search']");
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("hi");
        WebElement searchButton = webDriver.findElement(searchLocator);
        searchButton.click();
        WebElement imageSearch = webDriver.findElement(By.xpath("//a[contains(text(), 'Images')]"));
        imageSearch.click();
        log("enterGoogleSearchAndImageSearch-end");
    }


}