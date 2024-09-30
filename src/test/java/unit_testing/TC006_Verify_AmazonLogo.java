package unit_testing;

import org.testng.Assert;
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

public class TC006_Verify_AmazonLogo extends BaseClass{

	@Test (priority=5 ,  groups={"Unit Testing","Master"} )

	@Description("**TC006--> Verify Amazon logo functionality")
	@Epic("EP006")
	@Feature("Feature 6: Verify Amazon Logo Functionality working or not")
	@Story("Story: Check amazon logo is displayed or not")
	@Step("1)Login to the Website"
			+ "2)Check logo is displayed or not")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")


	public void verify_Amazon_Logo() {
logger.info("***** TC006_ Verify Amazon Logo Testing Started ****");
		WebsiteHomePage WHP= new WebsiteHomePage(driver);

		WHP.Verifylogo();
		logger.info(" Checked Amazon logo is displayed or not");
       // Assert.assertTrue(false, "Logo not displayed");


        logger.info("****TC006--> Verify Amazon Logo Testing End ****");
	}

}
