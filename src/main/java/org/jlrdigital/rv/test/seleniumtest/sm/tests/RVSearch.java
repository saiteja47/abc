package org.jlrdigital.rv.test.seleniumtest.sm.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.TestCase;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Tests;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Utilities;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.jlrdigital.rv.test.seleniumtest.sm.model.LoginPage;
import org.jlrdigital.rv.test.seleniumtest.sm.model.PageLogin;
import org.jlrdigital.rv.test.seleniumtest.sm.model.PageSearch;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/
import org.jlrdigital.rv.test.seleniumtest.sm.model.SearchPage;


public class RVSearch extends Tests {

	  final Logger logger = LoggerFactory.getLogger(RVSearch.class);
	
	@Before
	@Override
	public void setUp() 
	{
		testCase = new TestCase("RV.xml");
		super.setUp();

		currentPage = new PageLogin(browser);
		currentPage.load();
	
			System.out.println(" - Logging in as " + Variables.rvJaguarUserLogin + " with correct details.");
			System.out.println("Variables "+Variables.rvJaguarUserPassword);
			((PageLogin)currentPage).login(Variables.rvJaguarUserLogin, Variables.rvJaguarUserPassword);
			System.out.println("login successful----");
	//rowser.waitForElementToAppear(PageSearch.searchfinder,200);
			System.out.println("logged into the jaguar");
			
	}


	@After
	@Override
	public void tearDown()
	{
		Browser.takeScreenShot(browser.getSession());
	    super.tearDown();
		
	}
	
	
	
	/*
	//selecting all models and click all derivatives no
	@Test
	public void checkingallderivativesno()
	{
		try {
			browser.waitForElementToAppear(PageSearch.searchfinder,200);
			System.out.println("checking");
			
			PageSearch a=new PageSearch(browser);
			a.ALLModelSelect();
			a.derivativesno();
			System.out.println("showing the data when all derivatives click no");
			
			
		} catch (Exception e) 
		
	    {
			System.out.println("Test failed");
			
			fail();
			
		}
		
	}
	
	
	
	
	//selecting all models and click all derivatives yes
	@Test
	public void checkingallderivativesyes()
	{
		try {
			browser.waitForElementToAppear(PageSearch.searchfinder,200);
			System.out.println("checking");
			
			PageSearch a=new PageSearch(browser);
			a.ALLModelSelect();
			a.derivativesyes();
			System.out.println("showing the data when all derivatives click yes");
			
			
		} catch (Exception e) 
		
	    {
			System.out.println("Test failed");
			
			fail();
			
		}
		
	}
	
	
//selecting all models and checking the stock avaliable
	@Test
	public void stockchecking()
	{
		try {
			browser.waitForElementToAppear(PageSearch.searchfinder,200);
			System.out.println("checking");
			
			PageSearch a=new PageSearch(browser);
			a.ALLModelSelect();
			a.stock();
			System.out.println("showing stock available");
			
			
		} catch (Exception e) 
		
	    {
			System.out.println("Not performed any action");
			
			fail();
			
		}
		
	}
	
	@Test
	//checking all models selecting or not
	public void CheckingAllModelsClick()
	{
		try {
			System.out.println("checking");
			
		PageSearch a=new PageSearch(browser);
			a.ALLModelSelect();
			System.out.println("All models are selected");
			
			
		} catch (Exception e) 
		
	    {
			System.out.println("All models are not selected");
			
			fail();
			
		}
	}



@Test
 //checking fpace model selecting or not
public void checkingFpaceclick()
{
	try {
		System.out.println("checking");
		
	PageSearch a=new PageSearch(browser);
		a.FPace();
		System.out.println("F-pace selected");		
		
	} catch (Exception e) 
	
    {
		System.out.println("F-pace not selected");
		fail();
		
	}
}


 
@Test
//checking ftype model selecting or not
public void checkingFTypeclick()
{
	try {
		System.out.println("checking");
		PageSearch a=new PageSearch(browser);
		a.FType();
		System.out.println("F-Type selected");		
		
	} catch (Exception e) 
	
    {
		System.out.println("F-Type not selected");
		fail();
		
	}
}


@Test
//checking XE saloon model selecting or not
public void checkingXESaloonclick()
{
	try {
		System.out.println("checking");
		PageSearch a=new PageSearch(browser);
	    a.XESaloon();
		System.out.println("XE saloon selected");		
		
	} catch (Exception e) 
	
    {
		System.out.println("XE saloon not selected");
		fail();
		
	}
}



@Test
//checking XF saloon model selecting or not
public void checkingXFSaloonclick()
{
	try {
		System.out.println("checking");
		PageSearch a=new PageSearch(browser);
		a.XFSaloon();
		System.out.println("XF saloon selected");		
		
	} catch (Exception e) 
	
    {
		System.out.println("XF saloon selected");
		fail();
		
	}
}


@Test
//checking XJ saloon model selecting or not.
public void checkingXJSaloonclick()
{
	try {
		System.out.println("checking");
		PageSearch a=new PageSearch(browser);
		a.XJSaloon();
		System.out.println("XJ saloon selected");		
		
	} catch (Exception e) 
	
    {
		System.out.println("XJ saloon not selected");
		fail();
		
	}
}

	
*/

































/*
@Test
public void Fpaceselect()
{
	 try
	 {
	//browser.waitForElementToAppear(PageSearch.F_pace, 80);	 
	((PageSearch)currentPage).FPace();
	System.out.println("fpace car models");
	 }catch(Exception e)
	 {
		 System.out.println("not selected");
		 fail();
	 }
}


















/*
  @Test
	public void testLogo() 
     {
				try {
					System.out.println("test loggo");
		//	browser.waitForElementToAppear(PageSearch.searchfinder,50);
			((PageSearch)currentPage).FPace();
			System.out.println(" logo present");
		} catch(Exception e) {
			System.out.println("................ ");
			fail();
		}
     }
	/*
	
     @Test
     public void Fpaceselect()
     {
    	 try
    	 {
    	browser.waitForElementToAppear(PageSearch.F_pace, 50);	 
    	((PageSearch)currentPage).FPace();
    	System.out.println("fpace car models");
    	 }catch(Exception e)
    	 {
    		 System.out.println("not selected");
    		 fail();
    	 }
     }
/*     
	
	@Test	
	public void clickmodel() {
				try {
			browser.waitForElementToAppear(PageSearch.model,50);
			((PageSearch)currentPage).clickmodel();
			System.out.println(" TEST PASS -> Model is Clicked");
					} catch(Exception e) {
			System.out.println(" - TEST FAILED -> model didn't selected");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test	
	public void clickmodelResult() {
				try {
			browser.waitForElementToAppear(PageSearch.discovery,50);
			((PageSearch)currentPage).clickmodel1();
			List<WebElement> result = ((PageSearch)currentPage).result();
			System.out.println(" TEST PASS -> Model is Clicked");
			assertEquals("Discovery - Estate Paddle Shift",result.get(0).findElement(By.xpath("//div[@id='result_name_SALLAAAG5GA833046']")).getText());
			System.out.println("model titl"+result.get(0).findElement(By.xpath("//div[@id='result_name_SALLAAAG5GA833046']")).getText());
			//assertEquals("No engine available",result.get(0).findElement(By.xpath("//div[@id='result_engine_SALLAAAG5GA833046']")).getText());
			//*[@id="result_year_SALLAAAG5GA833046"]
			assertEquals("No engine available",result.get(0).findElement(By.xpath("//div[@id='result_engine_SALLAAAG5GA833046']")).getText());
			System.out.println("No engine"+result.get(0).findElement(By.xpath("//div[@id='result_engine_SALLAAAG5GA833046']")).getText());
			assertEquals("2016.5 Model Year",result.get(0).findElement(By.xpath("//div[@id='result_year_SALLAAAG5GA833046']")).getText());
			System.out.println("year"+result.get(0).findElement(By.xpath("//div[@id='result_year_SALLAAAG5GA833046']")).getText());
			assertEquals("£78,120",result.get(0).findElement(By.xpath("//div[@id='result_price_SALLAAAG5GA833046']")).getText());
			System.out.println("price"+result.get(0).findElement(By.xpath("//div[@id='result_price_SALLAAAG5GA833046']")).getText());
			assertEquals("Waitomo Grey,Diesel Fuel,19 Alloy Gloss Grey 7 Split Spoke, InControl Touch Plus (Level 2) - Meridian Sound System (380W) with radio and single slot CD player, MP3 ",result.get(0).findElement(By.xpath("//div[@id='result_desc_SALLAAAG5GA833046']")).getText());
			System.out.println("result description"+result.get(0).findElement(By.xpath("//div[@id='result_desc_SALLAAAG5GA833046']")).getText());
			assertEquals("order number",result.get(0).findElement(By.xpath("//div[@id='result_order_SALLAAAG5GA833046']")).getText());
			System.out.println("result description"+result.get(0).findElement(By.xpath("//div[@id='result_desc_SALLAAAG5GA833046']")).getText());
			
			//assertEquals("Discovery",result.get(1).findElement(By.xpath("v/section[2]/div/div[1]/div/div[1]/div[1]/div[1]")).getText());
			System.out.println("compare pass");
							} catch(Exception e) {
			System.out.println(" - TEST FAILED -> result didn't selected");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test	
	public void allFilterSelection() {
				try {
		browser.getSession().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					browser.waitForElementToAppear(PageSearch.discovery,50);
			((PageSearch)currentPage).clickmodel1();
			System.out.println(" TEST PASS -> Discovery model is Clicked");
			((PageSearch)currentPage).clickmodel2();
			System.out.println(" TEST PASS -> Discovery sport is Clicked");
			browser.waitForElementToAppear(PageSearch.discoveryTest,50);
			((PageSearch)currentPage).clickmodel3();
			System.out.println(" TEST PASS -> discoveryTest is Clicked");
			((PageSearch)currentPage).clickmodel4();
			System.out.println(" TEST PASS -> evoque is Clicked");
			((PageSearch)currentPage).clickmodel5();
			System.out.println(" TEST PASS -> rangeRover is Clicked");
			((PageSearch)currentPage).clickmodel6();
			System.out.println(" TEST PASS -> rangeRoverSport is Clicked");
			
			((PageSearch)currentPage).derFTypeSvrYClick();
			System.out.println(" switch_f-type_svr");
			
			((PageSearch)currentPage).derXfCambridgeLeYClick();
			System.out.println("XF Cambridge LE");
			
			//((PageSearch)currentPage).derSwitchTl4HighSpecYClick();
			System.out.println("switch_tl4_- high spec (hse lux)_label");
			((PageSearch)currentPage).derXfSPremiumLuxuryYClick();
			System.out.println("XF S Premium Luxury");
			
							} catch(Exception e) {
			System.out.println(" - TEST FAILED -> filter are not getting selected");
			e.printStackTrace();
			//fail();
		}
	}
	
	@Test	
	public void clickCompare() {
				try {
			browser.waitForElementToAppear(PageSearch.model);
			((PageSearch)currentPage).clickCompareLink();
			System.out.println(" TEST PASS -> Compare is Clicked");
			
		} catch(Exception e) {
			System.out.println(" - TEST FAILED ->compare is not clicked");
			fail();
		}
	}
	
	@Test	
	public void logout() {
				try {
			browser.waitForElementToAppear(PageSearch.discovery,50);
			((PageSearch)currentPage).logOutClick();
			System.out.println(" TEST PASS -> User Logout");
					} catch(Exception e) {
			System.out.println(" - TEST FAILED ->User Logout");
			e.printStackTrace();
			//fail();
		}
	}
	@Test	
	public void clickCompares() {
				try {
			browser.waitForElementToAppear(PageSearch.model);
			((PageSearch)currentPage).clickCompareLink();
			System.out.println(" TEST PASS -> Compare is Clicked");
			
		} catch(Exception e) {
			System.out.println(" - TEST FAILED ->compare is not clicked");
			fail();
		}
	}
			
	@Test	
	public void colourselect() {
				try {
			browser.waitForElementToAppear(PageSearch.model);
			((PageSearch)currentPage).clickCompareLink();
			System.out.println(" TEST PASS -> Compare is Clicked");
			
		} catch(Exception e) {
			System.out.println(" - TEST FAILED ->compare is not clicked");
			fail();
		}

	
	}

	/*@Test
	public void checkCanGoToWorklist() {
		((PageWelcome)currentPage).clickWorklistLink();
		browser.waitForElementToAppear(PageWorklist.filterButton, 10);
	}
	
	
	// Currently this method directs to the worklists page. It is here ready for when the reports api is done
	 
	@Test
	public void checkcanGoToReports() {
		((PageWelcome)currentPage).clickReportsLink();
		browser.waitForElementToAppear(PageWorklist.filterButton, 10); 
	}*/
	

}
