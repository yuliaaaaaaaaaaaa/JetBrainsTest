package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static com.example.jetbrainstest.MyWait.myWait;

public class ToolBoxOtherVersionPage1 {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxOtherVersionPage1.class));
    @FindBy(xpath = "//*[text() = 'Other Versions - Toolbox']")
    private WebElement titleOtherVersion;

   public String titleIsDisplayed() {
       LOG.info("Проверка соотвтствия title");
       myWait(10).visible(titleOtherVersion);
       return titleOtherVersion.getText();
    }
    public ToolBoxOtherVersionPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
