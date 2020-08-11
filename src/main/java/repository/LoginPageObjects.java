package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	WebDriver driver;
public LoginPageObjects(WebDriver driver){
	this.driver=driver;
	
}
By userName=By.id("user_email");
By password=By.name("user[password]");
By login=By.name("commit");

public WebElement userID(){
	return driver.findElement(userName);
}
public WebElement Password(){
	return driver.findElement(password);

}
public WebElement loginButton(){
	return driver.findElement(login);
}
}
