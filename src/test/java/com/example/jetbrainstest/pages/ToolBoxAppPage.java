package com.example.jetbrainstest.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//https://www.jetbrains.com/toolbox-app/
public class ToolBoxAppPage {
    WebDriver driver;
    @FindBy(css = "button[data-test='submit-button']")
    private WebElement submitButton;

    public void clickSubmitButton(){
        submitButton.click();
    }
    @FindBy(css = "input[name = 'email']")
    private WebElement inputEmail;

    public void setWrongEmail(String wrongEmail){
        inputEmail.sendKeys(wrongEmail);
        inputEmail.submit();
        System.out.println("В поле Email передано значение " + wrongEmail);
    }


    @FindBy(css = "div[data-test='input__error-message']")
    private static WebElement validMessage;
    public static WebElement getValidMessage(){
        return validMessage;
    }
    public Boolean checkIfValidMessageIsDisplayed(){
        return validMessage.isDisplayed();
    }

    public Boolean checkIfSubmitButtonIsEnable(){
        System.out.println("Проверка активности кнопки отправки");
        return submitButton.isEnabled();
    }

    @FindBy(css = "ul[data-test='dropdown-menu']")
    private WebElement dropDownMenu;
    public Boolean checkIfDropDownMenuIsDisplayed(){
        System.out.println("Проверка, что появилось дропдаун меню");
        return dropDownMenu.isDisplayed();
    }
    @FindBy(css = ".scroll-wrapper button")
    private WebElement dropDownMenuButton;
    public void clickDropDownMenuButton(){

        dropDownMenuButton.click();
    }
    public ToolBoxAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
