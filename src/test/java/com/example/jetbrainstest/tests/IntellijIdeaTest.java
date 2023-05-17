package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.IntellijIdeaPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntellijIdeaTest extends BaseTest {

    private IntellijIdeaPage intellijIdeaPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        intellijIdeaPage = new IntellijIdeaPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck(){
        assertTrue(intellijIdeaPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }
}
