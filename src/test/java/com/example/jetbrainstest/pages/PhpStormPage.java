package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpStormPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/phpstorm/download/']")
    public WebElement ButtonDownloadPhpStorm;

    @FindBy(xpath = "//a[@href='/' and @data-test='site-logo']")
    public WebElement mainPageButton;

    public void mainPagebuttonClick(){
        mainPageButton.click();
    }

    public void ButtonDownloadPhpStormClick() {
        ButtonDownloadPhpStorm.click();
    }

    public PhpStormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
