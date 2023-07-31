package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Set;

// https://tempmail.plus/ru/#! генерация email
public class GenerateEmail {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy (xpath = "//button[@id='pre_copy']")
    public WebElement copiedEmail;

    @FindBy (xpath = "//div[@class='row no-gutters']")
    private WebElement messageEmailCheckDataGrip;

    @FindBy (xpath = "//div[contains(text(),'Your subscription confirmation for major DataGrip ')]")
    private WebElement getTextmessage;

    public GenerateEmail(WebDriver driver){ //Конструктор
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

    public void copiedButtonEmail(){
        driver.get("https://tempmail.plus/ru/#!");
        LOG.info("Открытие страницы генерации Email");
        copiedEmail.click();
        LOG.info("Копирование сгенерированного Email");
    }

    public void messageCheckDataGrip(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row no-gutters']")));
            message.click();
            LOG.info("Открытие полученного письма");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String checkGetTextEmailMessage() {
        LOG.infoWithScreenshot("Получение названия сообщения Email DataGrip");
        return getTextmessage.getText();
    }

    public void openPageInNewTag(){
        ((JavascriptExecutor) driver).executeScript("window.open();");
        String originalTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                LOG.info("Открыта новая вкладка");
                break;
            }
        }
    }

    public void tabBack(){driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);}
    public void waitSleep(){WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(50));}

    public void switchToTab(int tabIndex) {
        Set<String> tabs = driver.getWindowHandles();
        int tabCount = tabs.size();

        if (tabCount >= tabIndex) {
            String tabToSwitch = (String) tabs.toArray()[tabIndex - 1];
            driver.switchTo().window(tabToSwitch);
        } else {
            System.out.println("Запрошенной вкладки не существует");
        }
    }

    public static String getClipboardText() throws AWTException, IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }

}
