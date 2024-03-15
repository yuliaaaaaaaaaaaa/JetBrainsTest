package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ScalaPage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[contains(text(),'Get')]")
    private WebElement getButton;
    @FindBy(xpath = "//*[contains(text(),'Versions')]")
    private WebElement versions;
    @FindBy(xpath = "//*[contains(text(),'Show More')]")
    private WebElement showMore;

    public Boolean checkIfGetButtonIsClickable() {
        wait.until(ExpectedConditions.visibilityOfAllElements(getButton));
        System.out.println("Проверка активности кнопки загрузки");
        return getButton.isEnabled();
    }

    public Boolean findButtonShowMore() {
        System.out.println("Проверка наличия кнопки 'Show More' ");
        wait.until(ExpectedConditions.visibilityOfAllElements(getButton));
        versions.click();
        return showMore.isDisplayed();
    }


    public ScalaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
}
