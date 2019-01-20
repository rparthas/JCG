package com.jcg.SeleniumPractices;

import com.jcg.SeleniumPractices.GoogleHomePage;
import com.jcg.SeleniumPractices.GoogleResultsPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POTestSuite {

    GoogleHomePage googleHomePage;
    GoogleResultsPage googleResultsPage;
    WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        googleHomePage = new GoogleHomePage(webDriver);
        googleResultsPage = new GoogleResultsPage(webDriver);
    }

    @BeforeClass
    public static void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


    @Test
    public void enterGoogleSearchAndViewResults() {
        googleHomePage.openPage();
        googleHomePage.searchText("Selenium", Keys.ENTER);
        Assert.assertEquals("Selenium - Google Search", webDriver.getTitle());
    }


    @Test
    public void enterGoogleImageSearch() {
        googleHomePage.openPage();
        googleHomePage.searchText("Selenium", Keys.ENTER);
        googleResultsPage.performImageSearch();
    }
}
