package org.jlrdigital.rv.test.seleniumtest.sm.tests;


import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.TestCase;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Tests;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.jlrdigital.rv.test.seleniumtest.sm.model.PageLogin;
import org.jlrdigital.rv.test.seleniumtest.sm.model.PageSearch;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
/*
import org.junit.After;
import org.junit.Before;

import org.junit.Test;

*/

public class RVLogin extends Tests {

	//private static final int priority = 0;

	@BeforeMethod
	@Override
	public void setUp() {
		testCase = new TestCase("RV.xml");
		super.setUp();

		currentPage = new PageLogin(browser);
		currentPage.load();
	}

	@AfterMethod
	@Override
	public void tearDown() {
		Browser.takeScreenShot(browser.getSession());
		super.tearDown();
	}

 
 //jaguar user with valid username and valid password
	@Test(priority=1)
	public void JaguarcanLoginWithCorrectDetails() {
		System.out.println(" - Logging in as " + Variables.rvJaguarUserLogin + " with correct details.");
		System.out.println("Variables "+Variables.rvJaguarUserPassword);
		((PageLogin)currentPage).login(Variables.rvJaguarUserLogin, Variables.rvJaguarUserPassword);
			
		try {
			browser.waitForElementToAppear(PageSearch.F_pace,150);
			System.out.println(" - TEST PASSED -> Logged in");
		} catch(Exception e) {
			System.out.println(" - TEST FAILED -> Did not log in");
			fail();
		}
	}
	
	//landrover user with valid username and valid password
	@Test(priority=2)
	public void LandrovercanLoginWithCorrectDetails() {
		System.out.println(" - Logging in as " + Variables.rvLandroverJaguarUserLogin + " with correct details.");
		System.out.println("Variables"+Variables.rvLandroverrUserPassword);
		((PageLogin)currentPage).login(Variables.rvLandroverJaguarUserLogin, Variables.rvLandroverrUserPassword);
			
		try {
			browser.waitForElementToAppear(PageSearch.search);
			System.out.println(" - TEST PASSED -> Logged in");
		} catch(Exception e) {
			System.out.println(" - TEST FAILED -> Did not log in");
			fail();
		}
	} 

 
  //jaguar user with valid user and invalid Password
	@Test(priority=3)
	public void JaguarusercantLoginWithIncorrectPassword() {
		System.out.println(" - Logging in as " + Variables.rvJaguarUserLogin + " with valid username and incorrect password.");
		System.out.println("variables "+Variables.rvJaguarUserIncorrectPassword);
		((PageLogin)currentPage).login(Variables.rvJaguarUserLogin, Variables.rvJaguarUserIncorrectPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	//landrover user with valid user and invalid Password
	@Test(priority=4)
	public void LandroverusercantLoginWithIncorrectPassword() {
		System.out.println(" - Logging in as " + Variables.rvLandroverJaguarUserLogin + " with valid username and incorrect password.");
		System.out.println("variables "+Variables.rvlandroverUserIncorrectPassword);
		((PageLogin)currentPage).login(Variables.rvLandroverJaguarUserLogin, Variables.rvlandroverUserIncorrectPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	
	
	
	 
	 	//jaguar user with incorrect username and valid password
	 
	@Test(priority=5)
	public void JaguarusercantLoginWithIncorrectUsername() {
		System.out.println(" - Logging in as " + Variables.rvJaguarInvalidUserLogin + " with Invalid username and correct password.");
		System.out.println("variables "+Variables.rvJaguarUserPassword);
		((PageLogin)currentPage).login(Variables.rvJaguarInvalidUserLogin, Variables.rvJaguarUserPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	//landrover user with incorrect username and valid password
	
	@Test(priority=6)
	public void LandroverusercantLoginWithIncorrectusername() {
		System.out.println(" - Logging in as " + Variables.rvLandroverInvalidUserLogin + " with Invalid username and correct password.");
		System.out.println("variables "+Variables.rvLandroverrUserPassword);
		((PageLogin)currentPage).login(Variables.rvLandroverInvalidUserLogin, Variables.rvLandroverrUserPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	

 //jaguar user with incorrect username and incorrect password
	
	@Test(priority=7)
	public void JaguarusercantLoginWithIncorrectUsernamePassword() {
		System.out.println(" - Logging in as " + Variables.rvJaguarInvalidUserLogin + " with Invalid username and Incorrect password.");
		System.out.println("variables "+Variables.rvJaguarUserIncorrectPassword);
		((PageLogin)currentPage).login(Variables.rvJaguarInvalidUserLogin, Variables.rvJaguarUserIncorrectPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	//landrover user with incorrect username and incorrect password
	
	@Test(priority=8)
	public void LandroverusercantLoginWithIncorrectusernamePassword() {
		System.out.println(" - Logging in as " + Variables.rvLandroverInvalidUserLogin + " with Invalid username and Incorrect password.");
		System.out.println("variables "+Variables.rvlandroverUserIncorrectPassword);
		((PageLogin)currentPage).login(Variables.rvLandroverInvalidUserLogin, Variables.rvlandroverUserIncorrectPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	
	
	
	//jaguar user with empty username and empty password

	@Test(priority=9)
	public void JaguarusercantLoginEmptyUsernamePassword() {
		System.out.println(" - Logging in as " + Variables.rvJaguarEmptyUserLogin + " with Empty username and empty password.");
		System.out.println("variables "+Variables.rvJaguarEmptyUserPasswrod);
		((PageLogin)currentPage).login(Variables.rvJaguarEmptyUserLogin, Variables.rvJaguarEmptyUserPasswrod);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	//landrover user with empty username and empty password
	
	@Test(priority=10)
	public void LandroverusercantLoginWithEmptytusernamePassword() {
		System.out.println(" - Logging in as " + Variables.rvLandroverEmptyUserLogin + " with Empty username and empty password.");
		System.out.println("variables "+Variables.rvLandroverEmptyUserPasswrod);
		((PageLogin)currentPage).login(Variables.rvLandroverEmptyUserLogin, Variables.rvLandroverEmptyUserPasswrod);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	
	// jaguar user with empty username and valid password

	@Test(priority=11)
	public void JaguarusercantLoginEmptyUsernameValidPassword() {
		System.out.println(" - Logging in as " + Variables.rvJaguarEmptyUserLogin + " with Empty username and valid password.");
		System.out.println("variables "+Variables.rvJaguarUserPassword);
		((PageLogin)currentPage).login(Variables.rvJaguarEmptyUserLogin, Variables.rvJaguarUserPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	
	// landrover user with empty username and valid password
	@Test(priority=12)
	public void LandroverusercantLoginWithEmptytusernameValidPassword() {
		System.out.println(" - Logging in as " + Variables.rvLandroverEmptyUserLogin + " with Empty username and valid password.");
		System.out.println("variables "+Variables.rvLandroverrUserPassword);
		((PageLogin)currentPage).login(Variables.rvLandroverEmptyUserLogin, Variables.rvLandroverrUserPassword);
		try {
			browser.waitForElementToAppear(PageSearch.search, 5);
			System.out.println(" - TEST FAILED -> Logged in.");
			fail();
		} catch(Exception e) {
			System.out.println(" - TEST PASSED -> Did not log in");
		}
	}
	

	//jaguar user with Valid username and empty password

		@Test(priority=13)
		public void JaguarusercantLoginValidUsernameEmptyPassword() {
			System.out.println(" - Logging in as " + Variables.rvJaguarUserLogin + " with valid username and  empty password.");
			System.out.println("variables "+Variables.rvJaguarEmptyUserPasswrod);
			((PageLogin)currentPage).login(Variables.rvJaguarUserLogin, Variables.rvJaguarEmptyUserPasswrod);
			try {
				browser.waitForElementToAppear(PageSearch.search, 5);
				System.out.println(" - TEST FAILED -> Logged in.");
				fail();
			} catch(Exception e) {
				System.out.println(" - TEST PASSED -> Did not log in");
			}
		}
		
		//landrover user with valid username and empty password
		
		@Test(priority=14)
		public void LandroverusercantLoginWithValidtusernameEmptyPassword() {
			System.out.println(" - Logging in as " + Variables.rvLandroverJaguarUserLogin + " with Valid username and  empty password.");
			System.out.println("variables "+Variables.rvLandroverEmptyUserPasswrod);
			((PageLogin)currentPage).login(Variables.rvLandroverJaguarUserLogin, Variables.rvLandroverEmptyUserPasswrod);
			try {
				browser.waitForElementToAppear(PageSearch.search, 5);
				System.out.println(" - TEST FAILED -> Logged in.");
				fail();
			} catch(Exception e) {
				System.out.println(" - TEST PASSED -> Did not log in");
			}
		}
		
	
	
	

}
