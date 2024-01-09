package com.example.jetbrainstest.pages.youtrackpages;

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

// https://www.jetbrains.com/youtrack/teams/
public class YouTrackTeamsPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(YouTrackPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/development.html\"]")
    private WebElement DevelopersTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/marketing.html\"]")
    private WebElement MarketingTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/helpdesk/\"]")
    private WebElement SupportTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/management.html\"]")
    private WebElement PMTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/design.html\"]")
    private WebElement DesignTeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/qa.html\"]")
    private WebElement QATeam;

    @FindBy(xpath = "//a[@href=\"/youtrack/teams/operations.html\"]")
    private WebElement OperationsTeam;

    public String checkIfDevelopersTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Developers");
        DevelopersTeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfMarketingTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Marketing");
        MarketingTeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfSupportTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Support");
        SupportTeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfManagementTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Product Management");
        PMTeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfDesignTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Designers");
        DesignTeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfQATeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел QA");
        QATeam.click();
        return driver.getCurrentUrl();
    }
    public String checkIfOperationsTeamsIsWorking(){
        LOG.infoWithScreenshot("Переход в раздел Operations and Legal");
        OperationsTeam.click();
        return driver.getCurrentUrl();
    }
    public YouTrackTeamsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}