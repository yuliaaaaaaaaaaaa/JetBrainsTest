package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class DotTracePage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DotTracePage.class));

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/profiler/download/']")
    private WebElement DownloadButton;

    @FindBy(xpath = "//*[@id=\"js-menu-second-desktop\"]/a[7]")
    private WebElement PricingButton;

    @FindBy(xpath = "//div[contains(@class, 'wt-col-sm-12')][.//a[contains(@class, 'header-section__button')]]")
    private WebElement CheckOutOurMemoryProfilerButton;

    @FindBy(xpath = "//div/a[@href=\"/dotnet\"]")
    private WebElement PartOfDotUltimateElement;

    @FindBy(xpath = "//h2[@class='rs-h2 rs-h2_theme_dark wt-offset-top-96']")
    private WebElement OptimizeNETApplications;

    @FindBy(xpath = "//a[@href='/profiler/features']")
    private WebElement MoreFeatures;

    public Boolean downloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки Download");
        return DownloadButton.isEnabled();
    }

    public Boolean pricingButtonIsClickable() {
        LOG.info("Проверка активности кнопки Pricing");
        return PricingButton.isEnabled();
    }

    public Boolean checkOutOurMemoryProfilerButtonIsClickable() {
        LOG.info("Проверка активности кнопки Check out our memory profiler");
        return CheckOutOurMemoryProfilerButton.isEnabled();
    }

    public Boolean partOfDotUltimateElementIsDisplayed() {
        LOG.info("Проверка, что элемент Part of dotUltimate есть на странице");
        return PartOfDotUltimateElement.isDisplayed();
    }

    public Boolean optimizeNetApplicationsIsDisplayed() {
        LOG.info("Проверка, что элемент Optimize.NETApplications есть на странице");
        return OptimizeNETApplications.isDisplayed();
    }

    public String MoreFeaturesButtonClick() {
        LOG.info("Нажатие на кнопку More Features");
        MoreFeatures.click();
        return driver.getCurrentUrl();
    }

    public DotTracePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
