package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.aquapages.AquaDownloadPage;
import com.example.jetbrainstest.pages.aquapages.AquaPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class AquaTest extends BaseTest {

    private AquaPage aquaPage;
    private AquaDownloadPage aquaDownloadPage;
    @BeforeEach
    @Override
    @Step("Переход на страницу aqua")
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/aqua/");
        aquaPage = new AquaPage(getDriver());
        aquaDownloadPage = new AquaDownloadPage(getDriver());
    }
    @Test
    @DisplayName("Проверка перехода по ссылке на главную страницу")
    public void mainLinkChecking(){
        aquaPage.mainPageButtonClick();
        assertEquals("https://www.jetbrains.com/", getDriver().getCurrentUrl(), "Открылась неверная сслыка");
    }
    @Test
    @DisplayName("Проверка перехода по сслыке на страницу Aqua")
    public void aquaLinkChecking(){
        aquaPage.aquaPageLinkClick();
        assertEquals("https://www.jetbrains.com/aqua/", getDriver().getCurrentUrl(), "Открылась неверная сслыка");
    }
    @Test
    @DisplayName("Проверка активности кнопки Features")
    public void featuresButtonCheck(){
        assertTrue(aquaPage.featuresAquaButtonIsClickable(), "Кнопка Features не активна");
    }
    @Test
    @DisplayName("Проверка активности кнопки Documentation")
    public void buttonCheck(){
        assertTrue(aquaPage.documentationAquaButtonIsClickable(), "Кнопка Documentation не активна");
    }
    @Test
    @DisplayName("Проверка активности кнопки Download")
    public void downloadButtonCheck(){
        assertTrue(aquaPage.downloadAquaButtonIsClickable(), "Кнопка Download не активна");
    }
    @Test
    @DisplayName("Проверка названия кнопки Download Preview")
    public void switcherButtonName(){
        String btnName = "Download Preview";
        assertEquals(btnName, aquaPage.downloadPreviewButtonName(), "Кнопка с нужным названием не находится на странице");
    }
    @Test
    @DisplayName("Проверка Learn more для Selenium")
    public void learnMoreSelenium(){
        assertTrue(aquaPage.learnMore(0).contains("selenium"), "Ссылка не ведёт на страницу Selenium support in Aqua");
    }
    @Test
    @DisplayName("Проверка Learn more для Cypress")
    public void learnMoreCypress(){
        assertTrue(aquaPage.learnMore(1).contains("cypress"), "Ссылка не ведёт на страницу Cypress support in Aqua");
    }
    @Test
    @DisplayName("Проверка Learn more для Playwright")
    public void learnMorePlaywright(){
        assertTrue(aquaPage.learnMore(2).contains("playwright"), "Ссылка не ведёт на страницу Playwright support in Aqua");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download Toolbox App для Windows")
    public void downloadToolboxAppButtonForWindows(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadToolboxApp(0), "Кнопка Download Toolbox App для Windows не кликабельная");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download Toolbox App для macOS")
    public void downloadToolboxAppButtonForMacOS(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadToolboxApp(1), "Кнопка Download Toolbox App для macOS не кликабельная");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download Toolbox App для Linux")
    public void  downloadToolboxAppButtonForLinux(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadToolboxApp(2), "Кнопка Download Toolbox App для Linux не кликабельная");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download IDE для Windows")
    public void downloadIDEButtonForWindows(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadIDEButton(0), "Кнопка Download IDE для Windows не кликабельная");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download IDE для macOS")
    public void downloadIDEButtonForMacOS(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadIDEButton(1), "Кнопка Download IDE для macOS не кликабельная");
    }
    @Test
    @DisplayName("Проверка кликабельности кнопки Download IDE для Linux")
    public void  downloadIDEButtonForLinux(){
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.downloadIDEButton(2), "Кнопка Download IDE для Linux не кликабельная");
    }
    @Test
    @DisplayName("Проверка первого пункта из списка системных требований для Windows")
    public void systemRequirementsForWindows(){
        String pointValue = "64-bit version of Windows 10 1809 and later, or Windows Server 2019 and later";
        aquaPage.downloadAquaButtonClick();
        assertEquals(pointValue, aquaDownloadPage.systemRequirementsPopupWindow(0), "Отображены неверные системные требования");
    }
    @Test
    @DisplayName("Проверка первого пункта из списка системных требований для MacOS")
    public void systemRequirementsForMacOS(){
        String pointValue = "macOS 10.15 and later";
        aquaPage.downloadAquaButtonClick();
        assertEquals(pointValue, aquaDownloadPage.systemRequirementsPopupWindow(1), "Отображены неверные системные требования");
    }
    @Test
    @DisplayName("Проверка первого пункта из списка системных требований для Linux")
    public void systemRequirementsForLinux(){
        String pointValue = "GNOME or KDE desktop";
        aquaPage.downloadAquaButtonClick();
        assertEquals(pointValue, aquaDownloadPage.systemRequirementsPopupWindow(2), "Отображены неверные системные требования");
    }
    @Test
    @DisplayName("Проверка первого пункта из инструкции по установке для Windows")
    public void installationInstructionsForWindows(){
        String pointValue = "Run the aqua-2023.1.exe file that starts the Installation Wizard";
        aquaPage.downloadAquaButtonClick();
        assertEquals(pointValue, aquaDownloadPage.installationInstructionsPopupWindow(0), "Отображена неверная инструкция по установке");
    }
    @Test
    @DisplayName("Проверка первого пункта из инструкции по установке для macOS")
    public void installationInstructionsForMacOS(){
        String pointValue = "Download the aqua-2023.1.dmg macOS Disk Image file";
        aquaPage.downloadAquaButtonClick();
        assertEquals(pointValue, aquaDownloadPage.installationInstructionsPopupWindow(1), "Отображена неверная инструкция по установке");
    }
    @Test
    @DisplayName("Проверка первого пункта из инструкции по установке для Linux")
    public void installationInstructionsForLinux(){
        String pointValue = "Unpack the aqua-2023.1.tar.gz file to an empty directory using the following command: tar -xzf aqua-2023.1.tar.gz";
        aquaPage.downloadAquaButtonClick();
        assertTrue(aquaDownloadPage.installationInstructionsPopupWindow(2).contains(pointValue), "Отображена неверная инструкция по установке");
    }
}
