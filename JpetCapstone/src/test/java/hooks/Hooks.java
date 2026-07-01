package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	  
    @Before
    public void setup() {
 
        System.out.println("Launching browser...");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @After
    public void tearDown(Scenario scenario) throws InterruptedException
    {
    	//capture the screen shot upon failure
    	
    	if (scenario.isFailed()) {
            try {
                // FIX: Give the browser 1.5 seconds to paint the screen layout before taking the picture
                Thread.sleep(1500);
                
                // Cast the driver to TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                
                // Capture the screenshot as a byte array
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                
                // Embed/Attach the image to the Cucumber HTML report
                scenario.attach(screenshot, "image/png", scenario.getName());
                System.out.println("Screenshot embedded successfully.");
                
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
    	
    	
    	System.out.println("Closing the browser..");
    	Thread.sleep(4000);
    	driver.quit();
    }
    

}
