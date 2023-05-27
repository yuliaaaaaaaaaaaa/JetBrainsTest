package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.AquaPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AquaTest extends BaseTest {

    private AquaPage aquaPage;
    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/aqua/");
        aquaPage = new AquaPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck(){
        assertTrue(aquaPage.downloadAquaButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка ссылки на активную страницу")
    public void linkChecking(){
        aquaPage.mainPageButtonClick();
        assertEquals("https://www.jetbrains.com/", getDriver().getCurrentUrl(), "Открылась неверная сслыка");
    }

    @Test
    @DisplayName("Проверка названия кнопки")
    public void switcherButtonName(){
        String btnName = "Get the plugin for your IDE";
        assertEquals(btnName, aquaPage.buttonName(), "Кнопка с нужным названием не находится на странице");
    }
}
