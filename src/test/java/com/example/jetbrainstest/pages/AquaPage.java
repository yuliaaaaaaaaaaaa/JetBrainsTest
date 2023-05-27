package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AquaPage {

    WebDriver driver;

    @FindBy(xpath = "//p[text()='JetBrains Aqua IDE']/preceding-sibling::a")
    private WebElement downloadAquaButton;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement mainPageButton;

    @FindBy(xpath = "//button[text()='Plugin']")
    private WebElement switcherButtonPlugin;

    @FindBy(xpath = "//div[contains(@class,'navigation-buttons')]//a")
    private WebElement switcherButtonPluginChild;

    public Boolean downloadAquaButtonIsClickable(){
        System.out.println("Проверка активности кнопки загрузки");
        return downloadAquaButton.isEnabled();
    }

    public void mainPageButtonClick(){
        mainPageButton.click();
        System.out.println("Переход на главную страницу");
    }

    public String buttonName(){
        switcherButtonPlugin.click();
        System.out.println("Проверка названия кнопки");
        return switcherButtonPluginChild.getText();
    }

    public AquaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
