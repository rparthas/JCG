package com.jcg.SeleniumPractices;

import org.openqa.selenium.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleHomePage {

    private WebDriver webDriver = null;

    public GoogleHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }


    public void openPage() {
        webDriver.navigate().to("https://www.google.com");
    }

    public static By searchInput = By.cssSelector("input[title=Search]");

    public static By searchButton = By.cssSelector("input[type=submit]");

    public void searchText(CharSequence... keys) {
        WebElement element = webDriver.findElement(searchInput);
        element.sendKeys(keys);
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public void takeScreenShot(String fileName){
        byte[] bytes=((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        File DestFile=new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            try {
                fos.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
