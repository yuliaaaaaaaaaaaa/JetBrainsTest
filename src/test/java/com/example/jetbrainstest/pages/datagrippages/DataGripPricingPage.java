package com.example.jetbrainstest.pages.datagrippages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DataGripPricingPage {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(DataGripPage.class));

    @FindBy (xpath = "//div[contains(text(),'US $229.00')]")
    private WebElement priceYearlyBillingDataGrip;

    @FindBy (xpath = "//div[contains(text(),'US $779.00')]")
    private WebElement priceYearlyBillingAllProductsPack;

    @FindBy (xpath = "(//span[@data-test='switcher']//button)[2]")
    private WebElement switchPriceTariff;

    @FindBy (xpath = "//div[contains(text(),'US $22.90')]")
    private WebElement priceMonthlyBillingDataGrip;

    @FindBy (xpath = "//div[contains(text(),'US $77.90')]")
    private WebElement priceMonthlyBillingAllProductsPack;
    @FindBy (xpath = "//a[@href='https://www.jetbrains.com/shop/buy?item=C:N:DB:Y']")
    private WebElement bayButton;
    @FindBy (xpath = "//div[text()='FAQ']")
    private WebElement faqButton;
    @FindBy (xpath = "//a[normalize-space()='Business or Individual?']")
    private WebElement linkTextBusinessOrIndividual;



    public DataGripPricingPage(WebDriver driver){ //Конструктор
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

    public String checkPriceDataGripBasesBiling(){
        LOG.info("Проверка наличия текста");
        String value = priceYearlyBillingDataGrip.getText();
        LOG.info("Получен текст базовой годовой суммы: \"" + value + "\"");
        return value;
    }

    public String checkPriceAllProductsPack(){
        LOG.info("Проверка наличия текста");
        String value = priceYearlyBillingAllProductsPack.getText();
        LOG.info("Получен текст полного пакета годовой суммы: \"" + value + "\"");
        return value;
    }

    public void clickSwitchTariff(){
        LOG.info("Переключение тарифа");
        switchPriceTariff.click();
    }

    public String checkPriceMonthlyBillingDataGrip(){
        LOG.info("Проверка наличия текста");
        String value = priceMonthlyBillingDataGrip.getText();
        LOG.info("Получен текст месячной базовой суммы: \"" + value + "\"");
        return value;
    }

    public String checkPriceMonthlyBillingAllProductsPack(){
        LOG.info("Проверка наличия текста");
        String value = priceMonthlyBillingAllProductsPack.getText();
        LOG.info("Получен текст месячного пакета сумма: \"" + value + "\"");
        return value;
    }

    public void clickBayButton(){
        bayButton.click();
        LOG.info("Клик по кнопки Bay");
    }
    public void clickPricingFaq(){
        faqButton.click();
        LOG.info("Клик по кнопки Faq в разделе Subscription");
    }
    public void clickBusinessOrIndividualClickLink(){
        linkTextBusinessOrIndividual.click();
        LOG.info("Клик по текстовой ссылке Business Or Individual");
    }

    public String checkTitlePageBusinessOrIndividual(){
        LOG.info("Проверка наличия title");
        String actualTitle = driver.getTitle();
        LOG.info("Получен текст title страницы: \"" + actualTitle + "\"");
        return actualTitle;
    }


}
