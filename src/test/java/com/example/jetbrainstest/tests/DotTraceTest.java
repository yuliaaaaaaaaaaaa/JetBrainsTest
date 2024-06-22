package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.DotTracePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DotTraceTest extends BaseTest {

    private DotTracePage DotTracePage;

    @BeforeEach
    @Override
    @Step("Переход в раздел dotTrace")
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/profiler/");
        DotTracePage = new DotTracePage(getDriver());
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
        assertTrue(DotTracePage.partofdotUltimateElementIsDisplayed(), "Элемента Part of dotUltimate нет на странице");
    }

    @Test
    @DisplayName("Проверка, что элемент Optimize.NETApplications есть на странице")
    public void optimizeNETApplicationsTest() {
        assertTrue(DotTracePage.optimizeNETApplicationsIsDisplayed(), "Элемента Optimize.NETApplications нет на странице");
    }

    @Test
    @DisplayName("Переход в раздел Features по кнопке More Features")
    public void moreFeaturesTest() {
        String expectedUrl = "https://www.jetbrains.com/profiler/features/";
        String actualUrl = DotTracePage.MoreFeaturesButtonClick();
        assertEquals(expectedUrl, actualUrl, "Переход не на ту страницу");
    }
}
