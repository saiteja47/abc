package org.jlrdigital.rv.test.seleniumtest.sm.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.jlrdigital.rv.test.rvseleniumtest.utils.Environment;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Utilities;
import org.jlrdigital.rv.test.seleniumtest.sm.model.Car;
import org.jlrdigital.rv.test.seleniumtest.sm.model.ComparePage;
import org.jlrdigital.rv.test.seleniumtest.sm.model.ComparePageCar;
import org.jlrdigital.rv.test.seleniumtest.sm.model.DetailsPage;
import org.jlrdigital.rv.test.seleniumtest.sm.model.LoginPage;
import org.jlrdigital.rv.test.seleniumtest.sm.model.Page;
import org.jlrdigital.rv.test.seleniumtest.sm.model.SearchPage;
import org.jlrdigital.rv.test.seleniumtest.sm.model.SearchPageCar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HappyFlow extends CarFinderTest {

    final Logger logger = LoggerFactory.getLogger(HappyFlow.class);
    private Car globalTestCar;

    @Override
    @Before
    public void before() throws Exception{
        super.before();
    }

    @Override
    @After
    public void after(){
        super.after();
    }

    @Test
    public void generalTest() {

        //Enter credentials and press login
        webDriver.findElement(LoginPage.nameInput).sendKeys(Environment.getUserName());
        webDriver.findElement(LoginPage.passwordInput).sendKeys(Environment.getPassword());
        webDriver.findElement(LoginPage.loginButton).click();

        //Has loading started
        assertEquals(true, 0 < webDriver.findElements(LoginPage.loadingAnimation).size());

        logger.info("Downloading bundle...");

        //Wait 60 seconds for page to load
        Utilities.waitUntilClickable(webDriver, SearchPage.orderIdInput, 150);
        //Check it has loaded
        assertEquals(true, webDriver.findElement(SearchPage.orderIdInput).isEnabled());

        logger.info("Selecting/Removing all car models");

        //For every org.jlrdigital.rv.test.seleniumtest.model
        for (WebElement element : webDriver.findElements(SearchPage.models)) {
            //Click
            element.click();
            //Check it's selected
            assertEquals(true, element.getAttribute("class").contains("selected"));
            //Click
            element.click();
            //Check it's no longer selected
            logger.info("Class:" + element.getAttribute("class"));

            assertEquals(false, element.getAttribute("class").contains("selected"));
        }

        logger.info("Selecting all models");

        //For every org.jlrdigital.rv.test.seleniumtest.model
        for (WebElement element : webDriver.findElements(SearchPage.models)) {
            //Click
            element.click();
            //Check it's selected
            assertEquals(true, Utilities.isSelected(element));
        }

        logger.info("Checking vehicles are available");

        assertEquals(true, 0 < webDriver.findElements(SearchPage.searchItem).size());

        logger.info("Checking details for every car");

        //For vehicle available on this page
        for (int i = 0; i < webDriver.findElements(SearchPage.searchItem).size(); i++) {
            SearchPageCar searchPageTestCar;
            //Get the vehicle
            WebElement searchItem = webDriver.findElements(SearchPage.searchItem).get(i);
            //Get it's order ID
            logger.info("Current order ID:" + SearchPage.orderId(searchItem.getAttribute("id")));
            //Get it's HTML ID
            String id = searchItem.getAttribute("id");
            //Get the details button for it
            WebElement searchItemDetailsButton = webDriver.findElement(SearchPage.detailsButtons(id));

            //Create a car org.jlrdigital.rv.test.seleniumtest.model
            searchPageTestCar = new SearchPageCar(webDriver, id);

            if (globalTestCar == null) {
                globalTestCar = searchPageTestCar;
            }

            //Click details
            searchItemDetailsButton.click();

            //Check details is loaded
            assertEquals(true, webDriver.getCurrentUrl().matches(Environment.getUrl() + ".*details?.*"));

            //Click on features tab
            webDriver.findElement(DetailsPage.featuresTab).click();
            Utilities.isSelected(webDriver, DetailsPage.featuresTab);

            //Click back to options tab
            webDriver.findElement(DetailsPage.optionsTab).click();
            Utilities.isSelected(webDriver, DetailsPage.optionsTab);

            //Check that the car matches the details page
            DetailsPage.compare(webDriver, searchPageTestCar);

            //Go back to search page
            webDriver.navigate().back();
        }

        logger.info("Checking compare");
        ArrayList<SearchPageCar> compareCars = new ArrayList<SearchPageCar>();
        //For every search item

        for (int i = 0; i < webDriver.findElements(SearchPage.searchItem).size(); i++) {
            if (2 <= webDriver.findElements(SearchPage.searchItem).size()) {
                WebElement searchItem = webDriver.findElements(SearchPage.searchItem).get(i);
                //Add 3 cars
                if (compareCars.size() < 3) {
                    String id = searchItem.getAttribute("id");

                    //Add to compare
                    webDriver.findElement(SearchPage.compare(id)).click();
                    compareCars.add(new SearchPageCar(webDriver, id));
                }
            }
        }

        //Check compare cars are selected
        assertEquals(3, webDriver.findElements(SearchPage.compareCars).size());


        assertEquals(true, webDriver.findElements(SearchPage.compareButton).get(0).isEnabled());

        //Scroll back to top so element does not receive click
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0);");

        //Click compare
        webDriver.findElements(SearchPage.compareButton).get(0).click();
        logger.info("Clicked compare");


        //Check compare has loaded
        assertEquals(true, webDriver.getCurrentUrl().matches(Environment.getUrl() + ".*compare?.*"));
        logger.info("Compare loaded");
        logger.info("Verifying each car");

        //Start at 1 because of push element
        for (int i = 1; i < webDriver.findElements(ComparePage.carSummaries).size(); i++) {
            //Check cars match
            ComparePageCar comparePageCar = new ComparePageCar(webDriver, i);
            Car compareTestCar = compareCars.get(i - 1);
            assertEquals(compareTestCar.getModel(), comparePageCar.getModel());
            assertEquals(compareTestCar.getEngine(), comparePageCar.getEngine());
            assertEquals(compareTestCar.getDerivative(), comparePageCar.getDerivative());
            assertEquals(compareTestCar.getPrice(), comparePageCar.getPrice());

            //View the details of the car
            webDriver.findElement(ComparePage.detailsButton(i)).click();

            //Check that the car matches the details page
            DetailsPage.compare(webDriver, compareTestCar);

            //Go back to compare page
            webDriver.navigate().back();
        }
        logger.info("All cars good");
        logger.info("Returning to search page");

        //Go back to the search page
        webDriver.findElement(Page.searchPagebutton).click();

        //Check search has loaded
        assertEquals(true, webDriver.getCurrentUrl().matches(Environment.getUrl() + ".*search?.*"));
        logger.info("Searching by order ID for order:" + globalTestCar.getOrderNumber());

        //Search by order ID
        webDriver.findElement(SearchPage.orderIdInput).sendKeys(globalTestCar.getOrderNumber());
        webDriver.findElement(SearchPage.orderIdButton).click();

        //Check it is returned
        assertEquals(true, 0 < webDriver.findElements(SearchPage.searchItem).size());
        logger.info("Found order");

        String id = webDriver.findElements(SearchPage.searchItem).get(0).getAttribute("id");
        webDriver.findElement(SearchPage.detailsButtons(id)).click();

        logger.info("Verifying order");
        //Check it is the correct car from earlier
        DetailsPage.compare(webDriver, globalTestCar);

        logger.info("Tests passed");
    }
}
