package com.example.jetbrainstest.pages;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PyCharmPage {

    WebDriver driver;
    @FindBy(css = ".menu-second-title-box__title.wt-h3")
    private WebElement pyCharmButton;

    @FindBy(css = ".overview-header__download")
    private WebElement downloadButton;

    public boolean downloadButtonIsActive(){
        driver.get("https://www.jetbrains.com/pycharm/");
        return downloadButton.isDisplayed();
    }


    public boolean pyCharmButtonIsActive(){
        driver.get("https://www.jetbrains.com/pycharm/");
        return pyCharmButton.isDisplayed();
    }

    public String clickPyCharmButtonAndCheckUrl(){
        driver.get("https://www.jetbrains.com/pycharm/");
        pyCharmButton.click();
        return driver.getCurrentUrl();
    }


    public PyCharmPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
