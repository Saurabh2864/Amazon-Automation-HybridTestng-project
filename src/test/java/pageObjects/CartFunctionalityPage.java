package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartFunctionalityPage extends BasePage{

	public CartFunctionalityPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement clkontextBox;

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement addtextinSearchOpt;

	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement clickonSearchOpt;

	@FindBy(xpath="/html")
	WebElement clickdown;

	@FindBy(xpath="//span[@id='nav-cart-count']")
	//span[@id='nav-cart-count']
	WebElement clikonAddCartOpt;

	@FindBy(xpath="//span[normalize-space()='Cart']")
	WebElement clickonCartOpt;

    @FindBy(xpath="//*[@id=\"sc-active-8bcb6fcc-714b-4b90-a836-854023286147\"]/div[4]/div/div[2]/div[1]/span[2]/span/input")
    WebElement clickonDeleteOpt;



    public void clickontextBox(){
    	clkontextBox.click();

    }

    public void addtextinSearchOpt() {
    	addtextinSearchOpt.sendKeys("Galaxy M35 5G Mobile");
    }


    public void ClickonSearchOpt() {
    	clickonSearchOpt.click();
    }

    public void ClickOnDownOpt() {
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

    public void ClickonAddCartOpt() {
    	clikonAddCartOpt.click();
    }

    public void  clickoncartOption() {
    	clickonCartOpt.click();
    }

    public void clickonDeleteOpt() {
    	clickonDeleteOpt.click();
    }















}
