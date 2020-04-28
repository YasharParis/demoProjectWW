package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import utilities.reportRelated.Log4jManager;

public class WW_HomePage extends PageBase {
	
	
	String actualTitle;
	
	/*-----------url section----------------*/
	private String url = "https://www.weightwatchers.com/us/";

	/* ============= elements ================= */

	// Header Section

	@FindBy(xpath = "//*[@id='logo']/div/div/div")
	@CacheLookup
	private WebElement logo;
	
	@FindBy(xpath = "//*[@id='ela-nav_header_pricing']")
	@CacheLookup
	private WebElement pricing_menu;
	
	
	@FindBy(xpath = "//*[@id='header']/div/div/div/div[1]/div[2]/nav/div/div/div/ul/li[2]")
	@CacheLookup
	private WebElement howItWorks_menu;
	
	@FindBy(xpath = "//*[@id='ela-nav_header_healthy-living']")
	@CacheLookup
	private WebElement healthyLiving_menu;
	
	@FindBy(xpath = "//*[@id='ela-nav_header_shop']")
	@CacheLookup
	private WebElement shop_menu;
	
	@FindBy(xpath = "//*[@id='ela-menu-visitor-desktop-supplementa_sign-up']")
	@CacheLookup
	private WebElement signUp_link;
	
	@FindBy(xpath = "//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']")
	@CacheLookup
	private WebElement findWorkshop_link;
	
	@FindBy(xpath = "//*[@id='ela-nav_profile_login']")
	@CacheLookup
	private WebElement login_link;
	
	
	// Main Section
	
	// Footer Section
	
	// Assert Elements
	
	
	
	
	
	
	

	// ----------------------------------------------------

	/* ============= constructor ================= */

	public WW_HomePage() {
		// super(driver);
		PageFactory.initElements(driver, this);
		driver.get(url);
		Log4jManager.info("we get the web");

	}

	/* ============= functions and assertions ================= */

	public WW_HomePage assertHomePageTitile(String expectedTitle) {
		logger.info("Assert Home Page Title");
		
		//wait.waitTillClickable(findWorkshop_link);
		
		actualTitle = driver.getTitle();
		wait.customWait(1);
		
		assertEquals(actualTitle, expectedTitle);
		Log4jManager.info("Title Asserted");
		

		return this;

	}
	
	public FindaWorkshopPage clickFindWorkshoplink() {
		logger.info("clik the Find a Workshop Link");
		
		wait.waitTillClickable(findWorkshop_link);
		findWorkshop_link.click();

		Log4jManager.info("Click Successful");
		return new FindaWorkshopPage();
		
	}
	

	

}
/* ============= End ================= */


