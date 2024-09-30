package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WebsiteHomePage extends BasePage{

	public WebsiteHomePage(WebDriver driver) {
		super(driver);

	}



	@FindBy(xpath="//a[@id='nav-hamburger-menu']")
    WebElement clkonAllOpt;


	@FindBy(xpath="//*[@id=\"hmenu-content\"]/ul[1]/li[2]/a")
	WebElement clkonBestselleropt;

	@FindBy (xpath="//div[@class='nav-sprite hmenu-close-icon']")
	WebElement clikoncloseMenue;


	//  ***  Verify deliver to or location functionality ***

	@FindBy(xpath="//*[@id=\"glow-ingress-line2\"]")
	WebElement clikonlocationopt;

	@FindBy(xpath="//h4[@id='a-popover-header-1']")
    WebElement enterintotheframe;


	@FindBy (xpath="//*[@id=\"GLUXZipUpdateInput\"]")
	WebElement clkonTextBox;

	@FindBy (xpath="//*[@id=\"GLUXZipUpdateInput\"]")
	WebElement clearTextBox;

	@FindBy(xpath="//*[@id=\"GLUXZipUpdateInput\"]")
	WebElement AddZipcode;

	@FindBy(xpath="//*[@id=\"GLUXZipUpdate\"]/span/input")
	WebElement ClkOnApply;

// **** Verify logo is present or not  *****

@FindBy(id="nav-logo-sprites")
WebElement verifylogo;




public void clkonmenuOption() {
	clkonAllOpt.click();
}

public void clickonbestsellerOPT() {
	clkonBestselleropt.click();
}

public void closeAllMenu() {
	clikoncloseMenue.click();
}







//  ***  Verify deliver to/ location  functionality ***

public void clikonlocationoption() {
	clikonlocationopt.click();
}

public void enterintotheframe() {
	driver.switchTo().frame("enterintotheframe");
}

public void clkonTextBox() {
	clkonTextBox.click();
}

public void clearTextBox() {
	clearTextBox.clear();
}

public void AddZipcode() {
	AddZipcode.sendKeys("422105");
}

public void ClkOnApply() {
	ClkOnApply.click();
}


//**** Verify logo is present or not  *****

public void Verifylogo() {
	verifylogo.isDisplayed();
	try {
	if (verifylogo.isDisplayed()) {
        System.out.println("Logo is displayed.");
    } else {
        System.out.println("Logo not present.");
    }
} catch (Exception e) {
    // If logo is not found or any other exception occurs
    System.out.println("Logo not present.");
    Assert.fail("Logo not found on the page.");
}

}
}








