package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.qodanapages.QodanaPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class QodanaTest extends BaseTest{
    private QodanaPage QoPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/qodana/");
        QoPage = new QodanaPage(getDriver());
        System.out.println("Начало проверки:");
    }
    @AfterEach
    public void tearDown(){
        super.tearDown();
        System.out.println("Проверка окончена");
    }

    @Test
    @DisplayName("Проверка активности кнопки Documentation")
    public void  DocumentationButtonTest(){
        assertTrue(QoPage.checkIfDocumentationButtonIsClickable(),"Кнопка Documentation неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Blog")
    public void  BlogButtonTest(){
        assertTrue(QoPage.checkIfBlogButtonIsClickable(),"Кнопка Blog неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Request Demo")
    public void  RequestDemoButtonTest(){
        assertTrue(QoPage.checkIfRequestDemoButtonIsClickable(),"Кнопка Request Demo неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Pricing")
    public void  PricingButtonTest(){
        assertTrue(QoPage.checkIfPricingButtonIsClickable(),"Кнопка Pricing неактивна");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Try For Free в меню")
    public void  checkIfTryForFreeButton1IsClickable(){
        assertTrue(QoPage.checkIfTryForFreeButton1IsClickable(),"Кнопка Try For Free неактивна");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Try For Free на странице")
    public void  checkIfTryForFreeButton2IsClickable(){
        assertTrue(QoPage.checkIfTryForFreeButton2IsClickable(),"Кнопка Try For Free неактивна");
    }

    @Test
    @DisplayName("Переход на страницу Request a demo")
    public void RequestDemoButtonClickTest(){
        QoPage.requestDemoButtonClick();
        assertEquals("https://www.jetbrains.com/qodana/request-a-demo/", getDriver().getCurrentUrl(), "Переход на страницу Request a demo не осуществлен");
    }
}
