package com.jcg.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Date;

@RunWith(ParallelParameterized.class)
public class TestBase {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public MutableCapabilities capabilities;

    @Parameterized.Parameters
    public static MutableCapabilities[] getBrowserCapabilities() {
        return new MutableCapabilities[]{
                new ChromeOptions(),
                new FirefoxOptions()
        };
    }

    public TestBase(MutableCapabilities capabilities) {
        this.capabilities = capabilities;
    }

}
