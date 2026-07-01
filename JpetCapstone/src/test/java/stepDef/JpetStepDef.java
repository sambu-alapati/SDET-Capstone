package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.JpetLoginPage;

public class JpetStepDef {
	
	WebDriver driver;
	JpetLoginPage jlp;

@Given("the user is on the login page")
public void the_user_is_on_the_login_page() {
    driver=Hooks.driver;
	jlp=new JpetLoginPage(driver);
	
	driver.get("https://jpetstore.aspectran.com/");
	jlp.SignInlink();
}

@When("User enters username {string} password {string}")
public void user_enters_username_password(String username, String password) {
    jlp.username(username);
    jlp.password(password);
}

@When("clicks the login button")
public void clicks_the_login_button() {

	jlp.LoginBtn();
}


boolean isLoginSuccessful = true;


@Then("user should be logged in and see greeting for user {string}")
public void user_should_be_logged_in_and_see_greeting_for_user(String username) {
   

	String expectedGreeting = "Welcome " +username+ "!";
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedGreeting));
	
      String bodyText=driver.findElement(By.tagName("body")).getText();

     if(bodyText.contains("Welcome "+username+"!")) {
	Assert.assertTrue(bodyText.contains("Welcome " + username + "!"));
	isLoginSuccessful = true;
	System.out.println("Valid Credentials :"+username);
      }else {
	Assert.assertTrue("Login Verification Failed! Missing greeting for user: " + username, 
		    bodyText.contains("Welcome " + username + "!"));
	isLoginSuccessful = false;
	System.out.println("InValid Credentials :"+username);
    }

	
  }





@When("the user enters {string} and {string}")
public void the_user_enters_and(String username, String password) {
	 jlp.username(username);
	 jlp.password(password);
    
}

@Then("they should see an error message {string}")
public void they_should_see_an_error_message(String errormsg) {
  
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	// Wait for the body text layout to load completely
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
	
	String bodyText = driver.findElement(By.tagName("body")).getText();
	
	// Assert that the page displays the correct verification validation message
	Assert.assertTrue(bodyText.contains(errormsg));
	System.out.println("Negative Scenario Validation Passed. Error displayed: " + errormsg);	 
	
  }






@When("the user is logged in with valid username {string} and valid password {string}")
public void the_user_is_logged_in_with_valid_username_and_valid_password(String username, String password) {
     jlp.username(username);
     jlp.password(password);
}



@When("user clicks on the account icon and clicks sign out")
public void user_clicks_on_the_account_icon_and_clicks_sign_out() {
    jlp.accountIcon();
    jlp.signoutButton();
}

@Then("user should successfully able to logout")
public void user_should_successfully_able_to_logout() {
   System.out.println("User Successfully Logged Out");
}





}
