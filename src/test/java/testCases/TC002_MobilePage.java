package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MobilePage;
import testBase.BaseClass;

public class TC002_MobilePage extends BaseClass{
	
	//@SuppressWarnings({ "deprecation", "deprecation" })
	
	
	@Test (priority=2 ,  groups={"SmokeTesting","Master"} )
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


