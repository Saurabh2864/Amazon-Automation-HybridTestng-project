package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyProductText extends BasePage {

	public VerifyProductText(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Enter elements (Click on Mobile)
			@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
			WebElement clkonSearch;



		@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
		WebElement SearchLaptop;

		@FindBy (xpath="//*[@id=\"nav-search-submit-button\"]")
		WebElement ClkonSubmit;

		@FindBy(xpath="/html")
		WebElement clickdown;


  @FindBy (xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")
  WebElement ClkonAcerSwiftgo14laptop;






  // ***** ACTION METHODS ************


  public void clickonSearch() {
		clkonSearch.click();
	}

	public void SearchAcerLaptop(){
		SearchLaptop.sendKeys("Acer Swift go 14 oled Core i5 13 gen");
	}

	public void clickonSubmit() {
		ClkonSubmit.click();
	}

	public void clkonDownOpt() throws InterruptedException {
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
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		clickdown.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
	}


	public void ClkonAcerSwiftgo14corei5laptop() {

		ClkonAcerSwiftgo14laptop.click();

	}











}




























