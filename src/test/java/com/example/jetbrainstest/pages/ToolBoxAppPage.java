package com.example.jetbrainstest.pages;
import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.tests.ToolBoxAppTest;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//https://www.jetbrains.com/toolbox-app/
public class ToolBoxAppPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxAppPage.class));
    WebDriver driver;

    @FindBy(css = "button[data-test='submit-button']")
    private WebElement submitButton;

    public void clickSubmitButton(){
        submitButton.click();
        LOG.info("Нажали на кнопку \"Submit\"");
    }
    @FindBy(css = "input[name = 'email']")
    private WebElement inputEmail;

    public void setWrongEmail(String wrongEmail){
        inputEmail.sendKeys(wrongEmail);
        inputEmail.submit();
        LOG.info("В поле Email передано значение " + wrongEmail);

    }
    @FindBy(css = "div[data-test='input__error-message']")
    private static WebElement validMessage;
    public static WebElement getValidMessage(){
        return validMessage;
    }
    public Boolean checkIfValidMessageIsDisplayed(){
        LOG.infoWithScreenshot("Проверка, что валидация отобразилась");
        return validMessage.isDisplayed();
    }

    public Boolean checkIfSubmitButtonIsEnable(){
        LOG.info("!Проверка активности кнопки отправки!");
        return submitButton.isEnabled();
    }

    @FindBy(css = "ul[data-test='dropdown-menu']")
    private WebElement dropDownMenu;

    @Step("!Проверка, что появилось дропдаун меню!")
    public Boolean checkIfDropDownMenuIsDisplayed(){
        LOG.infoWithScreenshot("!Проверка, что появилось дропдаун меню!");
        return dropDownMenu.isDisplayed();
    }
    @FindBy(css = ".scroll-wrapper button")
    private WebElement dropDownMenuButton;

    public void clickDropDownMenuButton(){
        dropDownMenuButton.click();
        LOG.info("Нажати на кнопку .exe");
    }
    public ToolBoxAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
