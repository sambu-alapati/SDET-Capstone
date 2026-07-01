package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JpetLoginPage {

WebDriver driver;
	
	public JpetLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By SignInlink=By.linkText("Sign In");
	By username=By.name("username");
	By password=By.name("password");
	By LoginBtn=By.xpath("//button[text()='Login']");
	
	
	
	//signout 
	By accountIcon=By.xpath("//a[@title='My Account']");
	By signoutButton=By.linkText("Sign Out");
	
	
	public void SignInlink() {
		driver.findElement(SignInlink).click();
	}
	
	public void username(String uname) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
	}
	
	public void password(String pass) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	
	public void LoginBtn() {
		
		WebElement LoginButton = driver.findElement(LoginBtn);
		
		 Actions actions = new Actions(driver);
	
		 actions.moveToElement(LoginButton).click().perform();
	}
	
	
	
	public void accountIcon() {
		driver.findElement(accountIcon).click();
	}
	
	public void signoutButton() { 
		driver.findElement(signoutButton).click();
	}
	
	
}
