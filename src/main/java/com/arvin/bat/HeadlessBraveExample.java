package com.arvin.bat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class HeadlessBraveExample {

    public static void main(String[] args) {

    }

    public static void testBrave() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Brave.app/Contents/MacOS/brave");
        WebDriver driver = new ChromeDriver(options);
    }

    public static void testFirefox() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        try {
            driver.get("http://www.baidu.com");
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            WebElement queryBox = driver.findElement(By.name("q"));
            queryBox.sendKeys("headless firefox");
            WebElement searchBtn = driver.findElement(By.name("btnK"));
            searchBtn.click();

            System.out.println(driver.getTitle());
            WebElement iresDiv = driver.findElement(By.id("ires"));
            iresDiv.findElements(By.tagName("a")).get(0).click();
            System.out.println(driver.getPageSource());
        } finally {
            driver.quit();
        }
    }
}
