package com.arvin.bat;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class BraveBrowser {
    private static final String PROXY = "127.0.0.1:1080";
    private static final String DRIVER_PATH = "/opt/webdriver/chrome/chromedriver";
    private static final String BRAVE_BINARY_PATH = "/usr/bin/brave-browser";

    private static final String urlsFile = "/home/arvin/tmp/history.csv";

    private String dataDir;
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public BraveBrowser(String dataDir) {
        this.dataDir = dataDir;
        initSystemProperties();
    }

    public void browse() {
        createDriver();
        createWait();
        initBrowserIfNessary();

        String amt = getCurrentAmt();
        log.info("=========== 当前奖励: {}", amt);

        List<String> urls = getUrls();
        log.info("=========== url数量: {}", urls.size());
        visitUrls(urls);

        driver.quit();
    }

    private void createDriver() {
        if (!new File(dataDir).exists()) {
            new File(dataDir).mkdirs();
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--proxy-server=socks5://" + PROXY);
        options.setBinary(BRAVE_BINARY_PATH);
        options.addArguments("user-data-dir=" + dataDir);
        options.addArguments("window-size=1200x600");
//        options.setHeadless(true);

        driver = new ChromeDriver(options);
    }

    private void createWait() {
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

    private List<String> getUrls() {
        try {
            return FileUtils.readLines(new File(urlsFile), "UTF-8")
                    .stream()
                    .filter(line -> !line.contains("download"))
                    .map(line -> line.split(",")[5].trim())
                    .filter(url -> url.startsWith("http"))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Read Urls File Error: ", e);
        }
        return new ArrayList<>();
    }

    private void visitUrls(List<String> urls) {
        Random random = new Random();
        for (int i = 0; i < urls.size(); i++) {
            try {
                String url = urls.get(i);
                log.trace("===== get url: {}", url);
                driver.get(url);
                log.trace("===== got url: {} >> title: {}", url, driver.getTitle());

                if (i % 10 == 0) {
                    log.info("===== Visited: {}/{}", i, urls.size());
                }
                Thread.sleep(random.nextInt(10000) % 5000 + 5000);
            } catch (InterruptedException e) {
                log.error("Thread Sleep Interrupted: ", e);
            }
        }
    }

    private String getCurrentAmt() {
        try {
            driver.get("chrome://newtab/");
            WebElement amt = wait.until(driver -> driver.findElement(By.cssSelector("span.Amount-sc-sjhf0v.hmwSXR")));
            return amt.getText();
        } catch (Exception e) {
            log.info("Can not find Amt");
        }
        return "";
    }

    private void initSystemProperties() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    private void initBrowserIfNessary() {
        String amt = getCurrentAmt();
        if (amt != null && amt.trim() != null) {
            return;
        }

        driver.get("chrome://newtab/");
        log.info("========== title: {}", driver.getTitle());

        WebElement batTurnOn = wait.until(driver -> driver.findElement(By.cssSelector("button.TurnOnButton-sc-1lf6a2.dubbqm")));
        log.info("=========== button: {}", batTurnOn.getText());
        batTurnOn.click();

        amt = getCurrentAmt();
        log.info("=========== 开启奖励 Success!");
        log.info("===========当前奖励: {}", amt);

        closeAutoContribute();
    }

    private void closeAutoContribute() {
        driver.get("brave://rewards/");
        log.info("========== title: {}", driver.getTitle());

        WebElement autoContributeDiv = null;
        List<WebElement> configDivs = wait.until(driver -> driver.findElements(By.cssSelector("div.StyledWrapper-sc-1ubl27w.cgyYj")));
        for (WebElement configDiv : configDivs) {
            try {
                WebElement alias = configDiv.findElement(By.cssSelector("div.StyledTitle-sc-q6902m.fpxMCj"));
                if ("自动贡献".equals(alias.getText())) {
                    autoContributeDiv = configDiv;
                    break;
                }
            } catch (Exception e) {
            }
        }
        if (autoContributeDiv != null) {
            final WebElement finalAutoContributeDiv = autoContributeDiv;
            WebElement autoContribute = wait.until(driver -> finalAutoContributeDiv.findElement(By.cssSelector("div.StyleToggle-sc-eswt20.elJnBy")));
            autoContribute.click();
            WebElement status = wait.until(driver -> driver.findElement(By.cssSelector("div.StyledText-sc-1lruzm4.blLQoh")));
            log.info("=========== 自动贡献: {}", status.getText());
        }
    }
}
