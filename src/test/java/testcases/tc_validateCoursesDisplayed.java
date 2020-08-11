package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import repository.LandingPageObjects;
import resources.base;
@Listeners(testcases.Listeners.class)
public class tc_validateCoursesDisplayed extends base{
	private static Logger log=LogManager.getLogger(tc_validateCoursesDisplayed.class.getClass());
	WebDriver driver;
	Properties prop=new Properties();

	@BeforeTest
	public void invokeBrowser() throws IOException{
		driver=initializebrowser();
		
	}
	@Test
	public void tc4_validateFeaturedcourses() throws IOException{
		NavigateUrl();
		LandingPageObjects landingp=new LandingPageObjects(driver);
		AssertJUnit.assertTrue (landingp.text_featuredcourseele().isDisplayed()&&landingp.underfeaturedcourses().isDisplayed());	
		
		
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
