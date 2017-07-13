package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Browser {

    protected RemoteWebDriver driver;
    protected String sessionType;
    private DesiredCapabilities caps;

    /*
     * Make a Selenium session
     */
    public Browser(String sessionType) throws Exception {
        caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("name", Variables.testTitle);
        caps.setCapability("screenResolution", "1280x1024");

        this.sessionType = sessionType;

        switch (sessionType) {

            case "ie10":
                caps.setCapability("version", "10.0");
                driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                driver.setFileDetector(new LocalFileDetector());
                break;
            case "ie11":
                caps.setCapability("version", "11.0");
                driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                driver.setFileDetector(new LocalFileDetector());
                break;
            case "chrome49":
                caps = null;
                caps = DesiredCapabilities.chrome();
                caps.setCapability("version", "49.0");
                caps.setCapability("name", Variables.testTitle);
                this.driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                break;
            case "chrome50":
                caps = null;
                caps = DesiredCapabilities.chrome();
                caps.setCapability("version", "50.0");
                caps.setCapability("name", Variables.testTitle);
                driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                driver.setFileDetector(new LocalFileDetector());
                break;
            case "chrome51":
                caps = null;
                caps = DesiredCapabilities.chrome();
                caps.setCapability("version", "51.0");
                caps.setCapability("name", Variables.testTitle);
                driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                driver.setFileDetector(new LocalFileDetector());
                break;
            case "chrome59":
                caps = null;
                caps = DesiredCapabilities.chrome();
                caps.setCapability("version", "59.0");
                caps.setCapability("name", Variables.testTitle);
                driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                driver.setFileDetector(new LocalFileDetector());
                break;
            case "iphone4s":
                caps = null;
                caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "9.0");
                caps.setCapability("deviceName", "iPhone 4s");
                caps.setCapability("deviceOrientation", "portrait");
                this.driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                break;
            case "iphone5":
                caps = null;
                caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "9.0");
                caps.setCapability("deviceName", "iPhone 5");
                caps.setCapability("deviceOrientation", "portrait");
                this.driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                break;
            case "iphone5s":
                caps = null;
                caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "9.0");
                caps.setCapability("deviceName", "iPhone 5s");
                caps.setCapability("deviceOrientation", "portrait");
                this.driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                break;
            case "iphone6":
                caps = null;
                caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "9.0");
                caps.setCapability("deviceName", "iPhone 6");
                caps.setCapability("deviceOrientation", "portrait");
                break;
            case "iphone6plus":
                caps = null;
                caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "9.0");
                caps.setCapability("deviceName", "iPhone 6 Plus");
                caps.setCapability("deviceOrientation", "portrait");
                break;
            case "iphone":
            case "ipad":
                caps = null;
                DesiredCapabilities caps = DesiredCapabilities.iphone();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("deviceOrientation", "portrait");
                setIphoneProperties(caps);
                caps.setCapability("name", Variables.testTitle);
                this.driver = new RemoteWebDriver(new URL(Variables.SAUCELABS_URL), caps);
                break;
            case "docker":
                caps = null;
                caps = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                this.driver = new RemoteWebDriver(new URL(Variables.DOCKER_URL(Variables.dockerIp, Variables.dockerPort)), caps);   
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().window().maximize();
                break;
            case "JLRIphone":
                caps = null;
                caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "JLR");
                caps.setCapability("udid", "2fc56a2b56f3d9d6d1d5f66fa54cbe2310bb3a7c"); //iPhone 4s
                //caps.setCapability("udid", "4d6dd631132e19e8948d1089244a6c13da4d85c8"); //iPhone 5
                caps.setCapability(MobileCapabilityType.APP, "/Users/mark/JLR/apps/epsw/platforms/ios/build/emulator/ePSW.app");
                this.driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                break;
            case "MarkIphone":
            	caps = null;
            	caps = new DesiredCapabilities();
            	DesiredCapabilities capabilities = new DesiredCapabilities();
        		caps.setCapability("appium-version", "1.0");
        		caps.setCapability("platformName", "iOS");
        		caps.setCapability("platformVersion", "9.3");
        		caps.setCapability("deviceName", "STA - JLR iPhone");
        		caps.setCapability("app", "/Users/mark/JLR/apps/epsw/platforms/ios/build/emulator/ePSW.app");
        		this.driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        		break;
            case "local":
            default:
                if (!"local".equalsIgnoreCase(sessionType)) {
                    System.out.println("Defaulting to  Chrome Locally");
                }
             //  System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\sateja\\Desktop\\rvseleniumtest\\chromedriver.exe");
                this.driver = new ChromeDriver();
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().window().maximize();
                break;

        }

    }

    /*
     * Get the Selenium session
     */
    public WebDriver getSession() {
        return driver;
    }

    /*
     * Kill the selenium session
     */
    public void endSession() {
        driver.quit();
    }

    /*
     * Get the session type
     */
    public String getSessionType() {
        return sessionType;
    }

    /*
     * Browser methods
     */
    public static void waitForElementToAppear(WebDriver driver, By element, int waitSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToAppear(WebDriver driver, By element) {
        waitForElementToAppear(driver, element, 30);
    }

    public void waitForElementToAppear(By element, int waitSeconds) {
        waitForElementToAppear(this.driver, element, waitSeconds);
    }

    public void waitForElementToAppear(By element) {
        waitForElementToAppear(this.driver, element);
    }

    public boolean doesElementExist(By element) {
        return doesElementExist(element, 10);
    }

    public boolean doesElementExist(By element, int seconds) {
        try {
            waitForElementToAppear(element, seconds);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public void scrollToElement(By element) {
        if (element == null) System.out.println("Null fail scrolling");
        driver.executeScript("window.scrollTo(0," + driver.findElement(element).getLocation().y + ")");
        driver.executeScript("window.scrollTo(0," + driver.findElement(element).getLocation().x + ")");

    }
    public void appiumBegrudginlgyScrollDown() {
    	driver.executeScript("mobile: scroll", new HashMap<String, String>() { { put("direction", "down"); }});
    }

    private void setIphoneProperties(DesiredCapabilities caps) {
        switch (Variables.appleDeviceModel) {
            case "6":
                caps.setCapability("deviceName", "iPhone 6");
                break;
            case "6+":
                caps.setCapability("deviceName", "iPhone 6 Plus");
                break;
            case "5":
                caps.setCapability("deviceName", "iPhone 5");
                break;
            case "5s":
                caps.setCapability("deviceName", "iPhone 5s");
                break;
            case "4s":
                caps.setCapability("deviceName", "iPhone 4s");
                break;
            case "retina 3.5":
                caps.setCapability("deviceName", "iPhone Retina (3.5-inch");
                break;
            case "retina 4":
                caps.setCapability("deviceName", "iPhone Retina (4-inch)");
                break;
            case "retina":
                caps.setCapability("deviceName", "iPad Retina");
                break;
            case "air":
                caps.setCapability("deviceName", "iPad Air");
                break;
            case "2":
                caps.setCapability("deviceName", "iPad 2");
                break;

        }
        caps.setCapability("version", Variables.iOS);
    }

    /**
     * Take a screenshot and save it to the /screenshots directory
     */
    public static void takeScreenShot(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        try {
            String path = "screenshots/screenshot-" + getNextScreenshotNumber() + "-" + (System.currentTimeMillis() / 1000) + ".png";
            System.out.println("Saved screenshot: " + path);
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            System.out.println("Could not save a screenshot.");
        }

    }

    private static String getNextScreenshotNumber() {
        File screenshotsFolder = new File("./screenshots/");

        if (screenshotsFolder.listFiles().length == 0) {
            return "0";
        }

        File[] existingScreenshots = screenshotsFolder.listFiles();
        ArrayList<String> existingScreenshotNames = new ArrayList<>();

        for (File file : existingScreenshots) {
            String[] number = file.getName().split("\\-");
            existingScreenshotNames.add(number[1]);
        }

        Collections.sort(existingScreenshotNames);

        return String.valueOf(Integer.valueOf(existingScreenshotNames.get(existingScreenshotNames.size() - 1).replaceAll("[^0-9]", "")) + 1);
    }
}
