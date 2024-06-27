package com.example.jetbrainstest.pages.dottracepages;

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

    @FindBy(xpath = "//*[@id=\"js-menu-second-desktop\"]/a[@href=\"/profiler/buy/\"]")
    private WebElement PricingButton;

    @FindBy(xpath = "//div[contains(@class, 'wt-col-sm-12')][.//a[contains(@class, 'header-section__button')]]")
    private WebElement CheckOutOurMemoryProfilerButton;

    @FindBy(xpath = "//div/a[@href=\"/dotnet\"]")
    private WebElement PartOfDotUltimateElement;

    @FindBy(xpath = "//h2[@class='rs-h2 rs-h2_theme_dark wt-offset-top-96']")
    private WebElement OptimizeNETApplications;

    @FindBy(xpath = "//a[@href='/profiler/features']")
    private WebElement MoreFeaturesButton;

    @FindBy(xpath = "//a[@href='/resharper/nextversion/']")
    private WebElement EarlyAccessElement;

    @FindBy(xpath = "//a[@href='/profiler/whatsnew/']")
    private WebElement WhatsNewElement;

    @FindBy(xpath = "//a[@href='/profiler/features/']")
    private WebElement FeaturesElement;

    @FindBy(xpath = "//a[@href='/profiler/etw/']")
    private WebElement EtwElement;

    @FindBy(xpath = "//a[@href='/profiler/documentation/']")
    private WebElement DocsDemosElement;

    @FindBy(xpath = "//a[@href='/profiler/social/']")
    private WebElement BlogSocialElement;

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
        MoreFeaturesButton.click();
        return driver.getCurrentUrl();
    }

    public Boolean earlyAccessElementIsDisplayed() {
        LOG.info("Проверка, что элемент Early Access есть на странице");
        return EarlyAccessElement.isDisplayed();
    }

    public Boolean whatsNewElementIsDisplayed() {
        LOG.info("Проверка, что элемент What's New есть на странице");
        return WhatsNewElement.isDisplayed();
    }

    public Boolean featuresElementIsDisplayed() {
        LOG.info("Проверка, что элемент Features есть на странице");
        return FeaturesElement.isDisplayed();
    }

    public Boolean etwElementIsDisplayed() {
        LOG.info("Проверка, что элемент ETW есть на странице");
        return EtwElement.isDisplayed();
    }

    public Boolean docsDemosElementIsDisplayed() {
        LOG.info("Проверка, что элемент Docs & Demos есть на странице");
        return DocsDemosElement.isDisplayed();
    }

    public Boolean blogSocialElementIsDisplayed() {
        LOG.info("Проверка, что элемент Blog & Social есть на странице");
        return BlogSocialElement.isDisplayed();
    }

    public DotTracePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String downloadButtonClick() {
        LOG.info("Нажатие на кнопку Download");
        DownloadButton.click();
        return driver.getCurrentUrl();
    }
}
