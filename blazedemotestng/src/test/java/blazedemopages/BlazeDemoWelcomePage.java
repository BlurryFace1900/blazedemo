package blazedemopages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BlazeDemoWelcomePage {
	
	WebDriver driver;
	ExtentTest test;
	
	By header = By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]");
	By dropdownFrom = By.xpath("//select[@name='fromPort']");
	By dropdownTo = By.xpath("//select[@name='toPort']");
	By submit = By.xpath("//input");
			
	public BlazeDemoWelcomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void assertHeader() {
		test.log(Status.INFO, "Asserting Header of Welcome Page");

		String expectedHeader = "Welcome to the Simple Travel Agency!";
		String actualHeader = driver.findElement(header).getText();
		assertEquals(actualHeader, expectedHeader);
		test.addScreenCaptureFromPath(expectedHeader, actualHeader);
//		test.addScreenCaptureFromPath();
	}
	
	public void selectDestination(String from, String to) {
		Select fromDest = new Select(driver.findElement(dropdownFrom));
		Select toDest = new Select(driver.findElement(dropdownTo));
		
		fromDest.selectByVisibleText(from);
		toDest.selectByVisibleText(to);
		driver.findElement(submit).click();
		
	}	
	

}
