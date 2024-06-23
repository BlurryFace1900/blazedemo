package blazedemopages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoConfirmationPage {
	
	WebDriver driver;
	
	By id = By.xpath("(//table/tbody/tr/td[2])[1]");
	

	public BlazeDemoConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertUrl() {
		String expectedUrl = "confirmation";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Url : " + actualUrl + " " + actualUrl.contains(expectedUrl));
		assertTrue(actualUrl.contains(expectedUrl));
	}
	
	public void id() {
		System.out.println("Ticket ID : " + driver.findElement(id).getText());
	}

}
