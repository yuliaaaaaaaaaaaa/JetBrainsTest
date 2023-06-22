package com.example.jetbrainstest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page url = https://www.jetbrains.com/webstorm/
public class WebStormPage {
    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href ='/webstorm/download/download-thanks.html']")
    private WebElement downloadButton;

    public Boolean checkIfDownloadButtonIsClickable(){
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    public WebStormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/webstorm/whatsnew/']")
    public WebElement whatsNewButton;
    public void whatsNewButtonClick(){
        whatsNewButton.click();
    }
    @FindBy(xpath = "//a[@href='/webstorm/buy/']")
    public WebElement prisingButton;

}
