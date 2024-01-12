package com.example.jetbrainstest.pages.qodanapages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://www.jetbrains.com/qodana

public class QodanaPage {
    private final Logger LOG = LoggerFactory.getLogger(QodanaPage.class);
    WebDriver driver;

    @FindBy(xpath = "(//*[text()='Documentation'])[1]")
    private WebElement DocumentationButton;

    @FindBy(xpath = "(//*[text()='Blog'])[3]")
    private WebElement BlogButton;

    @FindBy(xpath = "//*[text()='Request Demo']")
    private WebElement RequestDemoButton;

    @FindBy(xpath = "(//*[text()='Pricing'])[2]")
    private WebElement PricingButton;

    @FindBy(xpath = "(//*[text()='Try for free'])[1]")
    private WebElement TryForFreeButton1;

    @FindBy(xpath = "(//*[text()='Try for free'])[2]")
    private WebElement TryForFreeButton2;

    public Boolean checkIfDocumentationButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Documentation");
        return DocumentationButton.isEnabled();
    }

    public Boolean checkIfBlogButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Blog");
        return  BlogButton.isEnabled();
    }

    public Boolean checkIfRequestDemoButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Request Demo");
        return  RequestDemoButton.isEnabled();
    }

    public void requestDemoButtonClick(){
        RequestDemoButton.click();
        LOG.info("Переход на страницу Request a demo");
    }

    public Boolean checkIfPricingButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Pricing");
        return  PricingButton.isEnabled();
    }

    public Boolean checkIfTryForFreeButton1IsClickable(){
        LOG.info("Проверка кликабельности кнопки Try For Free в меню");
        return  TryForFreeButton1.isEnabled();
    }

    public Boolean checkIfTryForFreeButton2IsClickable(){
        LOG.info("Проверка кликабельности кнопки Try For Free на странице");
        return  TryForFreeButton2.isEnabled();
    }

    public QodanaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

