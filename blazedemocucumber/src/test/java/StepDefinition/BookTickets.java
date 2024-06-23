package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookTickets {
	

	@Given("Launch Chrome Browser")
	public void launch_chrome_browser() {
	  System.out.println(1);  
	  
	}
	
	@When("Navigate to Website")
	public void navigate_to_website() {
		System.out.println(2);  
	  
	}
	
	@Then("Choose from Destination as Mexico City")
	public void choose_from_destination_as_mexico_city() {
		System.out.println(3);  
	  
	}
	
	@Then("Choose to Destination as London")
	public void choose_to_destination_as_london() {
		System.out.println(4);  
		
	}
	
	@Then("Click Submit")
	public void click_submit() {
		System.out.println(5);  
	  
	}
	
	@Then("Choose Cheapest Airline")
	public void choose_cheapest_airline() {
		System.out.println(6);  
	  
	}
	
	@Then("Verify Total Amount")
	public void verify_total_amount() {
		System.out.println(7);  
	  
	}
	
	@Then("Click Purchase")
	public void click_purchase() {
		System.out.println(8);  
	  
	}
	
	@Then("Verify Comfirmation URL")
	public void verify_comfirmation_url() {
		System.out.println(9);  
	  
	}
	
	@Then("Save ID")
	public void save_id() {
		System.out.println(10);  
	  
	}

}
