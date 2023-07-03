package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PyCharmPage {

    WebDriver driver;
    @FindBy(css = ".menu-second-title-box__title.wt-h3")
    private WebElement pyCharmButton;


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
