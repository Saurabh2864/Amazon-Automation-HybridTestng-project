package regression_Testing;

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

public class TC002_Verify_All_Menu  extends BaseClass{

	@Test (priority=2 ,  groups={"Regression Testing","Master"} )

	@Description("**TC002--> Verify (All) menu perfectly working or not ")
	@Epic("EP00-2")
	@Feature("Feature 2: Verify that all (Menu) option perfectly working or not ")
	@Story("Story: click on all option and after that click on Best "
			+ "seller option and check all the product display or not")

	@Step("1) Login amazon.in website "
			+ "2)Click on all option"
			+ "3)Click on Best seller Option"
			+ "4)Close all option"
			+ "5)Check All the display or not  ")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")


	public void HomePageMenu() throws InterruptedException {

	logger.info("*** Regression Testing- TC002--> Verify (ALL) Menu option testing Started ***");
    WebsiteHomePage WHP=new WebsiteHomePage(driver);
    WHP.clkonmenuOption();
    Thread.sleep(5000);


    logger.info("Click on Best Seller Option");
    WHP.clickonbestsellerOPT();
    Thread.sleep(4000);

    logger.info("Again Click on Menu option");
    WHP.clkonmenuOption();
    Thread.sleep(4000);


    logger.info("Click on Close (Crossmark) Option");
    WHP.closeAllMenu();
    Thread.sleep(4000);

    logger.info("*** Regression Testing- TC002--> Verify (ALL) Menu option Testing End");


}
}












