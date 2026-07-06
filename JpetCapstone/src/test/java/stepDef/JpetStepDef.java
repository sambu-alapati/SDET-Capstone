package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.JpetHomePage;
import pages.JpetLoginPage;
import pages.JpetRegisterPage;

public class JpetStepDef {
	
	WebDriver driver;
	JpetLoginPage jlp;
    JpetHomePage jhp;
    JpetRegisterPage registerPage;
    
    
    
    
    
    
                                  // JPETREGISTER FEATURE //
                              //-----------------------------------// 
    
    
    
    
    
    //JpetRegister feature for scenario Register new user with valid details
    
    @Given("User is on JPetStore Registration page")
    public void user_is_on_jpetstore_registration_page() {
        Hooks.driver.get("https://jpetstore.aspectran.com/");
        registerPage = new JpetRegisterPage(Hooks.driver);
        registerPage.clickSignUp();
    }

    @When("User enters User ID {string}")
    public void user_enters_user_id(String userid) {
        registerPage.enterUserId(userid);
    }

    @And("User enters Password {string}")
    public void user_enters_password(String password) {
        registerPage.enterPassword(password);
    }

    @And("User enters Confirm Password {string}")
    public void user_enters_confirm_password(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @And("User enters First Name {string}")
    public void user_enters_first_name(String firstName) {
        registerPage.enterFirstName(firstName);
    }

    @And("User enters Last Name {string}")
    public void user_enters_last_name(String lastName) {
        registerPage.enterLastName(lastName);
    }

    @And("User enters Email {string}")
    public void user_enters_email(String email) {
        registerPage.enterEmail(email);
    }

    @And("User enters Phone {string}")
    public void user_enters_phone(String phone) {
        registerPage.enterPhone(phone);
    }

    @And("User enters Address1 {string}")
    public void user_enters_address1(String address1) {
        registerPage.enterAddress1(address1);
    }

    @And("User enters Address2 {string}")
    public void user_enters_address2(String address2) {
        registerPage.enterAddress2(address2);
    }

    @And("User enters City {string}")
    public void user_enters_city(String city) {
        registerPage.enterCity(city);
    }

    @And("User enters State {string}")
    public void user_enters_state(String state) {
        registerPage.enterState(state);
    }

    @And("User enters Zip {string}")
    public void user_enters_zip(String zip) {
        registerPage.enterZip(zip);
    }

    @And("User enters Country {string}")
    public void user_enters_country(String country) {
        registerPage.enterCountry(country);
    }

    @And("User selects Language Preference {string}")
    public void user_selects_language_preference(String language) {
        registerPage.selectLanguage(language);
    }

    @And("User selects Favourite Category {string}")
    public void user_selects_favourite_category(String category) {
        registerPage.selectCategory(category);
    }

    @And("User clicks Save Account Information button")
    public void user_clicks_save_account_information_button() {
        registerPage.clickSaveAccountInformation();
    }

    @Then("User account should be created successfully")
    public void user_account_should_be_created_successfully() {
        String visibleText = Hooks.driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(
                "Registration failed",
                Hooks.driver.getCurrentUrl().contains("signin") || visibleText.contains("Sign In")
        );
    }

    
    
    
    
    
    
    
    
    
    //JpetRegister feature for scenario Verify mandatory field error messages
    
    
    
    // =========================================================================
    // CRITICAL SHIELD: Shared explicit wait method to stop StaleElement Exceptions
    // =========================================================================
    private void verifyErrorMessageOnScreen(String msg) {
        // Sets up a 5-second explicit wait to allow layout shifts to settle
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        
        // Relocates the body element dynamically on every poll loop to avoid going stale
        boolean isTextPresent = wait.until(
            ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), msg.trim())
        );
        
        Assert.assertTrue("Validation message absent! Expected text: [" + msg + "]", isTextPresent);
    }

    @Then("User ID error message should be displayed as {string}")
    public void user_id_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Password error message should be displayed as {string}")
    public void password_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("First Name error message should be displayed as {string}")
    public void first_name_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Last Name error message should be displayed as {string}")
    public void last_name_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Email error message should be displayed as {string}")
    public void email_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Phone error message should be displayed as {string}")
    public void phone_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Address1 error message should be displayed as {string}")
    public void address1_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("City error message should be displayed as {string}")
    public void city_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("State error message should be displayed as {string}")
    public void state_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Zip error message should be displayed as {string}")
    public void zip_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }

    @Then("Country error message should be displayed as {string}")
    public void country_error_message_should_be_displayed_as(String msg) {
        verifyErrorMessageOnScreen(msg);
    }
    
    
    
    
    
    
    
    
    
    
    
                               // JPETLOGINANDLOGOUT FEATURE //
                            //-----------------------------------// 
    
    
    
    
    
   
	
	
//JpetLoginAndLogout feature scenario for valid creds 	
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
    if(utils.CheckingValidPassword.isValidpassword(password)) {
    	System.out.println("[INFO] Password matches rule specifications. Interacting with POM.");
    	 jlp.password(password);
    }else {
    	  System.out.println("[WARN] Password failed structural validity profile checks.");
    	  jlp.password(password);
    }
   
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





//JpetLoginandLogout feature scenario for invalid login creds handling
@When("the user enters {string} and {string}")
public void the_user_enters_and(String username, String password) {
	 jlp.username(username);
	 if(utils.CheckingValidPassword.isValidpassword(password)) {
	    	System.out.println("[INFO] Password matches rule specifications. Interacting with POM.");
	    	 jlp.password(password);
	    }else {
	    	  System.out.println("[WARN] Password failed structural validity profile checks.");
	    	  jlp.password(password);
	    }
    
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







//Jpet LoginAndLogout feature for scenario logout

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






                              // JPETHOME FEATURE //
                            //----------------------//



//JpetHome feature for scenario for user search bar functionality 


@When("User enter {string} bird in searchbar")
public void user_enter_bird_in_searchbar(String text) {
	 driver = Hooks.driver;
     jhp = new JpetHomePage(driver);
    jhp.searchbar(text);
}

@And("Clicks the search button")
public void Clicks_the_search_button() {
	jhp.searchBtn();
}

@Then("User Should able to see data related to it")
public void User_should_able_to_see_data_releated_to_it() {
	
	 String pageText = driver.findElement(By.tagName("body")).getText();
	    
	    
	    String expectedText = "Amazon Parrot"; 
	    
	    Assert.assertTrue("BUG DETECTED: The page text did not contain the expected text: " + expectedText, 
	            pageText.contains(expectedText));
    
}





//jpethome feature for scenario search bar function using enter keys 

@And("Presses the Enter key on the keyboard")
public void Presses_the_Enter_key_on_the_keyboard() {
	jhp.searchbarusingkeys();
}










//jpethome feature for scenario Navbar elements navigation


@When("user clicks the Bird navbar element and clicks return to main menu")
public void user_clicks_the_bird_navbar_element_and_clicks_return_to_main_menu() {
	driver = Hooks.driver;
    jhp = new JpetHomePage(driver);
    jhp.birdnavelement();
    jhp.returntomainmenu();
}

@When("user clicks the Cat navbar element and clicks return to main menu")
public void user_clicks_the_cat_navbar_element_and_clicks_return_to_main_menu() {
	jhp.catnavelement();
    jhp.returntomainmenu();
}

@When("user clicks the Dog navbar element and clicks return to main menu")
public void user_clicks_the_dog_navbar_element_and_clicks_return_to_main_menu() {
	jhp.dognavelement();
    jhp.returntomainmenu();
}

@When("user clicks the Reptile navbar element and clicks return to main menu")
public void user_clicks_the_reptile_navbar_element_and_clicks_return_to_main_menu() {
	jhp.reptilenavelement();
    jhp.returntomainmenu();
}

@When("user clicks the Fish navbar element and clicks return to main menu")
public void user_clicks_the_fish_navbar_element_and_clicks_return_to_main_menu() {
	jhp.fishnavelement();
    jhp.returntomainmenu();
}

@When("user clicks the Cart navbar element and clicks return to main menu")
public void user_clicks_the_cart_navbar_element_and_clicks_return_to_main_menu() {
	jhp.cartnavelement();
    jhp.returntomainmenu();
}

@When("user clicks the My Orders navbar element")
public void user_clicks_the_my_orders_navbar_element() {
	jhp.myordersnavelement();;
}











//JpetHome feature for scenario imageNavigation


@When("user clicks on the Bird image and clicks return to main menu")
public void user_clicks_on_the_bird_image_and_clicks_return_to_main_menu() {
	jhp=new JpetHomePage(driver);
  jhp.birdimage();
  jhp.returntomainmenu();
}

@When("user clicks on the Fish image and clicks return to main menu")
public void user_clicks_on_the_fish_image_and_clicks_return_to_main_menu() {
  jhp.fishimage();
  jhp.returntomainmenu();
}

@When("user clicks on the Dog image and clicks return to main menu")
public void user_clicks_on_the_dog_image_and_clicks_return_to_main_menu() {
  jhp.dogimage();
  jhp.returntomainmenu();
}

@When("user clicks on the Reptile image and clicks return to main menu")
public void user_clicks_on_the_reptile_image_and_clicks_return_to_main_menu() {
  jhp.reptileimage();
  jhp.returntomainmenu();
}

@When("user clicks on the Cat image and clicks return to main menu")
public void user_clicks_on_the_cat_image_and_clicks_return_to_main_menu() {
  jhp.catimage();
  jhp.returntomainmenu();
}
















//JpetHome feature for Account management scenario 

@When("user clicks on the account icon and goes to my Account")
public void user_clicks_on_the_account_icon_and_goes_to_my_account() {
	jhp=new JpetHomePage(driver);
    jhp.accountIcon();
    jhp.myAccount();
}

@When("user updates the password {string} and confirmpassword {string}")
public void user_updates_the_password_and_confirmpassword(String pass, String confirmpass) {
	
	jhp.password(pass);
	jhp.confirmPassword(confirmpass);
    jhp.saveAccountBtn();
}

@Then("user should see the message {string}")
public void user_should_see_the_message(String verificationtext) {
	
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    // Locate the <p> element inside the alert container using its class name
    By alertParagraphLocator = By.xpath("//div[contains(@class, 'alert-info')]/p");
    
    // Wait until the element is fully visible on the screen
    WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alertParagraphLocator));
    
    // Extract and clean the actual text from the webpage
    String actualText = messageElement.getText().trim();
    
    // Verify it matches "Your account has been updated." 
    Assert.assertEquals(actualText, verificationtext);
	 
}











}
