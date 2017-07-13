package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Page;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.openqa.selenium.By;

public class PageLogin extends Page
{
	public static By username = By.name("userNameInput");
	public static By password = By.name("passwordInput");
	public static By loginButton = By.tagName("button");

	public static By errorId = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/div/div/div[2]/p/span");
	public static By errorPassword = By.xpath("//*[@id=\"app\"]/div/div/div/div/form/div/div/div[3]/p/span");



	public static By loginFailureMessage = By.className("error");
	
	public PageLogin(Browser browser) {
		super(browser, Variables.rvRoot);
	}

	/*
	 * Actions
	 */
	private void setUsername(String username) {
		browser.findElement(PageLogin.username).sendKeys(username);
	}
	
	private void setPassword(String password) {
		browser.findElement(PageLogin.password).sendKeys(password);
	}
	
	private void clickLoginButton() {
		browser.findElement(loginButton).click();
	}
	
	// Login to the application
	public void login(String loginName, String loginPass)
	{
		setUsername(loginName);
		System.out.println(loginPass);
		setPassword(loginPass);
		clickLoginButton();
	}
}
