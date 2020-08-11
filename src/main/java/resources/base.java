package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




import repository.LoginPageObjects;

public class base {

	WebDriver driver;
	Properties prop=new Properties();
	

	public WebDriver initializebrowser() throws IOException{
		
		FileInputStream fis=new FileInputStream("C://Users//Phani//Documents//selenium//E2Eproject//src//main//java//resources//Properties.properties");
		prop.load(fis);
		String browser=prop.getProperty("Browser");
switch (browser){
	

case "chrome":
//	browser.equals("chrome");
	System.setProperty("webdriver.chrome.driver", "C://Users//Phani//Downloads//chromedriver_win32(1)//chromedriver.exe");
	driver=new ChromeDriver();
	break;
case "Firefox":
	browser.equals("Firefox");
	//System.setProperty("webdriver.chrome.driver", "C://Users//Phani//Downloads//chromedriver.exe");
	driver=new FirefoxDriver();
	break;
case "IE":
	browser.equals("IE");
	//System.setProperty("webdriver.chrome.driver", "C://Users//Phani//Downloads//chromedriver.exe");
	driver=new InternetExplorerDriver();
	break;
	default:
		}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

}
public void NavigateUrl() throws IOException{
	FileInputStream fis=new FileInputStream("C://Users//Phani//Documents//selenium//E2Eproject//src//main//java//resources//Properties.properties");
	prop.load(fis);
	String url=prop.getProperty("URL");
	driver.get(url);
}
public void enterUserName() throws IOException{
	FileInputStream fis=new FileInputStream("C://Users//Phani//Documents//selenium//E2Eproject//src//main//java//resources//Properties.properties");
	prop.load(fis);
	String username=prop.getProperty("UserId");
	LoginPageObjects Loginp=new LoginPageObjects(driver);
	Loginp.userID().sendKeys(username);
}
public void enterPassword() throws IOException{
	FileInputStream fis=new FileInputStream("C://Users//Phani//Documents//selenium//E2Eproject//src//main//java//resources//Properties.properties");
	prop.load(fis);
	String password=prop.getProperty("password");
	LoginPageObjects Loginp=new LoginPageObjects(driver);
	Loginp.Password().sendKeys(password);
}
public String getScreenshot(String testName, WebDriver driver) throws IOException{
TakesScreenshot ts=((TakesScreenshot)driver);
File src=ts.getScreenshotAs(OutputType.FILE);
String destination=System.getProperty("user.dir")+"\\reports\\"+testName+".png";
FileUtils.copyFile(src, new File(destination));
return destination;
}

}