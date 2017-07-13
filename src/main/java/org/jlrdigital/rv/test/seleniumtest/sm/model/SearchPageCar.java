package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.openqa.selenium.WebDriver;

/**
 * Created by Fraser on 07/03/2017.
 */
public class SearchPageCar extends Car{

    public SearchPageCar(WebDriver webDriver, String id) {

        String nameId = SearchPage.nameId(id);

        this.model = webDriver.findElement(SearchPage.model(nameId)).getText();
        this.engine = webDriver.findElement(SearchPage.engine(nameId)).getText();
        this.derivative = webDriver.findElement(SearchPage.derivative(nameId)).getText();
        this.price = webDriver.findElement(SearchPage.price(id)).getText();
        this.orderId = webDriver.findElement(SearchPage.orderId(id)).getText();

        //TODO
        //This might be a hack
        if (this.price.equals("No price data")) {
            this.price += " available";
        }
    }
}
