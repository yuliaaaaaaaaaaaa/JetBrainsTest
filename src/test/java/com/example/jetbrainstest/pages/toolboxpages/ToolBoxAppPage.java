package com.example.jetbrainstest.pages.toolboxpages;

import com.example.jetbrainstest.AllureLogger;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static com.example.jetbrainstest.MyWait.myWait;

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
    public void emailSend(String emailText){
        inputEmail.sendKeys(emailText);
        LOG.info("В поле Email передано значение " + emailText);
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
    @FindBy(css = ".toolbox-heading a[data-test = 'dropdown-button-link']")
    private WebElement downloadButton;
    public void clickDownloadButton(){
        downloadButton.click();
        LOG.info("Нажали на 1-ю кнопку download");
    }
    @FindBy(xpath = "//*[ text() = 'FAQ & Shortcuts' ]")
    private WebElement faqReference;
    public void faqRefClick(){
        faqReference.click();
        LOG.info("Нажали на ссылку FAQ & Shortcuts");
    }
    @FindBy(xpath = "//*[ text() = 'Blog & Social' ]")
    private WebElement blogSocialRef;
    public void blogSocialRefCLick(){
        blogSocialRef.click();
        LOG.info("Нажали на Blog & Social");
    }
    @FindBy(xpath = "//a[text() ='Other versions']")
    private WebElement otherVersioLink;
    public void otherVersioLinkClick() {
        LOG.info("Нажали на ссылку Other versions");
        otherVersioLink.click();
    }
    @FindBy(css = "div.toolbox-heading span[class= 'wt-link']")
    private WebElement systemReqFirstRef;

    @FindBy(css = "div[role = 'dialog']")
    private WebElement systemReqPopup;

    public void clickSystemReqFirstRef(){
        LOG.info("Нажали на ссылку System requirements");
        systemReqFirstRef.click();
    }
    public Boolean checkIfSystemReqPopupDisplayed(){
        myWait(10).visible(systemReqPopup);
        LOG.info("Проверка отображения попап окна System requirements");
        return systemReqPopup.isDisplayed();
    }
    @FindBy(css = "div.toolbox-primary-colors p.rs-text-2")
    private WebElement messageAfterSuccesfulEmailSubmit;
    public Boolean getMessageAfterSuccesfulEmailSubmit(){
        myWait(20).visible(messageAfterSuccesfulEmailSubmit);
        return messageAfterSuccesfulEmailSubmit.isDisplayed();
    }

    public ToolBoxAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
