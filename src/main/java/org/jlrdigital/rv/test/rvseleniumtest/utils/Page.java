package org.jlrdigital.rv.test.rvseleniumtest.utils;

import org.jlrdigital.rv.test.rvseleniumtest.utils.PswEnums.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class Page {
	protected String siteRoot;
	protected String pageLocation;
	
	// Allows us to pass commands to the browser
	public static WebDriver browser;
	
	public static Context context = Variables.context;
	
	public Page(Browser browser, String siteRoot)
	{
		// Check if the current page is PSW or PPAP
		this.siteRoot = siteRoot;

		Page.browser = browser.getSession();
	}

	/*
	 * Load the page
	 */
	public void load()
	{
		browser.get(siteRoot);
	}
	
	public String whereAmI()
	{
		return browser.getCurrentUrl();
	}
	
	public WebDriver getBrowser() {
		return browser;
	}
}
