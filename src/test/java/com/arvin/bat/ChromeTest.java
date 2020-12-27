package com.arvin.bat;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ChromeTest extends TestCase {

    private WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            System.setProperty("webdriver.chrome.driver", "/opt/webdriver/chrome/chromedriver");

            // Add options to Google Chrome. The window-size is important for responsive sites
            ChromeOptions options = new ChromeOptions();
            String proxy = "127.0.0.1:1080";
            options.addArguments("--proxy-server=socks5://" + proxy);

            options.setBinary("/usr/bin/brave-browser");
//            options.addArguments("headless");
            options.addArguments("window-size=1200x600");

            driver = new ChromeDriver(options);

            latch.countDown();
        }).start();

        latch.await();

        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
        driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);

        // 存储原始窗口的 ID
        String originalWindow = driver.getWindowHandle();

        // 检查一下，我们还没有打开其他的窗口
        assert driver.getWindowHandles().size() == 1;

        // 点击在新窗口中打开的链接
        driver.findElement(By.linkText("新的标签页")).click();

        // 等待新窗口或标签页
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(numberOfWindowsToBe(2));

        // 循环执行，直到找到一个新的窗口句柄
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // 等待新标签完成加载内容
        wait.until(titleIs("Selenium documentation"));

        driver.quit();
    }

}
