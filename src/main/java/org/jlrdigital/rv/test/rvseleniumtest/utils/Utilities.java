package org.jlrdigital.rv.test.rvseleniumtest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Fraser on 15/02/2017.
 */
public abstract class Utilities {

    public static void waitUntilClickable(WebDriver webDriver, By by, int seconds){
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitUntilClickable(WebDriver webDriver, WebElement webElement, int seconds){
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static boolean isSelected(WebDriver webDriver, By by){
        return webDriver.findElement(by).getAttribute("class").contains("selected");
    }

    public static boolean isSelected(WebElement webElement){
        return webElement.getAttribute("class").contains("selected");
    }
}
