package testCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTestClass {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/Elif/eclipse-workspace_DemoProject/demoProjectWW/src/test/resources/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.weightwatchers.com/us/find-a-meeting/1180510/ww-studio-flatiron-new-york-ny"); // enter URL
		
		List<WebElement> linkList = driver.findElements(By.xpath("(//div[contains(text(),'Thu') ]//parent::div)[1]//descendant::div[contains(@class,'schedule-detailed-day-meetings-item-leader')]"));
		
		System.out.println(linkList.size());
		
		
		
		
		// 
		ArrayList<String> ary = new ArrayList<String>();
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0;i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			ary.add(linkText);
		}
		
		for(String x:ary) {
			
			if(!hm.containsKey(x)) {
				hm.put(x, 1);
			}else {
				hm.put(x, hm.get(x)+1);
			}
		}
		System.out.println(hm);
		
		
//		String[] array= {"a","ab","abc"};
//		Map<String, Integer> hm = new HashMap<String, Integer>();
//		
//		for(String x:array) {
//			
//			if(!hm.containsKey(x)) {
//				hm.put(x, 1);
//			}else {
//				hm.put(x, hm.get(x)+1);
//			}
//		} 
		
		//[Find WW Studios & Meetings Near You | WW USA]
		//[Find WW Studios & Meetings Near You | WW USA]
	
		
		driver.quit();
		
	}
	
	
	
	
	

}
