package unit_testing;

import java.lang.System.Logger;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
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
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import org.testng.ITestListener;



public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(priority=1, groups={"Unit Testing","Master"})
	//Below @ is used in allure Reporting


	@Description("**TC001--> Account registration page testing")
	@Epic("EP001")
	@Feature("Feature1: Account Registration")
	@Story("Story: Logo Presence")
	@Step("mail id and password Checked")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")



	public void verify_Account_Registration() throws InterruptedException {
		logger.info("*** TC001--> Account registration page testing started**");
		//Create object of homePage to access the method

		HomePage hp = new HomePage(driver);
		hp.Clickonsignin();
		logger.info("Click on the sign in button");

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		// Create object of AccountregistrationPage to access these method

		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		Thread.sleep(8000);
		regpage.Entermailid("saurabhmirajkar042@gmail.com");
		logger.info("Enter MailId");
	//	regpage.Entermailid(randomeString()+"@gmail.com"); //randomly generated mail id
        Thread.sleep(8000);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		regpage.clickoncontinue();
        Thread.sleep(8000);
        logger.info("Click on the Continue");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//generate password randomly (For Uppercase)
       // regpage.enterpassword(randomeString().toUpperCase());

      //  regpage.enterpassword("Ram2864@.");

        driver.navigate().back();
        Thread.sleep(8000);
        logger.info("click on back button ");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      // regpage.clickonsignin();
        driver.navigate().back();
        Thread.sleep(8000);
        logger.info("Click on the Signin");

		logger.info("*** TC001--> Account registration page testing END **");


	}





}
















// ***********   Explanation    *****************

/*
Sure! Here's a detailed explanation of the annotations you mentioned, commonly used in Allure reporting:

### Annotations in Allure Reporting

1. **@Owner("Saurabh Mirajkar")**
   - **Purpose**: Assigns the test case to a specific owner, typically the person responsible for the test.
   - **Usage**: Helps in identifying who to contact for issues related to the test case.

2. **@Link**
   - **Purpose**: Adds a link to an external resource, such as a requirement or a bug report.
   - **Usage**: `@Link(name = "JIRA-123", url = "http://jira.example.com/browse/JIRA-123")`
   - **Benefit**: Provides quick access to related documentation or issue tracking systems.

3. **@Issue**
   - **Purpose**: Links the test case to a specific issue in an issue tracker.
   - **Usage**: `@Issue("JIRA-123")`
   - **Benefit**: Helps in tracking which tests are related to which issues.

4. **@TmsLink**
   - **Purpose**: Links the test case to a Test Management System (TMS).
   - **Usage**: `@TmsLink("TMS-123")`
   - **Benefit**: Provides a direct link to the test case in the TMS.

5. **@Description**
   - **Purpose**: Adds a detailed description to the test case.
   - **Usage**: `@Description("This test verifies the login functionality.")`
   - **Benefit**: Helps in understanding the purpose and scope of the test case.

6. **@Epic**
   - **Purpose**: Groups test cases under a larger feature or epic.
   - **Usage**: `@Epic("User Management")`
   - **Benefit**: Organizes test cases for better traceability and reporting.

7. **@Feature**
   - **Purpose**: Groups test cases under a specific feature.
   - **Usage**: `@Feature("Login")`
   - **Benefit**: Helps in categorizing test cases based on features.

8. **@Story**
   - **Purpose**: Groups test cases under a specific user story.
   - **Usage**: `@Story("User logs in with valid credentials")`
   - **Benefit**: Provides a clear mapping between user stories and test cases.

9. **@Step**
   - **Purpose**: Adds a step to the test case, making the report more readable.
   - **Usage**: `@Step("Open login page")`
   - **Benefit**: Breaks down the test case into smaller, understandable steps.

10. **@Severity**
    - **Purpose**: Assigns a severity level to the test case.
    - **Usage**: `@Severity(SeverityLevel.CRITICAL)`
    - **Benefit**: Helps in prioritizing test cases based on their importance.

### Missing Annotation

**@Attachment**
- **Purpose**: Attaches files, screenshots, or logs to the test case.
- **Usage**: `@Attachment(value = "Page screenshot", type = "image/png")`
- **Benefit**: Provides additional context and evidence for test results.

These annotations enhance the readability and traceability of your test reports, making it easier to understand and manage your test cases. If you have any more questions or need further details, feel free to ask!

Source: Conversation with Copilot, 19/9/2024
(1) Allure Report Docs — How it works. https://allurereport.org/docs/how-it-works/.
(2) A Conclusive Allure Report Tutorial with Sample Report. https://codoid.com/automation-testing/allure-report-tutorial/.
(3) Allure Report Hands-on Guide - Blog- Qameta.io. https://qameta.io/blog/allure-report-hands-on/.
(4) Allure Report Hands-on Guide - DEV Community. https://dev.to/ruslan_testops/allure-report-hands-on-guide-4m6m.
(5) Allure Reporting: Simplifying Your Test Automation Reports. https://www.dezlearn.com/allure-reporting/.
(6) undefined. http://maven.apache.org/POM/4.0.0.
(7) undefined. http://www.w3.org/2001/XMLSchema-instance.
(8) undefined. http://maven.apache.org/xsd/maven-4.0.0.xsd.

*/


/*	regpage.SetUserName("Saurabh");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

regpage.Password("sau2864");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
*/
