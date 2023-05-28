package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/objc/
public class AppCodePage {

    WebDriver driver;

    @FindBy(css = "[href ='/objc/download/']")
    private WebElement downloadButton;

    public Boolean checkIfDownloadButtonIsClickable(){
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public AppCodePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
