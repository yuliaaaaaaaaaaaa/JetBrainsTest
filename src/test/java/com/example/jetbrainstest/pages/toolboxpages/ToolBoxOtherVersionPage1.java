package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.example.jetbrainstest.MyWait.myWait;

public class ToolBoxOtherVersionPage1 {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxOtherVersionPage1.class));
    @FindBy(xpath = "//h1[text() = 'Other Versions']")
    private WebElement titleOtherVersion;

   public String getTitleText() {
       LOG.info("В заголовке текст: " + driver.getTitle());
       myWait(10).visible(titleOtherVersion);
       //return titleOtherVersion.getText();
       return driver.getTitle();
    }
    public ToolBoxOtherVersionPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
