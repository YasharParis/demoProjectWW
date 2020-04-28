package testCase.sysE2E;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindaWorkshopPage;
import pageObjects.WW_HomePage;

public class FindaStudio_feature extends TestBase {

	WW_HomePage homePage;
	FindaWorkshopPage findStudioP;

	@Test
	public void findWorkShopFeatureTest() {

		logger = extent.createTest("WW_FindWorkshop_Test");


		// ----------------- In case excel file corrupted in GetHub---------------
		// ---------------- Row Data --------------------------------------------

		// ---------------- test data: -------------------
		String 
				expectedHomePageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help",
				input = "10011",
				expected_FindaWorkShop_PageTitle= "Find WW Studios & Meetings Near You | WW USA",
				day = "Sun";

		// test execution/ test steps
		
		
		

		homePage = new WW_HomePage(); 								
		
		

		homePage															// 1. Navigate to https://www.weightwatchers.com/us/
		.assertHomePageTitile(expectedHomePageTitle)						// 2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
		.clickFindWorkshoplink()											// 3. On the right corner of the page, click on “Find a Studio”
		.assertPageTitle(expected_FindaWorkShop_PageTitle) 					// 4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”				
		.getSearchBox(input) 												// 5. In the search field, search for meetings for zip code: 10011
		.printTitleandDistance()											// 6. Print the title of the first result and the distance (located on the right of location title/name)
		.clickFirstResult()  												// 7. Click on the first search result and then, verify displayed location name/title matches with the name of the first
		.assertWW_StudioFlatiron_PageTitile()
		.printMeetings(day)													// 9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
		;

	}

}
