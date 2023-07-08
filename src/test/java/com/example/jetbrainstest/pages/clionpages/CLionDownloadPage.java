package com.example.jetbrainstest.pages.clionpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class CLionDownloadPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CLionPage.class));
    private final WebDriver driver;

    public CLionDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href=\"/clion/download/\"]")
    private WebElement downloadButton;

    @FindBy(xpath = "//button[contains(text(), '.exe')]")
    private WebElement exeButton;

    @FindBy(xpath = "//button[contains(text(), '.exe')]")
    private WebElement zipButton;

    @FindBy(xpath = "//span[contains(text(), 'Installation instructions')]")
    private WebElement InstructionButton;

    @FindBy(xpath = "//div[contains(text(), 'Installation instructions')]")
    private WebElement instructionHeaderText;

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void clickExe() {
        LOG.info("Клик по выпадающему списку .exe");
        exeButton.click();
    }

    public Boolean checkIfZipButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки в формате .zip");
        return zipButton.isEnabled();
    }

    public void clickInstruction() {
        LOG.info("Клик по кнопке с инструкцией по установке");
        InstructionButton.click();
    }

    public Boolean checkIfHeaderInstructionIsDisplayed() {
        LOG.info("Проверка, что заголовок окна инструкции по установке виден");
        return instructionHeaderText.isDisplayed();
    }
}
