package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.openqa.selenium.WebDriver;

/**
 * Created by Fraser on 07/03/2017.
 */
public class ComparePageCar extends Car {

    public ComparePageCar(WebDriver webDriver, int index) {

        this.model = webDriver.findElement(ComparePage.model(index + 1)).getText();
        this.engine = webDriver.findElement(ComparePage.engine(index + 1)).getText();
        this.derivative = webDriver.findElement(ComparePage.derivative(index + 1)).getText();
        this.price = webDriver.findElement(ComparePage.price(index + 1)).getText();

        //TODO
        //This might be a hack
        if (this.price.equals("No price data")) {
            this.price += " available";
        }


    }
}
