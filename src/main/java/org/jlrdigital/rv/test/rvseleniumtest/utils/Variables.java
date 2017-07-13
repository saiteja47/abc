package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.jlrdigital.rv.test.rvseleniumtest.utils.PswEnums.Context;


 
public class Variables {
	static Properties settings = new Properties();
    static InputStream input = null;

  private static String masterPassword = "statest";
    private static String engineerPassword = "temp@1234";
    
	//Supplier login credentials
    public static final String supplierLogin = "DMORGAN";
    public static String supplierPassword = masterPassword;

    //STA Engineer login credentials
    public static String staEngineerPassword = "jlr@1234";
    public static final String staEngineerLogin = "cgibbs1";

    //Manager login credentials
    public static final String staManagerUsername = "dstanle1";
   public static String staManagerPassword = masterPassword;

    //Sd login credentials
    public static final String sdLogin = staEngineerLogin;
    public static String sdManagerPassword = engineerPassword;

    //SPQ_PP Engineer
    public static String spqPassword = masterPassword;
    public static final String spqLogin = "dhathaw1";

    //PD Engineer login credentials
    public static String pdEngineerPassword = masterPassword;
    public static final String pdEngineerLogin = "tsteven1";
    public static final String pdEngineerEmail = "tsteven1@jaguarlandrover.com"; 
    
    //RV Engineer login credentials
   // public static String rvUserPassword = "euprov";
    public static final String rvJaguarUserLogin = "A-AINSWO";
    public static final String rvJaguarUserPassword = "jlrprov";
    public static final String rvJaguarUserIncorrectPassword = "abcdef";
    public static final String rvJaguarInvalidUserLogin = "ABCDEF";
    public static final String rvJaguarEmptyUserLogin = "";
    public static final String rvJaguarEmptyUserPasswrod = "";
    
    public static final String rvLandroverJaguarUserLogin = "A-ABDI";
    public static final String rvLandroverrUserPassword = "jlrprov";
    public static final String rvlandroverUserIncorrectPassword = "fedcba";
    public static final String rvLandroverInvalidUserLogin = "mistake";
    public static final String rvLandroverEmptyUserLogin = "";
    public static final String rvLandroverEmptyUserPasswrod = "";
    
    //RV Engineer UAT login credentials
  //  public static String rvUserPassword = "euprov";
   // public static final String rvUserLogin = "eupreprod";
    
    // Site settings
    public static String rvRoot;

    // Sauce lab settings
    private static String sauceLabsUser;
    private static String sauceLabsKey;
    public static final String SAUCELABS_URL = 
            "http://" + sauceLabsUser + ":" + sauceLabsKey + "@ondemand.saucelabs.com:80/wd/hub";

    // Docker settings
    public static String dockerIp;
    public static String dockerPort;

    public static String DOCKER_URL(String ip, String port)
    {
        return "http://" + ip + ":" + port + "/wd/hub";
    }

    // Browser settings
    public static String browserName;
    public static String appleDeviceModel;
    public static String iOS;
   
    // Test settings
    public static String testTitle;
    public static String dbUser;
    public static String dbPass;
    public static String useDBUnit;
    public static String mariaDbUrl;
    public static String appServerIp;
    
    //context
    public static Context context = PswEnums.Context.APP;

    public static String debug;

    static {
        try {
            input = new FileInputStream("config.properties");
            settings.load(input);

            dockerIp = settings.getProperty("dockerIp");
            dockerPort = settings.getProperty("dockerPort");

            sauceLabsUser = settings.getProperty("sauceLabsUser");
            sauceLabsKey = settings.getProperty("sauceLabsKey");

            browserName = settings.getProperty("browserName");
            appleDeviceModel = settings.getProperty("appleDeviceModel");
            iOS = settings.getProperty("iOS");

            masterPassword = settings.getProperty("masterPassword");
            supplierPassword = masterPassword;
            
            engineerPassword = settings.getProperty("engineerPassword");
            if(engineerPassword != null) {
            	staEngineerPassword = engineerPassword;
            	staManagerPassword = engineerPassword;
            	spqPassword = engineerPassword;
            	pdEngineerPassword = engineerPassword;
            } else {
            	staEngineerPassword = masterPassword;
            	staManagerPassword = masterPassword;
            	spqPassword = masterPassword;
            	pdEngineerPassword = masterPassword;
            }

            rvRoot = settings.getProperty("rvRoot");
            useDBUnit = settings.getProperty("useDBUnit");
            dbUser = settings.getProperty("dbUser");
            dbPass = settings.getProperty("dbPass");
            mariaDbUrl = settings.getProperty("mariaDbUrl");
            appServerIp = settings.getProperty("appServerIp");

            testTitle = settings.getProperty("testTitle");

            debug = settings.getProperty("debug");
            
        } catch (Exception e) {
            System.out.println("Error with properties");
            System.out.println(e.getMessage());
        }
        dbPass = "LunK5$jkUfGsbZw";
    }

}
