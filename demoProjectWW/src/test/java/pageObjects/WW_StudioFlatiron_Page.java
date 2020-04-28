package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PageBase;
import utilities.reportRelated.Log4jManager;

public class WW_StudioFlatiron_Page extends PageBase {
	
	String day;

	/*-----------url section----------------*/
	private String url = "https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny";

	/* ============= elements ================= */

	// primary section

	@FindBy(xpath = "//span[@ng-if='!linkName']")
	@CacheLookup
	private WebElement ww_StudioFlatiron_Title;

	@FindBy(xpath = "(//div[contains(text(),'Sun') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private List<WebElement> sunday;

	@FindBy(xpath = "(//div[contains(text(),'Mon') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private List<WebElement> monday;

	@FindBy(xpath = "(//div[contains(text(),'Tue') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private List<WebElement> tuesday;

	@FindBy(xpath = "(//div[contains(text(),'Wed') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private List<WebElement> wednesday;

	@FindBy(xpath = "(//div[contains(text(),'Thu') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private List<WebElement> thursday;

	@FindBy(xpath = "(//div[contains(text(),'Fri') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private WebElement friday;

	@FindBy(xpath = "(//div[contains(text(),'Sat') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]")
	@CacheLookup
	private WebElement saturday;

	// Footer Section

	// Assert Elements
	
	@FindBy(xpath = "//*[@id='ml-1180510']/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span")
	@CacheLookup
	private WebElement ww_StudioFlatiron;

	// ----------------------------------------------------

	/* ============= constructor ================= */

	public WW_StudioFlatiron_Page() {
		// super(driver);
		PageFactory.initElements(driver, this);
		driver.get(url);
		Log4jManager.info("we get the web");

	}

	/* ============= functions and assertions ================= */

	public WW_StudioFlatiron_Page assertWW_StudioFlatiron_PageTitile() {
		logger.info("Assert the Title");
		
		driver.navigate().back();
		wait.waitForPageLoad();
		String expected = ww_StudioFlatiron.getText();
		driver.navigate().forward();
		wait.waitForPageLoad();

		
		String title = ww_StudioFlatiron_Title.getText();
		assertEquals(title, expected);
		
		Log4jManager.info("Title Asserted");

		return this;

	}

	@SuppressWarnings("unchecked")
	public WW_StudioFlatiron_Page printMeetings(String day) {
		
		logger.info("print the number of meeting the each person by the day ");
		
		List<WebElement> linkList = null;
		
		if(day == "Sun") {
			linkList = (List<WebElement>) sunday;
		}else if(day == "Mon") {
			linkList = (List<WebElement>) monday;
		}else if(day == "Tue") {
			linkList = (List<WebElement>) tuesday;
		}else if(day == "Wed") {
			linkList = (List<WebElement>) wednesday;
		}else if(day == "Thu") {
			linkList = (List<WebElement>) thursday;
		}else if(day == "Fri") {
			linkList = (List<WebElement>) friday;
		}else if(day == "Sat") {
			linkList = (List<WebElement>) saturday;
		}
		
		
			
			ArrayList<String> ary = new ArrayList<String>();
			Map<String, Integer> hm = new HashMap<String, Integer>();
			
			for (int i = 0; i < linkList.size(); i++) {
				String linkText = linkList.get(i).getText();
				ary.add(linkText);
			}

			for (String x : ary) {

				if (!hm.containsKey(x)) {
					hm.put(x, 1);
				} else {
					hm.put(x, hm.get(x) + 1);
				}
			}
			System.out.println("testing ==================");
			System.out.println(hm);
	
	

		logger.info("Print Seccessfully done:  Result is: "+ day + " ==> "+hm);
		Log4jManager.info("Print Seccessfully done:  result is: "+hm);
		return this;

	}

}
/* ============= End ================= */
