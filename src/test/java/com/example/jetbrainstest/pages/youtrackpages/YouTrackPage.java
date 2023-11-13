package com.example.jetbrainstest.pages.youtrackpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.jetbrains.com/youtrack/
public class YouTrackPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/youtrack/whatsnew/']")
    private WebElement WhatsNewButton;

    @FindBy(xpath = "//a[@href='/youtrack/agile/']")
    private WebElement AgileButton;

    @FindBy(xpath = "//a[@href='/youtrack/teams/']")
    private WebElement TeamsButton;

    @FindBy(xpath = "//a[@href='/youtrack/features/']")
    private WebElement FeaturesButton;

    @FindBy(xpath = "//a[@href='/youtrack/helpdesk/']")
    private WebElement HelpdeskButton;

    @FindBy(xpath = "//a[@href='/youtrack/support/']")
    private WebElement SupportButton;

    @FindBy(xpath = "//a[@href='/youtrack/buy/']")
    private WebElement PricingButton;

    public Boolean checkIfWhatsNewButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки What's New");
        return  WhatsNewButton.isEnabled();
    }

    public Boolean checkIfAgileButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Agile");
        return  AgileButton.isEnabled();
    }

    public Boolean checkIfTeamsButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Teams");
        return  TeamsButton.isEnabled();
    }

    public Boolean checkIfFeaturesButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Features");
        return  FeaturesButton.isEnabled();
    }

    public Boolean checkIfHelpdeskButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Helpdesk");
        return  HelpdeskButton.isEnabled();
    }

    public Boolean checkIfSupportButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Support");
        return  SupportButton.isEnabled();
    }

    public Boolean checkIfPricingButtonIsClickable(){
        System.out.println("Проверка кликабельности кнопки Pricing");
        return  PricingButton.isEnabled();
    }

    public YouTrackPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
