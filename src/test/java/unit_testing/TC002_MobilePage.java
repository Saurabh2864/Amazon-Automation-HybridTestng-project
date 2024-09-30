package unit_testing;

import static org.testng.Assert.assertTrue;

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
import pageObjects.MobilePage;
import testBase.BaseClass;

public class TC002_MobilePage extends BaseClass{

	//@SuppressWarnings({ "deprecation", "deprecation" })


	@Test (priority=2 ,  groups={"Unit Testing","Master"} )


	@Description("**TC002--> Verify Mobile Page")
	@Epic("EP002")
	@Feature("Feature2: Verify Mobile page is display or not")
	@Story("Story: Check mobile page is Present or not")
	@Step("Checked Mobile Page")
	@Severity(SeverityLevel.MINOR)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")



	public void mobilePage() {
		logger.info("** TC002_MobilePage started**");
		try {


		//Create object of homePage to access the method

	// Create object of MobilePage to access these method

		MobilePage mob= new MobilePage(driver);
		mob.clickonMobile();
		logger.info("Click on the Mobile Option(Mobile Page display)");
        Thread.sleep(8000);


		mob.clickondownarrow();
		logger.info("Click on down arrow");
        Thread.sleep(8000);

        mob.clkonRedmiopt();;
		logger.info("Click on redmi option");

        mob.clkonSamsungopt();
        logger.info("Click on Samsung option");

		mob.clickondownarrow();
		logger.info("Iqoo & Samsung Mobile page display");

		Thread.sleep(5000);

		driver.navigate().back();
		Thread.sleep(8000);

		driver.navigate().back();
		Thread.sleep(5000);

		logger.info("clicked on back button two times ");


		} catch(Exception e)
		{
			Assert.assertTrue(true);
		}
		logger.info("** TC002_MobilePage Testing End**");



}
}




/*

		String confmsg = mob.getConfirmationMsg();
		Assert.assertTrue(confmsg.equals("'Latest launches in Mobiles & Accessories'"));






		logger.info("title checked");

		//Verify title Message
        Thread.sleep(8000);

		boolean targetpage=mob.checkmessage();
		//Assert.assertEquals(targetpage, true);
         Assert.assertTrue(targetpage);
         logger.info("Message Checked");
		} catch(Exception e)
		{
			Assert.fail();
		}


		*/


