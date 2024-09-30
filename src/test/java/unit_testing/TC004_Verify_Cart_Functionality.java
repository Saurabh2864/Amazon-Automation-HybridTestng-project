package unit_testing;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import pageObjects.CartFunctionalityPage;
import testBase.BaseClass;

public class TC004_Verify_Cart_Functionality extends BaseClass {

	@Test (priority=4 ,  groups={"Unit Testing","Master"} )

	@Description("**TC004--> Verify Cart functionality")
	@Epic("EP004")
	@Feature("Feature 4: Verify Cart Functionality working or not")
	@Story("Story: Add One Mobile product in the cart and delete the prodcut")
	@Step("1)Login to the Website"
			+ "2)Enter text in search Box Galaxy M35 5G Mobile"
			+ "3)Click on Add cart"
			+ "4)Go to the cart"
			+ "5)Delete the product")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")

	public void CartFunctionality() throws InterruptedException {
		logger.info("***TC004 Cart Functionality Testing Started*****");

		CartFunctionalityPage CFP= new CartFunctionalityPage(driver);

		CFP.clickontextBox();
		Thread.sleep(4000);
		logger.info("Clicked on TextBox");


		CFP.addtextinSearchOpt();
		Thread.sleep(5000);
		logger.info("Text added in Search Option (Galaxy M35 5G Mobile)");

		CFP.ClickonSearchOpt();
		Thread.sleep(4000);
		logger.info("click on Search Option");

		CFP.ClickOnDownOpt();
		Thread.sleep(6000);
		logger.info("Click on down ");

		CFP.ClickonAddCartOpt();
		Thread.sleep(4000);
		logger.info("Click on add cart option");

		CFP.clickoncartOption();
		Thread.sleep(5000);
		logger.info("click on the cart option");

		CFP.clickonDeleteOpt();
		Thread.sleep(4000);
		driver.navigate().back();
		driver.navigate().refresh();

		logger.info("click on delete option");

		logger.info("***TC004 Cart Functionality Testing End *****");



	}





}
