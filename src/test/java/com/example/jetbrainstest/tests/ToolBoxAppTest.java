package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.AllureLogger;
import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.toolboxpages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class ToolBoxAppTest extends BaseTest{
    private ToolBoxAppPage toolBoxAppPage;
    private ToolBoxFAQShortcutsPage toolBoxFAQShortcutsPage;
    private ToolBoxBlogAndSocialPage toolBoxBlogAndSocialPage;
    private ToolBoxOtherVersionPage1 toolBoxOtherVersionPage1;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ToolBoxAppPage.class));
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/toolbox-app/");
        toolBoxAppPage = new ToolBoxAppPage(getDriver());
        toolBoxFAQShortcutsPage = new ToolBoxFAQShortcutsPage(getDriver());
        toolBoxBlogAndSocialPage = new ToolBoxBlogAndSocialPage(getDriver());
        toolBoxOtherVersionPage1 = new ToolBoxOtherVersionPage1(getDriver());
    }
//1
    @Test
    @DisplayName("Проверка активности кнопки Submit")
    public void buttonCheck(){
        assertTrue(toolBoxAppPage.checkIfSubmitButtonIsEnable(), "Кнопка Submit не активна");
    }
//2
    @Test
    @DisplayName("Проверка ввода неправильного email")
    public void wrongEmailSubmit(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        toolBoxAppPage.setWrongEmail("wrong");
        toolBoxAppPage.clickSubmitButton();
        wait.until(ExpectedConditions.visibilityOf((ToolBoxAppPage.getValidMessage())));
        assertTrue(toolBoxAppPage.checkIfValidMessageIsDisplayed(), "Валидационное сообщение не появилось");
    }
//3
    @Test
    @DisplayName("Проверка, что после нажатия на кнопку, появляется дропдаун меню")
    public void test() {
        toolBoxAppPage.clickDropDownMenuButton(); //исскуственная ошибка
        assertTrue(toolBoxAppPage.checkIfDropDownMenuIsDisplayed(),"Меню не появилось");
    }
//4 ТК3
    @Test
    @DisplayName("Проверка отображения блока, часто задаваемые вопросы")
    public void faqDisplayTest(){
        toolBoxAppPage.faqRefClick();
        assertTrue(toolBoxFAQShortcutsPage.faqIsDisplayed(), "Часто задаваемые вопросы не отобразились");
    }
//5 ТК4
    @Test
    @DisplayName("Проверка открытиея страницы Blog and Social")
    public void blogAndSocialDisp(){
        toolBoxAppPage.blogSocialRefCLick();
        assertTrue(toolBoxBlogAndSocialPage.blogContentDisplayed(), "Проверка отображения постов");
    }
//6 ТК1
    @Test
    @DisplayName("Проверка что в тайтле Other Versions - Toolbox")
    public void checkOtherVersionTitle(){
        toolBoxAppPage.otherVersioLinkClick();
      String title = "Other Versions - Toolbox";

      assertEquals(title, toolBoxOtherVersionPage1.titleIsDisplayed(), "title не соответствует");
    }

}

