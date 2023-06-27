package com.example.jetbrainstest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


// page_url = https://www.jetbrains.com/go/
public class GoLangPage {
    WebDriver driver;

    @FindBy(css = "a[data-test='button' ][href ='/go/download/download-thanks.html']")
    private WebElement downloadButton;

    @FindBy(css = "div.wt-text-2")
    private WebElement freeDays;

    @FindBy(css = "a.follow__link")
    private List<WebElement> followLinks;

    public Boolean checkIfDownloadButtonIsClickable(){
        System.out.println("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public String checkTextFreeDays() {
        String value = freeDays.getText();
        System.out.println("Получен текст: \"" + value + "\"");
        return value;
    }

    public Boolean checkFollowLinksIsClickable(){
        System.out.println("Проверка кликабельности кнопок подписки на иные ресурсы");
        boolean enabled = false;
        for (WebElement links : followLinks)
            enabled = links.isEnabled() ? true : false;
        return enabled;
    }

    public GoLangPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
