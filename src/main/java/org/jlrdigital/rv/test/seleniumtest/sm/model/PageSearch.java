package org.jlrdigital.rv.test.seleniumtest.sm.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Browser;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Page;
import org.jlrdigital.rv.test.rvseleniumtest.utils.Variables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class PageSearch extends Page {

	
	
//constructor
	public PageSearch(Browser browser) 
	{
		super(browser, Variables.rvRoot);
	}
	
	//locaters
	
	public static By searchfinder=By.className("search-order-input-button");
	
	public static By F_pace=By.id("model_f-pace");
    public static By F_type=By.id("model_f-type");
    public static By XE_saloon=By.id("model_xe_saloon");
    public static By XF_saloon=By.id("model_xf_saloon");
    public static By XJ_saloon=By.id("model_xj_saloon");
    public static By All_Models=By.id("search_model");
  //  public static By Stock=By.className("switch-buttons switch-buttons-toggle ");
    public static By stock=By.xpath("//*[@class='switch-buttons switch-buttons-toggle ']");
	public static By search=By.id("header_search");
	
public static By F_pace1=By.id("result_SADCA2AN8HA886501");
	//Derivatives
	public static By portfolio_yes=By.id("portfolio_yes");
	public static By portfolio_no=By.id("portfolio_no");
	public static By prestige_yes=By.id("prestige_yes");
	public static By prestige_no=By.id("prestige_no");
	public static By britishdesign_yes=By.id("british_design_yes");
	public static By britishdesign_no=By.id("british_design_no");
	public static By premiumluxury_yes=By.id("premium_luxury_yes");
	public static By premiumluxury_no=By.id("premium_luxury_no");
	public static By autobiography_yes=By.id("autobiography_yes");
	public static By autobiography_no=By.id("autobiography_no");
	public static By s_yes=By.id("s_yes");
	public static By s_no=By.id("s_no");
	public static By rsport_yes=By.id("r-sport_yes");
	public static By rsport_no=By.id("r-sport_no");
	public static By r_yes=By.id("r_yes");
	public static By r_no=By.id("r_no");
	public static By  se_yes=By.id("se_yes");
	public static By se_no=By.id("se_no");
	public static By svr_yes=By.id("svr_yes");
	public static By svr_no=By.id("svr_no");
	
	
	
	
	
	//methods
	
public void FPace() throws Exception
{
	browser.findElement(F_pace).isDisplayed();
	Thread.sleep(3000);
	browser.findElement(F_pace).click();

	System.out.println("click on F pace");
}
	
public void FType() throws Exception
{
	browser.findElement(F_type).isDisplayed();
	Thread.sleep(3000);
	browser.findElement(F_type).click();
	System.out.println("click on F Type");
}
	
public void XESaloon() throws Exception
{
	browser.findElement(XE_saloon).isDisplayed();
	Thread.sleep(3000);
	browser.findElement(XE_saloon).click();
	System.out.println("click on XE saloon");
}
	
public void XFSaloon() throws Exception
{
	browser.findElement(XF_saloon).isDisplayed();
	Thread.sleep(3000);
	browser.findElement(XF_saloon).click();
	System.out.println("click on XFSaloon");
}
	
public void XJSaloon() throws Exception
{
	browser.findElement(XJ_saloon).isDisplayed();
	Thread.sleep(3000);
	browser.findElement(XJ_saloon).click();
	System.out.println("click on XJSaloon");
}

	
public void ALLModelSelect() throws Exception
{
	Thread.sleep(2000);
	browser.findElement(F_pace).click();
	browser.findElement(F_type).click();
	browser.findElement(XE_saloon).click();
	browser.findElement(XF_saloon).click();
	browser.findElement(XJ_saloon).click();
	Thread.sleep(2000);
	System.out.println("Selected all the models");
	
}


public void stock() throws Exception
{

	/*Thread.sleep(2000);
	browser.findElement(F_pace).click();
	browser.findElement(F_type).click();
	browser.findElement(XE_saloon).click();
	browser.findElement(XF_saloon).click();
	browser.findElement(XJ_saloon).click();
	Thread.sleep(2000);*/
	System.out.println("Selected all the models");
browser.findElement(stock).click();	
Thread.sleep(2000);
System.out.println("stock selected");
}

public void derivativesyes()
{
	browser.findElement(portfolio_yes).click();
	browser.findElement(prestige_yes).click();
	browser.findElement(britishdesign_yes).click();
	browser.findElement(premiumluxury_yes).click();
	browser.findElement(autobiography_yes).click();
	browser.findElement(s_yes).click();
	browser.findElement(rsport_yes).click();
	browser.findElement(r_yes).click();
	browser.findElement(se_yes).click();
	browser.findElement(svr_yes).click();
}

public void derivativesno()
{
	browser.findElement(portfolio_no).click();
	browser.findElement(prestige_no).click();
	browser.findElement(britishdesign_no).click();
	browser.findElement(premiumluxury_no).click();
	browser.findElement(autobiography_no).click();
	browser.findElement(s_no).click();
	browser.findElement(rsport_no).click();
	browser.findElement(r_no).click();
	browser.findElement(se_no).click();
	browser.findElement(svr_no).click();
}
















}
	/*

public void Fpacecheck()
{
	String exp="F-PACE - 2.0d I4D 163/180 PS R-Sport";
	String act="";
	browser.findElement(F_pace).
	if (exp==act)
	{
		System.out.println("fpace showing correct data");
	} else 
	{
System.out.println("fpace showing incorrect data");
	}
}

String bodyText = driver.findElement(By.tagName("body")).getText();
Assert.assertTrue("Text not found!", bodyText.contains(text));


}
	
	
	
	public void check()
	{
		browser.findElement(F_pace).click();
		browser.findElement(F_pace1);
		if () 
		{
			
		} else {

		}
		
		
	}
	
	
	
	
	
	
	
	
	
	/*
	
	
	
	
	
	// TODO: Move the welcome page links to names
	public static By search = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div[2]/div/div[1]/a");
	public static By logo = By.className("header-logo");
	public static By F_pace=By.id("model_f-pace");
	
	public static By searchfinder=By.className("search-order-input-button");
	
	public static By compare = By.xpath(".//*[@id='app']/div/div/div/div/div[1]/div[2]/div/div[2]/a");
	public static By model = By.xpath(".//*[@id='app']/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div[2]");
	public static By discovery = By.xpath("//div[@id='model_name_discovery']");
	public static By discoverySport = By.xpath("//div[@id='model_name_discovery_sport']");
	public static By discoveryTest = By.xpath("//div[@id='model_name_discovery_test']");
	public static By discoveryTest1 = By.xpath("//div[@id='model_name_discovery_test']");
	//*[@id="model_name_discovery_test"]
	//*[@id="model_name_discovery_test"]
	//*[@id="model_discovery"]
	public static By evoque = By.xpath("//div[@id='model_name_evoque']");
	public static By rangeRover = By.xpath("//div[@id='model_name_range_rover']");
	public static By rangeRoverSport = By.xpath("//div[@id='model_name_range_rover_sport']");
	//*[@id="f-type_svr_yes"]
	public static By derFTypeSvr = By.xpath("//div[@id='f-type_svr_yes']");
	//public static By derXfCambridgeLe =By.xpath("//div[@id='xf_cambridge le_yes']");
	public static By derXfCambridgeLe =By.xpath("//div[@id='xf_cambridge_le_yes']");
	//public static By derSwitchTl4HighSpec = By.xpath("div[@id='tl4_- high spec (hse lux)_yes']");
	public static By derSwitchTl4HighSpec = By.xpath("div[@id='tl4_-_high_spec_(hse_lux)_yes']");
	public static By derXfSPremiumLuxury = By.xpath("div[@id='xf_s premium luxury_yes']");
	public static By result = By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]");
	
	
	//public static By reports = By.name("reports");
	//public static By colAinGreen =By.xpath("div[@id= 'colour_name_Aintree Green']");
	//public static By colAruba =By.xpath("div[@id= 'colour_name_Aruba']");
	//public static By colBarBlack = By.xpath("div[@id='colour_name_Barolo Black']");
	//public static By colGorGrey = By.xpath("div[@id='colour_name_Corris Grey']");
	//public static By colFirRed = By.xpath("div[@id='colour_name_Firenze Red']");
	//public static By colFujWhite = By.xpath("div[@id='colour_name_Fuji White']");
	//public static By colIndSilver = By.xpath("div[@id='colour_name_Indus Silver']");
	//public static By colMarBlack = By.xpath("div[@id='colour_Mariana Black']");
	//public static By colMonRed = By.xpath("div[@id='colour_name_Montalcino Red']");
	//public static By colSanBlack = By.xpath("div[@id='colour_name_Santorini Black']");
	//public static By colScoGrey = By.xpath("div[@id='colour_name_Scotia Grey']");
	//public static By colWaiGrey = By.xpath("div[@id='colour_name_Waitomo Grey']");
	//public static By colYulWhite = By.xpath("div[@id='colour_name_Yulong White']");
	//public static By colZanzibar = By.xpath("div[@id='colour_name_Zanzibar']");
	
	
	
	
	
	//*[@id="colour_name_Fuji White"]
	
	//*[@id="colour_name_Aintree Green"]
	//*[@id="colour_name_Aruba"]
	//*[@id="colour_name_Barolo Black"]
	//*[@id="colour_name_Carpathian Grey"]
	//*[@id="colour_Corris Grey"]
	//*[@id="colour_name_Firenze Red"]
	//*[@id="colour_name_Fuji White"]
	//*[@id="colour_name_Indus Silver"]
	//*[@id="colour_name_Loire Blue"]
	//*[@id="colour_Mariana Black"]
	//*[@id="colour_name_Montalcino Red"]
	//*[@id="colour_name_Santorini Black"]
	//*[@id="colour_name_Scotia Grey"]
	//*[@id="colour_name_Waitomo Grey"]
	//*[@id="colour_name_Yulong White"]
	//*[@id="colour_name_Zanzibar"]

	public static By logOut = By.xpath("div[id='//*[@id='header_logout']");
	
	public void verifylogo()
	{
		
		System.out.println(browser.findElement(logo).getText());
		
	}
	
	public PageSearch(Browser browser) 
	{
		super(browser, Variables.rvRoot);
	}
	
	public void clickSearchLink() {
		browser.findElement(search).click();
		
	}
	

	
		public void clickCompareLink() {
		browser.findElement(compare).click();
	}

		
		public void clickmodel() {
		browser.findElement(model).click();
	}
		public void FPace()
		{
			browser.findElement(F_pace).click();
			System.out.println("click on F pace");
		}
	
	public void clickmodel1() {
		browser.findElement(discovery).click();
		System.out.println("---model discovery-----------");
		
	}
	
	public void clickmodel2() {
		browser.findElement(discoverySport).click();
		System.out.println("----model2--- discovery sport--------");
		
	}
	
	public void clickmodel3() {
		browser.findElement(discoveryTest).click();
		System.out.println("----model3--- DiscoveryTest--------");
		
	}
	public void clickmodel4() {
		browser.findElement(evoque).click();
		System.out.println("----model4--- evoque--------");
		
	}
	public void clickmodel5() {
		browser.findElement(rangeRover).click();
		System.out.println("----model5--- Range Rover--------");
		
	}
	public void clickmodel6() {
		browser.findElement(rangeRoverSport).click();
		System.out.println("----model6--- DiscoveryTest--------");
		
	}
	
	public void derFTypeSvrYClick() {
		browser.findElement(derFTypeSvr).click();
		System.out.println("----derFTypeSvr--------");
	}	
	
	public void derXfCambridgeLeYClick() {
		browser.findElement(derXfCambridgeLe).click();
		System.out.println("----derivativefy--------");
		
	}
	public void derSwitchTl4HighSpecYClick() {
		browser.findElement(derSwitchTl4HighSpec).click();
		System.out.println("----switch_tl4_- high spec (hse lux)_label--------");
		
	}
	public void derXfSPremiumLuxuryYClick() {
		browser.findElement(derXfSPremiumLuxury).click();
		System.out.println("----XF S Premium Luxury--------");
		
	}
	
	public void logOutClick() {
		browser.findElement(logOut).click();
		System.out.println("----logOut--------");
		
	}
	
	public  List<WebElement> result() {
		
		WebElement worklistContainer = browser.findElement(By.className("search-results-container")); 
        List<WebElement> workLists = worklistContainer.findElements(By.className("search-result__item")); 
        System.out.println(workLists.size());
       // ;
        System.out.println(workLists.get(0).findElement(By.xpath("//div[@id='result_name_SALLAAAG5GA833046']")).getText());
        System.out.println(workLists.get(0).findElement(By.xpath("//div[@id='result_engine_SALLAAAG5GA833046']")).getText());
        System.out.println(workLists.get(0).findElement(By.xpath("//div[@id='result_engine_SALLAAAG5GA833046']")).getText());
        
      //System.out.println(workLists.get(1).findElement(By.xpath(//*[@id='app']/div/div/div/div/div/section[2]/div/div[2]/div/div[1]/div[1]/div[1]")).getText());
        //System.out.println(workLists.get(1).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]")).getText());
            /*  System.out.println(workLists.get(2).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[3]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(3).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[6]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(4).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[5]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(5).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[8]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(6).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[7]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(7).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[7]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(8).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[8]/div/div[1]/div[1]/div[1]")).getText());
        System.out.println(workLists.get(9).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[9]/div/div[1]/div[1]/div[2]")).getText());
        System.out.println(workLists.get(10).findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/div[2]/div[10]/div/div[1]/div[1]/div[1]")).getText());*/
    /*    //Assert.assertEquals("discovery", actual);
        return workLists;
		
	}
	// Select  the model
	/*	public void RVMODEL()
		{
			
			clickmodel1();
		}
/*	public void clickReportsLink() {
		browser.findElement(reports).click();
	}

}*/
/*public void Colourselected() 
{
	browser.findElement(derXfCambridgeLe).click();
	System.out.println("----derivativefy--------");
	
}
}*/
