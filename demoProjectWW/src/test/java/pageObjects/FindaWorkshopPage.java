package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import utilities.reportRelated.Log4jManager;

public class FindaWorkshopPage extends PageBase {

	String actualTitle;

	/*-----------url section----------------*/
	private String url = "https://www.weightwatchers.com/us/find-a-meeting/";

	/* ============= elements ================= */

	// Primary Section

	@FindBy(xpath = "//*[@id='meetingSearch']")
	@CacheLookup
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn spice-translated']")
	@CacheLookup
	private WebElement search_btn;

	// Search Result Section

	@FindBy(xpath = "//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span")
	@CacheLookup
	private WebElement ww_StudioFlatiron;
	
	public WebElement getww_StudioFlatiron_title() {
        return this.ww_StudioFlatiron;
    }
	
	

	@FindBy(xpath = "//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]")
	@CacheLookup
	private WebElement ww_StudioFlatiron_distance;
	
	
	
	
	
	

	// ----------------------------------------------------

	/* ============= constructor ================= */

	public FindaWorkshopPage() {
		// super(driver);
		PageFactory.initElements(driver, this);
		driver.get(url);
		Log4jManager.info("we get the web");

	}

	/* ============= functions and assertions ================= */

	public FindaWorkshopPage assertPageTitle(String expected_FindaWorkShop_PageTitle) {
		logger.info("Assert Page Title");

		wait.waitTillVisible(search_btn);

		actualTitle = driver.getTitle();
		wait.customWait(2);

		assertEquals(actualTitle, expected_FindaWorkShop_PageTitle);

		Log4jManager.info("Title Assertion Essecuted ");
		return this;

	}

	public FindaWorkshopPage getSearchBox(String input) {
		logger.info("Search Box Input");

		wait.waitTillVisible(searchBox);
		searchBox.clear();
		searchBox.sendKeys(input);
		wait.customWait(1);
		search_btn.click();
		wait.customWait(2);

		Log4jManager.info("Search Botton clicked");
		return this;

	}
	
	public WW_StudioFlatiron_Page clickFirstResult() {
		logger.info("Navigate to first result");

		wait.waitTillVisible(ww_StudioFlatiron);
		ww_StudioFlatiron.click();
		
		Log4jManager.info("First Result clicked");
		return new WW_StudioFlatiron_Page();

	}
	
	
	
	public FindaWorkshopPage printTitleandDistance() {

		logger.info("Get the title of the first result");
		wait.waitTillVisible(ww_StudioFlatiron);
		String title = ww_StudioFlatiron.getText();
		String distance = ww_StudioFlatiron_distance.getText();

		System.out.println(title + distance);
		
		logger.info("Print Title: "+ title);
		logger.info("Print Distance: "+ distance);

		return this;
	}


}
/* ============= End ================= */
