package com.example.jetbrainstest.pages;

import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

//page url = https://www.jetbrains.com/clion/
public class CLionPage extends BaseTest {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CLionPage.class));
    WebDriver driver;

    @FindBy(css = "a[href=\"/clion/download/\"]")
    private WebElement downloadButton;

    @FindBy(css = "button[data-test=\"youtube-player-button\"]")
    private WebElement imgVideoButton;

    @FindBy(css = "iframe[title=\"CLion Quick Tour\"]")
    private WebElement videoIframe;

    @FindBy(css = "#player a[href^=\"https://www.youtube.com/watch\"]")
    private WebElement videoTitle;

    @FindBy(css = ".social-footer__link")
    private List<WebElement> followButtons;

    @FindBy(css = "[name='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private  WebElement emailSubmit;

    @FindBy(css = ".social-footer p:last-child")
    private WebElement MessageAfterEnteringValidEmail;

    @FindBy(css = "[data-test=\"error-message\"]")
    private WebElement MessageAfterEnteringInvalidEmail;

    public CLionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void switchOnIframe() {
        imgVideoButton.click();
        driver.switchTo().frame(videoIframe);
        LOG.info("Переключение на frame с видео");
    }

    public String getNameOfVideo() {
        switchOnIframe();
        String titleVideo = videoTitle.getText();
        LOG.infoWithScreenshot("Получение названия видео");
        return titleVideo;
    }

    public List<Boolean> checkIfFollowButtonsAreClickable() {
        List<Boolean> statusOfFollowButtons = new ArrayList<>();
        for (WebElement i: followButtons) {
            statusOfFollowButtons.add(i.isEnabled());
        }
        LOG.infoWithScreenshot("Получение активности кнопок из блока Follow Us");
        return statusOfFollowButtons;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
        emailSubmit.click();
    }

    public String enterValidEmailAndGetAnswerAboutSuccess(String email) {
        enterEmail(email);
        return MessageAfterEnteringValidEmail.getText();
    }

    public String enterInvalidEmailAndGetWarning(String email) {
        enterEmail(email);
        return MessageAfterEnteringInvalidEmail.getText();
    }
}
