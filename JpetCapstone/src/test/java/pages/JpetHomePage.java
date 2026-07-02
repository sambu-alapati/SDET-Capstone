package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class JpetHomePage {
	
	WebDriver driver;
	
	public JpetHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By searchbar=By.xpath("//form[contains(@action, 'searchProducts')]//input[@name='keyword']");
	By searchBtn=By.xpath("//button[@id='jpetstore-search-btn']");
	
	
	
	public void searchbar(String text) {
		driver.findElement(searchbar).sendKeys(text);
	}
	
	public void searchBtn() {
		driver.findElement(searchBtn).click();
	}
	
	
	

}
