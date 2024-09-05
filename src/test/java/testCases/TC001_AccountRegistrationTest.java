package testCases;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(priority=1, groups={"UnitTesting","Master"})
	public void verify_Account_Registration() throws InterruptedException {
		logger.info("*verify_Account_Registration**");
		//Create object of homePage to access the method
		
		HomePage hp = new HomePage(driver);
		hp.Clickonsignin();
		logger.info("Click on the sign in button");
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		// Create object of AccountregistrationPage to access these method
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
	
		regpage.Entermailid("saurabhmirajkar042@gmail.com");
		logger.info("Enter MailId");
	//	regpage.Entermailid(randomeString()+"@gmail.com"); //randomly generated mail id
        Thread.sleep(8000);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		regpage.clickoncontinue();
        Thread.sleep(8000);
        logger.info("Click on the Continue");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//generate password randomly (For Uppercase)
       // regpage.enterpassword(randomeString().toUpperCase());
        
        regpage.enterpassword("Ram2864@.");
        Thread.sleep(8000);
        logger.info("Enter Password");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       regpage.clickonsignin();
        Thread.sleep(8000);
        logger.info("Click on the Signin");
        
        
		
	}
	
	
	
	

}




/*	regpage.SetUserName("Saurabh");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

regpage.Password("sau2864");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
*/
