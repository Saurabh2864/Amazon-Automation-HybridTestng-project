package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MobilePage extends BasePage{



	public MobilePage(WebDriver driver) {
		super(driver);

	}


	//Enter elements (Click on Mobile)
	@FindBy(xpath="//a[contains(text(),'Mobiles')]")
	WebElement clkonMobile;

	@FindBy(xpath="/html")
	WebElement clickdown;

//	@FindBy(name="(\"//h2[normalize-space()='Latest launches in Mobiles & Accessories']\"))")
//	WebElement msgConfirmation;

	//@FindBy(xpath="(\"//h2[normalize-space()='Amazon smartphone stores']\"))")
	//WebElement Verifymsg;

	@FindBy (xpath="//*[@id=\"s-refinements\"]/div[6]/ul/li[6]/span/a/div/label/i")
	WebElement clikonredmi;

	@FindBy(xpath="//*[@id=\"s-refinements\"]/div[6]/ul/li[3]/span/a/div/label/i")
	WebElement clkonsamsungmob;


// Action Methods

	public void clickonMobile() {
		clkonMobile.click();
	}

	public void clickondownarrow() {
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);



	}


	public void clkonRedmiopt() {
		clikonredmi.click();
	}


	public void clkonSamsungopt() {
		clkonsamsungmob.click();
	}

	//validation for confirmation message














/*
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return(e.getMessage());
		}
	}









	public boolean checkmessage() {
		try {
			return(Verifymsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}

	}




	/*
	{
	String actualTitle = driver.getTitle();

    // Expected title
    String expectedTitle = "Mobile Phones";

    // Verify the title
    Assert.assertEquals(actualTitle, expectedTitle, "Title did not match!");
	}

*/
}
