package blazedemosetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import blazedemopages.BlazeDemoConfirmationPage;
import blazedemopages.BlazeDemoDestinationOfWeekPage;
import blazedemopages.BlazeDemoFindFlightsPage;
import blazedemopages.BlazeDemoFlightDetailPage;
import blazedemopages.BlazeDemoWelcomePage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.ExtentSparkReporter;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class BlazeDemoDriverSetup {
	
	WebDriver driver;
	BlazeDemoConfirmationPage blazeDemoConfirmationPage; 
	BlazeDemoDestinationOfWeekPage blazeDemoDestinationOfWeekPage;
	BlazeDemoFindFlightsPage blazeDemoFindFlightsPage;
	BlazeDemoFlightDetailPage blazeDemoFlightDetailPage;
	BlazeDemoWelcomePage blazeDemoWelcomePage;
	
	static ExtentTest test;
	static ExtentReports report;
	
//	public BlazeDemoDriverSetup(WebDriver driver) {
//		this.driver = driver;
//	}
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser) {
		report = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "report/Spark.html");
		report.attachReporter(spark);
		test = report.createTest("ExtentReport");
		
		switch(browser.toUpperCase()) {
			case "CHROME": this.driver = new ChromeDriver();
			break;
			case "EDGE": this.driver = new EdgeDriver();
			break;
			case "FIREFOX": this.driver = new FirefoxDriver();
			break;
			default: System.err.println("Browser type " + browser.toUpperCase() + " is not Supported");
		}
		driver.get("https://blazedemo.com/index.php");
	}
	
	
	@Test(priority = 1)
	public void header() {
		blazeDemoWelcomePage = new BlazeDemoWelcomePage(driver, test);
		blazeDemoWelcomePage.assertHeader();
	}
	
	@Test(priority = 2)
	public void destinationOfWeek() {
		blazeDemoDestinationOfWeekPage = new BlazeDemoDestinationOfWeekPage(driver);
		blazeDemoDestinationOfWeekPage.assertUrl();
		blazeDemoDestinationOfWeekPage.assertNewTab();
	}
	
	
	@Test(priority = 3)
	@Parameters({"from","to"})
	public void purchase(String from, String to) {
		blazeDemoWelcomePage = new BlazeDemoWelcomePage(driver, test); 
		blazeDemoWelcomePage.selectDestination(from, to);
		
	}
	
	@Test(priority = 4)
	public void chooseFlights() {
		blazeDemoFindFlightsPage = new BlazeDemoFindFlightsPage(driver); 
		blazeDemoFindFlightsPage.ListFlights();
		
	}
	
	@Test(priority = 5)
	public void flightsDetail() {
		blazeDemoFlightDetailPage = new BlazeDemoFlightDetailPage(driver); 
		blazeDemoFlightDetailPage.verifyTotalCostTag();
		blazeDemoFlightDetailPage.verifyTotalCostValue();
		blazeDemoFlightDetailPage.clickPurchase();
	}
	
	@Test(priority = 6)
	public void confirmation() {
		blazeDemoConfirmationPage = new BlazeDemoConfirmationPage(driver); 
		blazeDemoConfirmationPage.assertUrl();
		blazeDemoConfirmationPage.id();
	}
	
	@AfterTest
	public void dismantle() {
		driver.close();
	}
	
}
