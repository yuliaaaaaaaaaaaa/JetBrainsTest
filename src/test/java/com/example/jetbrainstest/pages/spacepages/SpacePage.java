package com.example.jetbrainstest.pages.spacepages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

// page_url = https://www.jetbrains.com/space
public class SpacePage {
    private final Logger LOG = LoggerFactory.getLogger(SpacePage.class);
    WebDriver driver;
    @FindBy(css = "._siteLogo__image_nnydt:first-child")
    private WebElement logoButton;

    @FindBy(css = "[aria-label='Developer Tools: Open submenu'][data-test='main-menu-item-action']")
    private WebElement devToolsButton;

    @FindBy(css ="._mainMenuItemActive_ntjw4[data-test-marker='Developer Tools']")
    private WebElement topMenu;

    @FindBy(css ="[aria-label='Team Tools: Open submenu'][data-test='main-menu-item-action']")
    private WebElement teamToolsButton;

    @FindBy(css = "[aria-label='Open language selection'][data-test='language-picker']")
    private WebElement langMenuButton;

    @FindBy(xpath = "//*[text() = 'Русский']")
    private WebElement rusLangButton;
    @FindBy(css= "[type='submit']")
    private WebElement submitButton;

    @FindBy(css= " [data-test='input input-with-error']")
    private WebElement emptyFieldError;

    @FindBy(css = "[data-test='footer-country-button']")
    private WebElement countryButton;

    @FindBy(css = "[data-test='search-input']")
    private WebElement changeCountryField;

    @FindBy(css = "[data-test='footer-popup-confirm-country']")
    private WebElement changeCountryButton;

    @FindBy(css = "[data-test='checkbox-icon']")
    private WebElement checkBox;

    @FindBy(css = "body")
    private WebElement bodyPage;

    @FindBy(css = "[data-test='site-header-search-action']")
    private WebElement searchIconButton;

    @FindBy(css = "[data-test='search-input'][placeholder]")
    private WebElement searchField;

    @FindBy(xpath = "//*[text()='On-Premises']")
    private WebElement onPremisButton;

    public void clickLogoButton(){
        logoButton.click();
        LOG.info("Кликнули по кнопке лого");
    }

    public Boolean isDisplayedDevToolsButton(){
        return devToolsButton.isDisplayed();
    }

    public Boolean isDisplTopMenu(){
        devToolsButton.click();
        LOG.info("Кликнули по кнопке " + devToolsButton.getText());
        return topMenu.isDisplayed();
    }

    public String getOpacityOnFocusTeamToolsButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        devToolsButton.sendKeys(Keys.TAB);
        LOG.info("Установили фокус на кнопке " + teamToolsButton.getText());
        wait.until(ExpectedConditions.attributeToBe(teamToolsButton,"opacity","1"));
        return teamToolsButton.getCssValue("opacity");
    }

    public Boolean isDisplayedRusLangButton(){
        langMenuButton.click();
        LOG.info("Кликнули по кнопке выбора языка");
        return rusLangButton.isDisplayed();
    }

    public Boolean isDisplayedEmptyFieldError(){
        submitButton.click();
        LOG.info("Кликнули по кнопке " + submitButton.getText());
        return emptyFieldError.isDisplayed();
    }

    public String changeCountry(){
        countryButton.click();
        LOG.info("Кликнули по кнопке выбора страны");
        changeCountryField.sendKeys("France");
        LOG.info("Напечатали в поле ввода: France");
        changeCountryField.sendKeys(Keys.ENTER);
        LOG.info("Нажали Enter");
        changeCountryButton.click();
        LOG.info("Кликнули по кнопке Choose");
        return countryButton.getText();
    }

    public Boolean isCheckedCheckBox(){
        return checkBox.isSelected();
    }

    public void goSearchPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        bodyPage.sendKeys(Keys.CONTROL + "k");
        LOG.info("Нажали комбинацию клавиш Ctrl+K");
        wait.until(ExpectedConditions.urlToBe("https://www.jetbrains.com/space/?s=full"));
    }

    public String getSearchFieldText(){
        searchIconButton.click();
        LOG.info("Кликнули по иконке лупы");
        return searchField.getAttribute("placeholder");
    }

    public String getColorOnPremisButton(){
        return onPremisButton.getCssValue("background-color");
    }
    public String getCurrUrl(){
        return driver.getCurrentUrl();
    }

    public SpacePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);}
}