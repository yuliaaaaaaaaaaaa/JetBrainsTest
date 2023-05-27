package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//page_url = https://www.jetbrains.com/aqua/
public class AquaPage {

    private final Logger LOG = LoggerFactory.getLogger(AquaPage.class);
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
        LOG.info("Проверка активности кнопки загрузки");
        return downloadAquaButton.isEnabled();
    }

    public void mainPageButtonClick(){
        mainPageButton.click();
        LOG.info("Переход на главную страницу");
    }

    public String buttonName(){
        switcherButtonPlugin.click();
        LOG.info("Проверка названия кнопки");
        return switcherButtonPluginChild.getText();
    }

    public AquaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
