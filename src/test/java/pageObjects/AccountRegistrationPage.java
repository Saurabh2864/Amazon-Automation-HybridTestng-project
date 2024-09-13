package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	
	}


	//Enter mobile number or email
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement Entermailid;
	
	@FindBy(xpath="//*[@id=\"continue\"]/span/input")
	WebElement clickonContinue;
	
	
	//@FindBy(xpath="//*[@id=\"ap_password\"]")
	//WebElement EnterPassword;
	
	//@FindBy(xpath="//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input")
	//WebElement clickoncheckbox;
	
	//@FindBy(xpath="//*[@id=\"signInSubmit\"]")
	//WebElement clickonsignin;
	
	
	
	
	
	public void Entermailid(String Mailid) {
		Entermailid.sendKeys(Mailid);
	}
	
	public void clickoncontinue() {
		clickonContinue.click();
	}
	
}
	
	
	/*
	public void enterpassword(String Password) {
		EnterPassword.sendKeys(Password);
	}
	
	public void clickonsignin() {
		clickonsignin.click();
	}
	
*/	
	
	

	
		
	/*	
	public String getconfirmationmsg() {
		try {
			return (msgconfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	*/	
	
	
	//@FindBy(xpath="//h3[@class='login__title'= Your account has been created]")
		//WebElement msgconfirmation;

		
		
		/*public void SetUserName(String Username) {
			txtUsername.sendKeys(Username);
		}
		
		public void Password(String Password) {
			txtPassword.sendKeys(Password);
		}
		*/

//@FindBy(id="")

//WebElement txtUsername;

//@FindBy(id="idToken2")
//WebElement txtPassword;

