package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.tests.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// page_url = https://www.jetbrains.com/objc/
public class AppCodePage {

    //private final Logger LOG = LoggerFactory.getLogger(AppCodePage.class);
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AppCodePage.class));
    WebDriver driver;

    @FindBy(css = "[href ='/objc/download/']")
    private WebElement downloadButton;

    public Boolean checkIfDownloadButtonIsClickable(){
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public AppCodePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
