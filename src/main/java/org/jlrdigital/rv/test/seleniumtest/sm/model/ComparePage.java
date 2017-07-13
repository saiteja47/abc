package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.openqa.selenium.By;

/**
 * Created by Fraser on 15/02/2017.
 */
public abstract class ComparePage {
    public static By carSummaries = By.className("car-summary");

    public static By model(int index) {
        return By.cssSelector("#compare > div:nth-child(1) > div > div > div:nth-child(" + (index) + ") > div > div > div > div.car-summary-text > h4");
    }

    public static By derivative(int index) {
        return By.cssSelector("#compare > div:nth-child(1) > div > div > div:nth-child(" + (index) + ") > div > div > div > div.car-summary-text > h6:nth-child(2)");
    }

    public static By engine(int index) {
        return By.cssSelector("#compare > div:nth-child(1) > div > div > div:nth-child(" + (index) + ") > div > div > div > div.car-summary-text > h6:nth-child(3)");
    }

    public static By price(int index) {
        return By.cssSelector("#compare > div:nth-child(1) > div > div > div:nth-child(" + (index) + ") > div > div > div > div.vehicle-details_heading_price");
    }

    public static By detailsButton(int index) {
        // +1 to offset for push dic
        return By.cssSelector("#compare > div:nth-child(1) > div > div > div:nth-child(" + (index +1) + ") > div > button");
    }
}
