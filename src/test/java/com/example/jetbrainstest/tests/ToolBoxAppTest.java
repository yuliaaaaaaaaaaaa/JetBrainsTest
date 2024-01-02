package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.toolboxpages.ToolBoxAppPage;
import com.example.jetbrainstest.pages.toolboxpages.ToolBoxFAQShortcutsPage;
import jdk.jpackage.internal.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class ToolBoxAppTest extends BaseTest{
    private ToolBoxAppPage toolBoxAppPage;
    private ToolBoxFAQShortcutsPage toolBoxFAQShortcutsPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/toolbox-app/");
        toolBoxAppPage = new ToolBoxAppPage(getDriver());
        toolBoxFAQShortcutsPage = new ToolBoxFAQShortcutsPage(getDriver());
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
        toolBoxAppPage.clickDropDownMenuButton(); //исскуственная ошибка
        assertTrue(toolBoxAppPage.checkIfDropDownMenuIsDisplayed(),"Меню не появилось");
    }

    @Test
    public void faqDispleyTest(){
        toolBoxAppPage.faqRefClick();
        assertTrue(toolBoxFAQShortcutsPage.faqIsDisplayed(), "Часто задаваемые вопросы не отобразились");
        Log.info("Проверка отображения блока, часто задаваемые вопросы");
    }


}

