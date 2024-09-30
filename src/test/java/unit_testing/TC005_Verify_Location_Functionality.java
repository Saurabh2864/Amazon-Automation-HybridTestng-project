package unit_testing;

import org.openqa.selenium.WebElement;
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
import pageObjects.WebsiteHomePage;
import testBase.BaseClass;

public class TC005_Verify_Location_Functionality extends BaseClass{

	@Test (priority=5 ,  groups={"Unit Testing","Master"} )

	@Description("**TC005--> Verify zipcode/ Location functionality")
	@Epic("EP005")
	@Feature("Feature 5: Verify Location/Zipcode Functionality working or not")
	@Story("Story: Add One Mobile product in the cart and delete the prodcut")
	@Step("1)Login to the Website"
			+ "2)Enter text in search Box Galaxy M35 5G Mobile"
			+ "3)Click on Add cart"
			+ "4)Go to the cart"
			+ "5)Delete the product")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")


	public void VerifyLocationFunctionality() throws InterruptedException {
		WebsiteHomePage WHP=new WebsiteHomePage(driver);


		logger.info("***TC005 --> Verify location functionality testing started");
		WHP.clikonlocationoption();
       Thread.sleep(5000);

		WHP.clearTextBox();
	       Thread.sleep(5000);
logger.info("textbox cleared");

		WHP.AddZipcode();
	       Thread.sleep(5000);

	       logger.info("Zipcode Added");


		WHP.ClkOnApply();
	       Thread.sleep(5000);

	  logger.info("Click on Apply");
			logger.info("***TC005 --> Verify location functionality testing End");


	}













}
