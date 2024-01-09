package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.youtrackpages.YouTrackPage;
import com.example.jetbrainstest.pages.youtrackpages.YouTrackTeamsPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MyExtension.class)
public class YouTrackTest extends BaseTest{

    private YouTrackPage YTPage;
    private YouTrackTeamsPage YTTeamsPage;

    @BeforeEach
    @Override
    @Step("Переход на страницу YouTrack")
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/youtrack/");
        YTPage = new YouTrackPage(getDriver());
        YTTeamsPage = new YouTrackTeamsPage(getDriver());
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
    public void PricingButtonTest(){
        assertTrue(YTPage.checkIfPricingButtonIsClickable(),"Кнопка Pricing неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Projects")
    public void YTProjectsButtonTest(){
        assertTrue(YTPage.checkIfYTProjectsButtonIsClickable(),"Кнопка Projects неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Tasks")
    public void YTTasksButtonTest(){
        assertTrue(YTPage.checkIfYTTasksButtonIsClickable(),"Кнопка Tasks неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки AI Assistant")
    public void YTAiAssistantButtonTest(){
        assertTrue(YTPage.checkIfAiAssistantButtonIsClickable(),"Кнопка AI Assistant неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Knowledge Base")
    public void  YTKnowledgeBaseButtonTest(){
        assertTrue(YTPage.checkIfYTKnowledgeBaseButtonIsClickable(),"Кнопка Knowledge Base неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки AgileBoards")
    public void  YTAgileBoardsButtonTest(){
        assertTrue(YTPage.checkIfYTAgileBoardsButtonIsClickable(),"Кнопка Agile Boards неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Timesheets")
    public void  YTTimesheetsButtonTest(){
        assertTrue(YTPage.checkIfYTTimesheetsButtonIsClickable(),"Кнопка Timesheets неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Gantt Charts")
    public void  YTGanttChartsButtonTest(){
        assertTrue(YTPage.checkIfYTGanttChartsButtonIsClickable(),"Кнопка Gantt Charts неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Reports")
    public void  YTReportsButtonTest(){
        assertTrue(YTPage.checkIfYTReportsButtonIsClickable(),"Кнопка Reports неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Helpdesk")
    public void  YTHelpdeskButtonTest(){
        assertTrue(YTPage.checkIfYTHelpdeskButtonIsClickable(),"Кнопка Helpdesk неактивна");
    }

    @Test
    @DisplayName("Проверка активности кнопки Workflows")
    public void  YTWorkflowsButtonTest(){
        assertTrue(YTPage.checkIfYTWorkflowsButtonIsClickable(),"Кнопка Workflows неактивна");
    }
    @Test
    @DisplayName("Открытие страницы Teams")
    public void YTTeamsPageTest() {
        String actualUrl = YTPage.checkIfTeamsButtonIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Developers")
    public void  DevelopersTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfDevelopersTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/development.html";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Marketing")
    public void  MarketingTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfMarketingTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/marketing.html";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Support")
    public void  SupportTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfSupportTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/helpdesk/";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Project Management")
    public void  PMTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfManagementTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/management.html";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Designers")
    public void  DesignTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfDesignTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/design.html";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел QA")
    public void  QATeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfQATeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/qa.html";
        assertEquals(expectedUrl, actualUrl);
    }
    @Test
    @DisplayName("Проверка перехода в раздел Operations and Legal")
    public void  OperationTeamTest(){
        YTPage.checkIfTeamsButtonIsWorking();
        String actualUrl = YTTeamsPage.checkIfOperationsTeamsIsWorking();
        String expectedUrl = "https://www.jetbrains.com/youtrack/teams/operations.html";
        assertEquals(expectedUrl, actualUrl);
    }
}
