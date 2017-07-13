package org.jlrdigital.rv.test.seleniumtest.sm.tests;



import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Environment;
import org.jlrdigital.rv.test.rvseleniumtest.utils.TestCase;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Tests;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.jlrdigital.rv.test.seleniumtest.sm.model.PageLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CarFinderTest {
    final Logger logger = LoggerFactory.getLogger(CarFinderTest.class);
     Browser browser;
     String url;
     WebDriver webDriver;

    

    @Before
    public void before() throws Exception{
    	
      browser = new Browser("local");
        Environment.setTargetEnvironment(Environment.TARGET_ENVIRONMENT.PROVING);
        Environment.setUserType(Environment.USER_TYPE. JAGUAR);

        webDriver = browser.getSession();
        webDriver.navigate().to(Environment.getUrl());
        logger.info("At login page");
    	
			
    }

    
    
    @After
    public void after() {
        if (browser != null) {
            if (browser.getSession() != null) {
                browser.getSession().close();
            }
        }
    }

   
    
    
}
