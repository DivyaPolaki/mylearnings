package repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {
	WebDriver driver;
	public LandingPageObjects(WebDriver driver){
		this.driver=driver;
	}
	By Login=By.xpath("//span[text()='Login']");
	By Nothanks=By.xpath("//button[text()='NO THANKS']");
	By Home=By.linkText("Home");
	By practice=By.xpath("//a[@href='https://www.rahulshettyacademy.com/AutomationPractice']");
	By text_featuredcourseele=By.xpath("//h2[text()='Featured Courses']");
	By courselist=By.xpath("//ul[contains(@class,'course-list')]/li/div/h3");
	By allFeaturedcourses=By.xpath("//section[@id='content']/div[1]");
	By deletedprice=By.xpath("//div[@class='price']/del");
	By prices=By.xpath("//div[@class='price']");
	By bannerElements=By.xpath("//div[@role='navigation']//ul");
	By underfeaturedcourses=By.xpath("//h2[text()='Featured Courses']/parent::div/following-sibling::ul");
	
	public WebElement loginLink(){
		return driver.findElement(Login);

	}
	public WebElement NothanksLink(){
		return driver.findElement(Nothanks);
	}
public WebElement Homeink(){
	return driver.findElement(Home);
}
public WebElement practiceLink(){
	return driver.findElement(practice);
}
public WebElement text_featuredcourseele(){
	return driver.findElement(text_featuredcourseele);
}
public List<WebElement> allFeaturedcourses(){
	return driver.findElements(allFeaturedcourses);
}
public List<WebElement> courselist(){
	return driver.findElements(courselist);
}
public List<WebElement> deletedprice(){
	return driver.findElements(deletedprice);
}
public List<WebElement> prices() {
	// TODO Auto-generated method stub
	return driver.findElements(prices);
}
public List<WebElement> bannerElements() {
	// TODO Auto-generated method stub
	return driver.findElements(bannerElements);
}
public WebElement underfeaturedcourses(){
	return driver.findElement(underfeaturedcourses);
}
}

