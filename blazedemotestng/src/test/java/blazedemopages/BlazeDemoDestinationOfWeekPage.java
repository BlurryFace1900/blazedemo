package blazedemopages;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

//import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BlazeDemoDestinationOfWeekPage {

	WebDriver driver;
	
	By destinationOfWeek = By.xpath("//*[contains(text(),'destination of the week! The Beach!')]");

	public BlazeDemoDestinationOfWeekPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertNewTab() {
		Set<String> browserTabs = driver.getWindowHandles();
		SoftAssert sa = new SoftAssert();
		System.out.println("Tabs : " + browserTabs.size());
//		assertTrue(browserTabs.size() > 1);
		driver.navigate().back();

		sa.assertEquals(browserTabs.size(), 2, "New Tab did not open");
		sa.assertAll();
		
	}
	
	public void assertUrl() {
		driver.findElement(destinationOfWeek).click();
		String expectedUrl = "vacation";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Url : " + actualUrl + " " + actualUrl.contains(expectedUrl));
		assertTrue(actualUrl.contains(expectedUrl));
	}
	
}
