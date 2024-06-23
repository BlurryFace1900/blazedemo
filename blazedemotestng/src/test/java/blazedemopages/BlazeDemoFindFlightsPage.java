package blazedemopages;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlazeDemoFindFlightsPage {
	
	WebDriver driver;
	
	By priceList = By.xpath("//table/tbody/tr/td[6]");
	By flightList = By.xpath("//table/tbody/tr/td[1]/input");
	

	public BlazeDemoFindFlightsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ListFlights() {
		ArrayList<WebElement> price = new ArrayList<WebElement>(driver.findElements(priceList));
		ArrayList<WebElement> flights = new ArrayList<WebElement>(driver.findElements(flightList));
		Float min = Float.parseFloat(price.get(0).getText().substring(1));
		int idx = 0;
		for(int i=0;i<price.size();i++) {
			System.out.println(price.get(i).getText());
			if(min > Float.parseFloat(price.get(i).getText().substring(1))) 
				idx = i;
//				min = Integer.parseInt(price.get(i).getText().substring(1));
		}
		System.out.println(price.get(idx).getText());
		flights.get(idx).click();
//		Collections.min(price);
	}
			
}
