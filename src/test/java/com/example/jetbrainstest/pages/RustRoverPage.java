package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//https://www.jetbrains.com/rust/
public class RustRoverPage
{
    WebDriver driver;
    @FindBy(css = "a[href='/rust/download/']")
    private WebElement downloadRustPreview;

    public String clickRustDownloadAndCheckUrl(){
        driver.get("https://www.jetbrains.com/rust/");
        downloadRustPreview.click();
        return driver.getCurrentUrl();
    }
    public RustRoverPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
