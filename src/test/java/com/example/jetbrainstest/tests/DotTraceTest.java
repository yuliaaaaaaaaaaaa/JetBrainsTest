package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.DotTraceMyExtension;
import com.example.jetbrainstest.pages.dottracepages.DotTracePage;
import com.example.jetbrainstest.pages.dottracepages.DownloadDotTracePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(DotTraceMyExtension.class)
public class DotTraceTest extends BaseTest {

    private DotTracePage DotTracePage;
    private DownloadDotTracePage DownloadDotTracePage;

    @BeforeEach
    @Override
    @Step("Переход в раздел dotTrace")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/profiler/");
        DotTracePage = new DotTracePage(getDriver());
        DownloadDotTracePage = new DownloadDotTracePage(getDriver());
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @DisplayName("Проверка активности кнопки Download")
    public void downloadButtonTest() {
        assertTrue(DotTracePage.downloadButtonIsClickable(), "Кнопка Download не активна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Pricing")
    public void pricingButtonTest() {
        assertTrue(DotTracePage.pricingButtonIsClickable(), "Кнопка Pricing не активна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Check out our memory profiler")
    public void checkOutOurMemoryProfilerTest() {
        assertTrue(DotTracePage.checkOutOurMemoryProfilerButtonIsClickable(), "Кнопка Check out our memory profiler не активна");
    }

    @Test
    @DisplayName("Проверка, что элемент Part of dotUltimate есть на странице")
    public void partofdotUltimateTest() {
        assertTrue(DotTracePage.partOfDotUltimateElementIsDisplayed(), "Элемента Part of dotUltimate нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Optimize.NETApplications есть на странице")
    public void optimizeNETApplicationsTest() {
        assertTrue(DotTracePage.optimizeNetApplicationsIsDisplayed(), "Элемента Optimize.NETApplications нет на странице");
    }

    @Test
    @DisplayName("Переход в раздел Features по кнопке More Features")
    public void moreFeaturesTest() {
        String expectedUrl = "https://www.jetbrains.com/profiler/features/";
        String actualUrl = DotTracePage.MoreFeaturesButtonClick();
        assertEquals(expectedUrl, actualUrl, "Переход не на ту страницу");
    }

    @Test
    @DisplayName("Проверка, что элемент Early Access есть на странице")
    public void earlyAccessTest() {
        assertTrue(DotTracePage.earlyAccessElementIsDisplayed(), "Элемента Early Access нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент What's New есть на странице")
    public void whatsNewTest() {
        assertTrue(DotTracePage.whatsNewElementIsDisplayed(), "Элемента What's New нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Features есть на странице")
    public void featuresTest() {
        assertTrue(DotTracePage.featuresElementIsDisplayed(), "Элемента Features нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент ETW есть на странице")
    public void etwTest() {
        assertTrue(DotTracePage.etwElementIsDisplayed(), "Элемента ETW нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Docs & Demos есть на странице")
    public void docsDemosTest() {
        assertTrue(DotTracePage.docsDemosElementIsDisplayed(), "Элемента Docs & Demos нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Blog & Social есть на странице")
    public void blogSocialTest() {
        assertTrue(DotTracePage.blogSocialElementIsDisplayed(), "Элемента Blog & Social нет на странице");
    }

    @Test
    @DisplayName("Проверка, перехода на страницу скачивания DotTrace")
    public void downloadButtonClickTest() {
        String expectedUrl = "https://www.jetbrains.com/profiler/download/#section=portable";
        String actualUrl = DotTracePage.downloadButtonClick();
        assertEquals(expectedUrl, actualUrl, "Переход не на ту страницу");
    }

    @Test
    @DisplayName("Проверка, что текст Download dotTrace есть на странице")
    public void downloadDotTraceTextTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.downloadDotTraceTextIsDisplayed(),"Текста Download dotTrace на странице нет");
    }

    @Test
    @DisplayName("Проверка активности левой кнопки Download")
    public void downloadLeftButtonTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.downloadLeftButtonIsClickable(),"Левая кнопка Download не активна");
    }

    @Test
    @DisplayName("Проверка активности правой кнопки Download (Windows)")
    public void downloadRightButtonTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.downloadRightButtonIsClickable(),"Правая кнопка Download(Windows) не активна");
    }

    @Test
    @DisplayName("Проверка, что выпадающее меню есть на странице, после нажатия на правую кнопку Download (Windows)")
    public void downloadRightButtonClickTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.downloadRightButtonClick());
    }

    @Test
    @DisplayName("Проверка, что элемент Get the Toolbox есть на странице")
    public void getTheToolboxElementIsDisplayedTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.getTheToolboxElementIsDisplayed(),"Элемента Get the Toolbox нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Get the Toolbox активен")
    public void getTheToolboxElementIsClickableTest() {
        DotTracePage.downloadButtonClick();
        assertTrue(DownloadDotTracePage.getTheToolboxElementIsClickable(),"Элемент Get the Toolbox не активен");
    }

    @Test
    @DisplayName("Проверка, перехода на страницу JetBrains Toolbox App нажатием на элемент Get the Toolbox")
    public void getTheToolboxElementClickTest() {
        DotTracePage.downloadButtonClick();
        String expectedUrl = "https://www.jetbrains.com/toolbox-app/";
        String actualUrl = DownloadDotTracePage.getTheToolboxElementClick();
        assertEquals(expectedUrl, actualUrl, "Переход не на ту страницу");
    }
}
