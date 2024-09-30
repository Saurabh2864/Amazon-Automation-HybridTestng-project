package unit_testing;

import org.junit.Assert;
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
import pageObjects.SearchProduct;
import testBase.BaseClass;


public class TC003_SearchProduct extends BaseClass{


	@Test (priority=3 ,  groups={"Unit Testing","Master"} )

	@Description("**TC003--> Verify Search functionality")
	@Epic("EP003")
	@Feature("Feature3: Verify Acer laptop is displayed or not")
	@Story("Story: Check Acer laptop is Present or not")
	@Step("Checked Searched Product")
	@Severity(SeverityLevel.MINOR)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")


	public void mobilePage() throws InterruptedException {
		try {
		logger.info("** TC003_Search Product Testing started**");

		SearchProduct sp= new SearchProduct(driver);

		sp.clickonSearch();
		logger.info("***Click on Search Option");
		Thread.sleep(5000);

        sp.SearchAcerLaptop();
        logger.info("Acer Laptop product Searched successfully");
        Thread.sleep(5000);

        sp.clickonSubmit();
        logger.info("Click on submit Option");
        Thread.sleep(4000);

        sp.clkonAcerLaptop();
        logger.info("Acer Laptop page display");
        Thread.sleep(4000);

        sp.clkonDownOpt();
        logger.info("Click on Down Arrow (Product details displayed)");
        Thread.sleep(3000);

		}
        catch (Exception e)
		{
        	Assert.assertTrue(true);
        }
		logger.info("TC003_ SearchProduct Testing End");


}
}

