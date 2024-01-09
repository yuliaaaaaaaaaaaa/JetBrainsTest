package com.example.jetbrainstest.pages.youtrackpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

// https://www.jetbrains.com/youtrack/
public class YouTrackPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(YouTrackPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/youtrack/whatsnew/']")
    private WebElement WhatsNewButton;

    @FindBy(xpath = "//a[@href='/youtrack/agile/']")
    private WebElement AgileButton;

    @FindBy(xpath = "//a[@href='/youtrack/teams/']")
    private WebElement TeamsButton;

    @FindBy(xpath = "//a[@href='/youtrack/features/']")
    private WebElement FeaturesButton;

    @FindBy(xpath = "//a[@href='/youtrack/helpdesk/']")
    private WebElement HelpdeskButton;

    @FindBy(xpath = "//a[@href='/youtrack/support/']")
    private WebElement SupportButton;

    @FindBy(xpath = "//a[@href='/youtrack/buy/']")
    private WebElement PricingButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[1]")
    private WebElement YTProjectsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[2]")
    private WebElement YTTasksButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[3]")
    private WebElement YTAiAssistantButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[4]")
    private WebElement YTKnowledgeBaseButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[5]")
    private WebElement YTAgileBoardsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[6]")
    private WebElement YTTimesheetsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[7]")
    private WebElement YTGanttChartsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[8]")
    private WebElement YTReportsButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[9]")
    private WebElement YTHelpdeskButton;

    @FindBy(xpath = "(//div[contains(@class, '_alignCenter_zzkm1p_72')]//button)[10]")
    private WebElement YTWorkflowsButton;

    public Boolean checkIfWhatsNewButtonIsClickable(){
        LOG.infoWithScreenshot("Проверка кликабельности кнопки What's New");
        return  WhatsNewButton.isEnabled();
    }

    public Boolean checkIfAgileButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Agile");
        return  AgileButton.isEnabled();
    }

    public Boolean checkIfTeamsButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Teams");
        return  TeamsButton.isEnabled();
    }

    public Boolean checkIfFeaturesButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Features");
        return  FeaturesButton.isEnabled();
    }

    public Boolean checkIfHelpdeskButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Helpdesk");
        return  HelpdeskButton.isEnabled();
    }

    public Boolean checkIfSupportButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Support");
        return  SupportButton.isEnabled();
    }

    public Boolean checkIfPricingButtonIsClickable(){
        LOG.info("Проверка кликабельности кнопки Pricing");
        return  PricingButton.isEnabled();
    }

    public Boolean checkIfYTProjectsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Projects");
        return YTProjectsButton.isEnabled();
    }

    public Boolean checkIfYTTasksButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Tasks");
        return YTTasksButton.isEnabled();
    }

    public Boolean checkIfAiAssistantButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки AI Assistant");
        return YTAiAssistantButton.isEnabled();
    }

    public Boolean checkIfYTKnowledgeBaseButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Knowledge Base");
        return YTKnowledgeBaseButton.isEnabled();
    }

    public Boolean checkIfYTAgileBoardsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Agile Boards");
        return YTAgileBoardsButton.isEnabled();
    }

    public Boolean checkIfYTTimesheetsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Timesheets");
        return YTTimesheetsButton.isEnabled();
    }

    public Boolean checkIfYTGanttChartsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Gantt Charts");
        return YTGanttChartsButton.isEnabled();
    }

    public Boolean checkIfYTReportsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Reports");
        return YTReportsButton.isEnabled();
    }

    public Boolean checkIfYTHelpdeskButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Helpdesk");
        return YTHelpdeskButton.isEnabled();
    }

    public Boolean checkIfYTWorkflowsButtonIsClickable() {
        LOG.info("Проверка кликабельности кнопки Workflows");
        return YTWorkflowsButton.isEnabled();
    }

    public String checkIfTeamsButtonIsWorking() {
        LOG.info("Переход на страницу Teams");
        TeamsButton.click();
        return driver.getCurrentUrl();
    }

    public YouTrackPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}