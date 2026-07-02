package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JpetHomePage {
	
	WebDriver driver;
	
	public JpetHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//search bar and search button 
	By searchbar=By.xpath("//form[contains(@action, 'searchProducts')]//input[@name='keyword']");
	By searchBtn=By.xpath("//button[@id='jpetstore-search-btn']");
	
	
	// Account management for changing password 
	By accountIcon=By.xpath("//a[@title='My Account']");
	By myAccount=By.linkText("My Account");
	By password = By.name("password");
	By confirmPassword = By.name("repeatedPassword");
	By saveAccountBtn = By.xpath("//button[contains(text(),'Save Account Information')]");
	
	
	
	
	//image Navigation
	By returntomain=By.linkText("Return to Main Menu");
	By birdimage = By.xpath("//map[@name='estoremap']/area[@alt='Birds']");
	By catimage=By.xpath("//map[@name='estoremap']/area[@alt='Cats']");
	By dogimage=By.xpath("//map[@name='estoremap']/area[@alt='Dogs']");
	By reptileimage=By.xpath("//map[@name='estoremap']/area[@alt='Reptiles']");
	By fishimage=By.xpath("//map[@name='estoremap']/area[@alt='Fish']");
	
	
	
	
	// Reusable private helper method to execute Javascript clicks safely
    private void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    
	
	public void searchbar(String text) {
		driver.findElement(searchbar).sendKeys(text);
	}
	
	public void searchBtn() {
		driver.findElement(searchBtn).click();
	}
	
	
	public void accountIcon() {
		driver.findElement(accountIcon).click();
	}
	
	public void myAccount() {
		driver.findElement(myAccount).click();
	}
	
	public void password(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	
	public void confirmPassword(String confirmpass) {
		driver.findElement(confirmPassword).sendKeys(confirmpass);
	}
	
	
	public void saveAccountBtn() {
		Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(saveAccountBtn)).click().perform();
	}
	
	
	
	// Updated methods to use Javascript execution
	public void birdimage() {
		jsClick(birdimage);
	}
	
    public void fishimage() {
        jsClick(fishimage);
    }
    
    public void dogimage() {
        jsClick(dogimage);
    }
    
    public void reptileimage() {
        jsClick(reptileimage);
    }
    
    public void catimage() {
        jsClick(catimage);
    }
	
	
	public void returntomainmenu() {
		driver.findElement(returntomain).click();
	}

}
