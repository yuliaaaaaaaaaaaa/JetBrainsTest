package com.example.jetbrainstest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

//url = https://www.jetbrains.com/all/
public class AllProductsPage {
    WebDriver driver;
    private final Logger LOG =LoggerFactory.getLogger(AllProductsPage.class);
    @FindBy(css = "a[data-test='button' ][href ='/idea/buy/']")
    private WebElement downloadButton;

    @FindBy(css="#js-menu-second-desktop > a")
    private WebElement buyButton;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Проверка активности кнопки загрузки")
    public Boolean checkIfDownloadButtonIsClickable(){
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }
    @Step("Проверка наличия кнопки Buy")
    public Boolean checkIfBuyButtonEnabled(){
        LOG.info("Проверка наличия кнопки Buy");
        return buyButton.isEnabled();
    }
    @Step("Нажатие на кнопку Buy")
    public void buyButtonClick(){
        LOG.info("Нажатие на кнопку Buy");
        buyButton.click();
    }
    @Step("Перешли на вкладку №{num}")
    public void switchToStoreTab(int num){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num-1));
        LOG.info("Перешли на вкладку №" + (num));
    }


}
