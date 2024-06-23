package blazedemopages;

import static org.testng.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeDemoFlightDetailPage {
	
	WebDriver driver;
	
	By totalCostValue = By.xpath("//*[contains(text(),'Total Cost')]//em");
	By totalCostTag = By.xpath("//*[contains(text(),'Total Cost')]");
	By purchaseFlightButton = By.xpath("//input[@value='Purchase Flight']");

	public BlazeDemoFlightDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyTotalCostTag() {
		assertTrue(driver.findElement(totalCostTag).isDisplayed());
	}

	public void verifyTotalCostValue() {
		Pattern pattern = Pattern.compile("^\\d{3}\\.\\d{2}$");
	    Matcher matcher = pattern.matcher(driver.findElement(totalCostValue).getText());
	    System.out.println(driver.findElement(totalCostValue).getText());
		assertTrue(matcher.find());
	}
	
	public void clickPurchase() {
		driver.findElement(purchaseFlightButton).click();
	}
	
}
