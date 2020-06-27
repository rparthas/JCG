package com.jcg.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class SeleniumTest {

	WebDriver webDriver;

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}

	@BeforeEach
	public void initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		webDriver = new ChromeDriver(options);
	}

	@AfterEach
	public void closeDriver() {
		webDriver.quit();
	}

	@Test
	public void testCase1() {
		webDriver.navigate().to("http://www.google.com");
		assertEquals("Google", webDriver.getTitle(), "Title is not google");
	}

	@Test
	public void testCase2() throws IOException {
		webDriver.navigate().to("http://www.google.com");
		TakesScreenshot scrShot =((TakesScreenshot)webDriver);
		File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("screenshot.png"));
		webDriver.findElement(By.cssSelector("input[type=submit")).click();
	}

}
