package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.dataRelated.ExcelManager;
import utilities.dataRelated.JDBCManager;
import utilities.dataRelated.JsonManager;
import utilities.elements.DriverUtil;
import utilities.reportRelated.TestListener;


public class TestBase extends TestListener {


	protected static JDBCManager sqlManager = new JDBCManager();
		
	protected static ExcelManager xlread = new ExcelManager();

	
	String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/JsonFile.json";
	protected JsonManager json = new JsonManager(filePath);
	

	
	
	
	
	
	// --------------- Before all @Test --------------------
	@BeforeTest
	public void beforeAllTestCase() {

		onExtentSetup();

	}
	
	
	

	// --------------- Before each @Test --------------------

	@BeforeMethod
	@Parameters("browser") // this parameter is used in testNG.xml
	public void beforeEachTestCase(String browser) {

		 driver = DriverUtil.startBrowser(browser);
		// driver = DriverUtil.startBrowserInPrivateMode(browser);
		// driver = DriverUtil.startDockerContainerBrowser(browser);

	}


	@AfterMethod
	public void tearDown() throws Exception {
		// Close the browser
		driver.close();
	}

	// --------------- After all @Test--------------------
	@AfterTest
	public void afterAllTestCase() {
		
		extent.flush();

	}
}
