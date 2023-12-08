package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.youtrackpages.YouTrackPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class YouTrackTest extends BaseTest{

    private YouTrackPage YTPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/youtrack/");
        YTPage = new YouTrackPage(getDriver());
        System.out.println("Начало проверки:");
    }
    @AfterEach
    public void tearDown(){
        super.tearDown();
        System.out.println("Проверка окончена");
    }

    @Test
    @DisplayName("Проверка активности кнопки What's new")
    public void  WhatsNewButtonTest(){
        assertTrue(YTPage.checkIfWhatsNewButtonIsClickable(),"Кнопка What's New неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Agile")
    public void  AgileButtonTest(){
        assertTrue(YTPage.checkIfAgileButtonIsClickable(),"Кнопка Agile неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Teams")
    public void  TeamsButtonTest(){
        assertTrue(YTPage.checkIfTeamsButtonIsClickable(),"Кнопка Teams неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Features")
    public void  FeaturesButtonTest(){
        assertTrue(YTPage.checkIfFeaturesButtonIsClickable(),"Кнопка Features неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Helpdesk")
    public void  HelpdeskButtonTest(){
        assertTrue(YTPage.checkIfHelpdeskButtonIsClickable(),"Кнопка Helpdesk неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Support")
    public void  SupportButtonTest(){
        assertTrue(YTPage.checkIfSupportButtonIsClickable(),"Кнопка Support неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Pricing")
    public void  PricingButtonTest(){
        assertTrue(YTPage.checkIfPricingButtonIsClickable(),"Кнопка Pricing неактивна");
    }
}
