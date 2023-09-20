package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.AllureAttachmentsManager;
import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.AllProductsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class AllProductsPageTest extends BaseTest {
    private AllProductsPage AllProductsPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/all/");
        AllProductsPage = new AllProductsPage(getDriver());
    }

    @Test
    @DisplayName("Наличие кнопки Buy")
    public void buyButtonCheck() {
        assertTrue(AllProductsPage.checkIfBuyButtonEnabled(), "Кнопка Buy не доступна");
        AllureAttachmentsManager.screenshot();
    }

    @Test
    @DisplayName("Открытие страницы покупки при нажатии на Buy")
    public void urlBuyButtonCheck() {
        AllProductsPage.buyButtonClick();
        AllProductsPage.switchToStoreTab(1);
        assertEquals("https://www.jetbrains.com/store/#commercial", getDriver().getCurrentUrl(), "Открылась неверная ссылка");
        AllureAttachmentsManager.screenshot();
    }
}
