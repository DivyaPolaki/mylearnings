package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import repository.LandingPageObjects;
import resources.base;
@Listeners(testcases.Listeners.class)

public class tc_validateFreePrice extends base{
	
	WebDriver driver;
	private static Logger log=LogManager.getLogger(tc_validateFreePrice.class.getClass());
	@BeforeTest
	public void invokeBrowser() throws IOException{
		driver=initializebrowser();
		
	}
	@Test
	public void tc2_getPriceUnderFeaturedCourses() throws IOException{
		NavigateUrl();
		LandingPageObjects landingp=new LandingPageObjects(driver);
		List<WebElement> courses=landingp.courselist();
		List<WebElement> deletedprice=landingp.deletedprice();
		List<WebElement> prices=landingp.prices();
		System.out.println("courses size: "+courses.size());
		int count=0;
		for (int i=0;i<courses.size();i++) {
		
		
				
	if (courses.get(i).getText().equalsIgnoreCase("Write effective QA Resume that will turn to interview call")) {
	System.out.println("The price for "+courses.get(i).getText()+" is "+prices.get(i).getText());
	log.error("The featured course is not found");
	}
	else{
	System.out.println("The actual price of "+courses.get(i).getText()+" is "+prices.get(i).getText().split("[\n]")[1].toString()+" and the deleted price is "+deletedprice.get(i).getText()+" and the combined price is "+prices.get(i).getText());
	log.fatal("Unable to retrive the featured course deleted prize");
	}	
	count++;		
		}
		System.out.println(count);
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
