package com.example.jetbrainstest;

import com.example.jetbrainstest.tests.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AllureAttachmentsManager {

    @Attachment(value = "Schreenshot", type = "image/png")
    public static byte[] schreenshot(){
        return ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
