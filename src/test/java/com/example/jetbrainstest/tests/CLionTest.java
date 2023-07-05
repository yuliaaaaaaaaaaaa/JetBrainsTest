package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.CLionPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class CLionTest extends BaseTest {
    private CLionPage cLionPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/clion/");
        cLionPage = new CLionPage(getDriver());
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void downloadButtonCheck() {
        assertTrue(cLionPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка, что воспроизведено видео для CLion")
    public void playerCheck() {
        String titleVideo = cLionPage.getNameOfVideo();
        assertEquals(titleVideo, "CLion Quick Tour", "Воспроизводится другое видео");
    }

    @ParameterizedTest(name = "#{index} - активность кнопки №{0}")
    @CsvSource({"0", "1", "2", "3"})
    @DisplayName("Проверка, что кнопки из блока Follow Us активны")
    public void followButtonsCheck(int numberButton) {
        List<Boolean> a = cLionPage.checkIfFollowButtonsAreClickable();
        assertTrue(a.get(numberButton), String.format("Кнопка №%d неактивна", numberButton));
    }
}
