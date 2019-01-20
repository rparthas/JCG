package com.jcg.SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResultsPage {

    WebDriver webDriver = null;

    public GoogleResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void performImageSearch() {
        webDriver.findElement(imageSearch).click();
    }

    public static By imageSearch = By.xpath("//a[contains(text(), 'Images')]");
}
