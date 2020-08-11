package testcases;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import repository.LandingPageObjects;
import repository.LoginPageObjects;
import resources.base;
@Listeners(testcases.Listeners.class)
public class tc_Login extends base{
	private static Logger log=LogManager.getLogger(tc_Login.class.getClass());
	WebDriver driver;
	Properties prop=new Properties();
	
	@BeforeTest
	public void invokeBrowser() throws IOException{
		driver=initializebrowser();
		
	}
	
	@Test(dataProvider="getData")
public void tc1(String Username,String Password) throws IOException {
		NavigateUrl();
	LandingPageObjects landingp=new LandingPageObjects(driver);
	//landingp.NothanksLink().click();
	landingp.loginLink().click();
	LoginPageObjects Loginp=new LoginPageObjects(driver);
	/*enterUserName();
	enterPassword();*/
	Loginp.userID().sendKeys(Username);
	Loginp.Password().sendKeys(Password);
	Loginp.loginButton().click();
	driver.manage().deleteAllCookies(); 
}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[3][2];
		data[0][0]="divipatnaik@gmail.com";
		data[0][1]="Divya";
		
		data[1][0]="deepakPolaki@gmail.com";
		data[1][1]="Deepak";
		
		data[2][0]="Advika@gmail.com";
		data[2][1]="Advika";
		log.info("Login with multiple data is performed");
		return data;
		
	}
	
	


	

	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
