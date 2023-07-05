package com.example.jetbrainstest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

//page_url = https://www.jetbrains.com/datagrip/
public class DataGripPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@class,'wt-button wt-button_mode_contrast')]")
    private WebElement downloadDataGripButton;

    @FindBy(xpath = "//button[text()='Take a tour']")
    private WebElement clickTakeATourButton;

    @FindBy(xpath = "//button[normalize-space()='.exe']")
    private WebElement downloadListResult;

    @FindBy(xpath = "(//li[@class='_wrapper_1v6h6tr_8'])")
    private List <WebElement> resultsComboBox;

    @FindBy(xpath = "//button[@data-test='youtube-player-button']")
    private WebElement clickVideo;

    @FindBy(xpath = "//button[@data-test='close-button']")
    private WebElement closeVideoButton;

    @FindBy(xpath = "//iframe[@id='widget4']")
    private WebElement videoPlayer;

    public List<WebElement> getComboBoxes() {
        downloadListResult.click();
        List<WebElement> comboBoxes = resultsComboBox;
        for (WebElement comboBox : comboBoxes) {
            System.out.println("ComboBox DataGrip button download: " + comboBox.getText());
        }
        return comboBoxes;
    }

    public void clickButtonDataGripDownload(){
        downloadDataGripButton.click();
    }

    public void clickButtonTakeATour(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 700)", "");
        clickTakeATourButton.click();
    }

    public boolean checkTakeATourButton(){
        System.out.println("Проверка активности кнопки");
        return clickTakeATourButton.isEnabled();
    }

    public void clickPlayAndStopPlayer(){
        clickVideo.click();
        videoPlayer.click();
        waitSleep();
    }

    public boolean isPlayerClosed(){return !closeVideoButton.isEnabled();}

    public void waitSleep(){
        try {
            Thread.sleep(7000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DataGripPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

}