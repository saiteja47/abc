package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.openqa.selenium.By;

/**
 * Created by Fraser on 15/02/2017.
 */
public abstract class SearchPage {
    public static By orderIdInput = By.id("order_id_input");
    public static By models = By.className("search-criteria__model");
    public static By searchItem = By.className("search-result__item");
    public static By compareCars = By.className("compare_cars-item");
    public static By compareButton = By.className("compare_button");
    public static By orderIdButton = By.id("search_order_id");

    public static By price(String parentId) {
        return By.cssSelector("#" + parentId + " .search-result__item-price");
    }

    public static By detailsButtons(String parentId) {
        return By.cssSelector("#" + parentId + " .search-result__item-details");
    }

    public static By orderId(String parentId) {
        return By.cssSelector("#" + parentId + " .search-result__item-order");
    }

    public static By model(String parentId) {
        return By.cssSelector("#" + parentId + " > span:nth-child(1)");
    }
    public static By engine(String parentId) {
        return By.cssSelector("#" + parentId + " > span:nth-child(3)");
    }

    public static By derivative(String parentId) {
        return By.cssSelector("#" + parentId + " > span:nth-child(5)");
    }

    public static String nameId(String id) {
                return id.replace("result","result_name");
    }

    public static By compare (String id){
        return By.cssSelector("#" + id + " .search-result__item-compare");
    }
    
	
}
