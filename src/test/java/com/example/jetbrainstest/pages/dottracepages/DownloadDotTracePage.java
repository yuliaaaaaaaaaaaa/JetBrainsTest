package com.example.jetbrainstest.pages.dottracepages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class DownloadDotTracePage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DownloadDotTracePage.class));

    WebDriver driver;

    @FindBy(xpath = "//*[@class='wt-h2']")
    private WebElement DownloadDotTraceText;

    @FindBy(xpath = "//a[@href=\"/profiler/download/download-thanks.html?platform=windows32\"]")
    private WebElement DownloadLeftButton;

    @FindBy(xpath = "//div[@class=\"wt-css-content-switcher__block\"]//button")
    private WebElement DownloadRightButton;

    @FindBy(xpath = "//*[@data-test='dropdown-menu']")
    private WebElement DropdownMenu;

    @FindBy(xpath = "//*[@href='/toolbox/app/']")
    private WebElement GetTheToolboxElement;

    public Boolean downloadDotTraceTextIsDisplayed() {
        LOG.info("Проверка, что текст Download dotTrace есть на странице");
        return DownloadDotTraceText.isDisplayed();
    }

    public Boolean downloadLeftButtonIsClickable() {
        LOG.info("Проверка активности левой кнопки Download");
        return DownloadLeftButton.isEnabled();
    }

    public Boolean downloadRightButtonIsClickable() {
        LOG.info("Проверка активности правой кнопки Download (Windows)");
        return DownloadRightButton.isEnabled();
    }

    public Boolean downloadRightButtonClick() {
        LOG.info("Проверка, что выпадающее меню есть на странице, после нажатия на правую кнопку Download (Windows)");
        DownloadRightButton.click();
        return DropdownMenu.isDisplayed();
    }

    public Boolean getTheToolboxElementIsDisplayed() {
        LOG.info("Проверка, что элемент Get the Toolbox есть на странице");
        return GetTheToolboxElement.isDisplayed();
    }

    public Boolean getTheToolboxElementIsClickable() {
        LOG.info("Проверка, что элемент Get the Toolbox активен");
        return GetTheToolboxElement.isEnabled();
    }

    public String getTheToolboxElementClick() {
        LOG.info("Нажатие на элемент Get the Toolbox");
        GetTheToolboxElement.click();
        return driver.getCurrentUrl();
    }

    public DownloadDotTracePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
