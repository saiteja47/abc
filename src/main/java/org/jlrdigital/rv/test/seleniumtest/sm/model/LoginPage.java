package org.jlrdigital.rv.test.seleniumtest.sm.model;

import org.openqa.selenium.By;

/**
 * Created by Fraser on 15/02/2017.
 */
public abstract class LoginPage {
    public static By nameInput = By.name("userNameInput");
    public static By passwordInput = By.name("passwordInput");
    public static By loginButton = By.id("loginButton");
    public static By loadingAnimation = By.className("sk-cube-grid");
}
