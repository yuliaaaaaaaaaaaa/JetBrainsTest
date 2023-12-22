package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.ToolBoxAppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;


import static com.example.jetbrainstest.pages.ToolBoxAppPage.getValidMessage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToolBoxAppTest extends BaseTest{
    private ToolBoxAppPage toolBoxAppPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/toolbox-app/");
        toolBoxAppPage = new ToolBoxAppPage(getDriver());
    }

    @Test
    @DisplayName("Проверка активности кнопки Submit")
    public void buttonCheck(){
        assertTrue(toolBoxAppPage.checkIfSubmitButtonIsEnable(), "Кнопка Submit не активна");
    }

    @Test
    @DisplayName("Проверка ввода неправильного email")
    public void wrongEmailSubmit(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        toolBoxAppPage.setWrongEmail("wrong");
        toolBoxAppPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOf((ToolBoxAppPage.getValidMessage())));
        assertTrue(toolBoxAppPage.checkIfValidMessageIsDisplayed(), "Валидационное сообщение не появилось");
    }

    @Test
    @DisplayName("Проверка, что после нажатия на кнопку, появляется дропдаун меню")
    public void test() {
        toolBoxAppPage.clickDropDownMenuButton();
        assertTrue(toolBoxAppPage.checkIfDropDownMenuIsDisplayed(),"Меню не появилось");
    }

}

