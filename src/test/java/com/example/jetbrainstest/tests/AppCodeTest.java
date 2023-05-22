package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.AppCodePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppCodeTest extends BaseTest {

    private AppCodePage appCodePage;
    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/objc/");
        appCodePage = new AppCodePage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck(){
        assertTrue(appCodePage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }
}
