package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fraser on 15/02/2017.
 */
public abstract class DetailsPage {
    public static By optionsTab = By.id("details_menu_exterior");
    public static By featuresTab = By.id("details_menu_interior");
    public static By price = By.id("heading_price");
    public static By id = By.id("details_content_order");
    public static By model = By.cssSelector("#heading_model > span:nth-child(1)");
    public static By engine = By.cssSelector("#heading_model > span:nth-child(3)");
    public static By derivative = By.cssSelector("#heading_model > span:nth-child(5)");
    public static By orderNumber = By.id("details_content_order");


    public static void compare(WebDriver webDriver,Car compareCar){
        //Check the org.jlrdigital.rv.test.seleniumtest.model matches
        assertEquals(compareCar.getModel(), webDriver.findElement(DetailsPage.model).getText());

        //Check the engine matches
        assertEquals(compareCar.getEngine(), webDriver.findElement(DetailsPage.engine).getText());

        //Check the derivative matches
        assertEquals(compareCar.getDerivative(), webDriver.findElement(DetailsPage.derivative).getText());

        //Check the order number matches
        assertEquals(compareCar.getOrderNumber(), webDriver.findElement(DetailsPage.orderNumber).getText());

        //Check the price matches
        assertEquals(compareCar.getPrice(), webDriver.findElement(DetailsPage.price).getText());
    }

}