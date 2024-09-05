package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
//below step is mandatory to write in every page object class
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
//add xpath	
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement clkonsignin;		
	
	

//Write Action Method
	
	public void Clickonsignin() {
		clkonsignin.click();
	}
	
	
	
	
}
