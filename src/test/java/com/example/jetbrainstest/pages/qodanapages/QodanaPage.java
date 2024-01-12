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

    @FindBy(xpath = "//a[@href='https://www.jetbrains.com/help/qodana/getting-started.html']")
    private WebElement DocumentationButton;

    @FindBy(xpath = "//a[contains(@class,'wt-col-inline wt-text-2 menu-second__link wt-text-2_theme_dark _theme-dark wt-text-2_hardness_average menu-item') and text()='Blog']")
    private WebElement BlogButton;

    @FindBy(xpath = "//a[@href='/qodana/request-a-demo/']")
    private WebElement RequestDemoButton;

    @FindBy(xpath = "//a[@href='/qodana/buy/']")
    private WebElement PricingButton;

    @FindBy(xpath = "//a[contains(@class,'wt-col-inline menu-second__download-button wt-button wt-button_size_s wt-button_mode_primary wt-button_theme_dark') and text()='Try for free']")
    private WebElement TryForFreeButton1;

    @FindBy(xpath = "//a[contains(@class,'_main_1o2xc3v_17 _modeClassic_1o2xc3v_168 _sizeL_1o2xc3v_106 _alignIconLeft_1o2xc3v_77 _dark_1o2xc3v_62 qodana-button qodana-button_header')]")
    private WebElement TryForFreeButton2;

    @Step("Проверка кликабельности кнопки Documentation")
    public Boolean checkIfDocumentationButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Documentation");
        return DocumentationButton.isEnabled();
    }

    @Step("Проверка кликабельности кнопки Blog")
    public Boolean checkIfBlogButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Blog");
        return  BlogButton.isEnabled();
    }

    @Step("Проверка кликабельности кнопки Request Demo")
    public Boolean checkIfRequestDemoButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Request Demo");
        return  RequestDemoButton.isEnabled();
    }

    @Step("Переход на страницу Request a demo")
    public void requestDemoButtonClick(){
        RequestDemoButton.click();
        LOG.info("Переход на страницу Request a demo");
    }

    @Step("Проверка кликабельности кнопки Pricing")
    public Boolean checkIfPricingButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Pricing");
        return  PricingButton.isEnabled();
    }

    @Step("Проверка кликабельности кнопки Try For Free в меню")
    public Boolean checkIfTryForFreeButton1IsClickable(){
        LOG.info("Проверка кликабельности кнопки Try For Free в меню");
        return  TryForFreeButton1.isEnabled();
    }

    @Step("Проверка кликабельности кнопки Try For Free на странице")
    public Boolean checkIfTryForFreeButton2IsClickable(){
        LOG.info("Проверка кликабельности кнопки Try For Free на странице");
        return  TryForFreeButton2.isEnabled();
    }

    public QodanaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

