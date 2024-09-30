package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct extends BasePage{


	public SearchProduct(WebDriver driver) {
		super(driver);

	}




	//Enter elements (Click on Mobile)
		@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
		WebElement clkonSearch;



	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	WebElement SearchLaptop;

	@FindBy (xpath="//*[@id=\"nav-search-submit-button\"]")
	WebElement ClkonSubmit;

	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")
	WebElement clkonacerlaptop;

	@FindBy(xpath="/html")
	WebElement clickdown;






		public void clickonSearch() {
			clkonSearch.click();
		}

		public void SearchAcerLaptop(){
			SearchLaptop.sendKeys("Acer Swift go 14 oled Core i5 13 gen");
		}

		public void clickonSubmit() {
			ClkonSubmit.click();
		}

		public void clkonAcerLaptop() {
			clkonacerlaptop.click();
		}

		public void clkonDownOpt() throws InterruptedException {
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			clickdown.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);

		}

}

