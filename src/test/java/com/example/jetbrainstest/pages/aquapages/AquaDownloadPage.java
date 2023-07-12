package com.example.jetbrainstest.pages.aquapages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

//page_url = https://www.jetbrains.com/aqua/download/
public class AquaDownloadPage {

    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AquaDownloadPage.class));

    @FindBy(xpath = "//a[text()='Download Toolbox App']")
    private List<WebElement> downloadToolboxApp;
    @FindBy(xpath = "//a[text()='Download IDE']")
    private List<WebElement> downloadIDEButton;
    @FindBy(xpath = "//div[@role='tab']//div")
    private List<WebElement> osTabs;

    /**
     * System requirements
     */
    @FindBy(xpath = "//span[text()='System requirements']")
    private List<WebElement> systemRequirements;
    @FindBy(xpath = "//ul[@data-test='system-requirements-list']//li")
    private List<WebElement> systemRequirementsList;

    /**
     * Installation instructions
     */
    @FindBy(xpath = "//span[text()='Installation instructions']")
    private List<WebElement> installationInstructions;

    @FindBy(xpath = "//ol[@data-test='installation-instructions-list']//li")
    private List<WebElement> installationInstructionsList;


    public Boolean downloadToolboxApp(int id) {
        LOG.info("Проверка кликабельности кнопки загрузки Toolbox App");
        osTabs.get(id).click();
        return downloadToolboxApp.get(id).isDisplayed();
    }

    public Boolean downloadIDEButton(int id) {
        LOG.info("Проверка кликабельности кнопки загрузки IDE");
        osTabs.get(id).click();
        return downloadIDEButton.get(id).isDisplayed();
    }

    public String systemRequirementsPopupWindow(int id) {
        osTabs.get(id).click();
        systemRequirements.get(id).click();
        LOG.info("Проверка отображения системных требований");
        return systemRequirementsList.get(0).getText();
    }

    public String installationInstructionsPopupWindow(int id) {
        osTabs.get(id).click();
        installationInstructions.get(id).click();
        LOG.info("Проверка отображения инструкции по установке");
        return installationInstructionsList.get(0).getText();
    }

    public AquaDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
