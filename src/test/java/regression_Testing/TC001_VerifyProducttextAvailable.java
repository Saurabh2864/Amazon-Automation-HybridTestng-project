package regression_Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import pageObjects.VerifyProductText;
import testBase.BaseClass;

public class TC001_VerifyProducttextAvailable extends BaseClass{

	@Test (priority=1 ,  groups={"Regression Testing","Master"} )

	@Description("**TC001--> Verify that product text is available or not")
	@Epic("EP00-1")
	@Feature("Feature 1: Verify that Acer laptop product text is displayed or not")
	@Story("Story: Check Acer laptop product text is Present or not")
	@Step("1)Login to the website"
			+ "2)Search Acer Laptop"
			+ "3)All list of product display"
			+ "4)Click on the product "
			+ "5)in a new window product details display"
			+ "6)Verify the Prodct text(Title) ")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Saurabh Mirajkar")
	@Link(name ="Website",url="https://www.amazon.in/")
	@Issue("Auth-123")
	@TmsLink("TMS-456")


	public void VerifyProdutText() throws InterruptedException {
		logger.info("**Regression Testing- TC001--> VerifyProdutText");
		VerifyProductText VPT= new VerifyProductText(driver);
		VPT.clickonSearch();

		 VPT.SearchAcerLaptop();
	        logger.info("Acer Laptop product Searched successfully");
	        Thread.sleep(5000);

	        VPT.clickonSubmit();
	        logger.info("Click on submit Option");
	        Thread.sleep(4000);

	        VPT.clkonDownOpt();
	        logger.info("Click on down ");
	        Thread.sleep(3000);

	        VPT.ClkonAcerSwiftgo14corei5laptop();
	        logger.info("Click on acer swift go 14 oled core i5 laptop");
	        Thread.sleep(4000);


	   //*********** Verify product text availability **************



	       Set<String> windowIDs= driver.getWindowHandles();// capture multiple window id's

	      // List<String> windowList=new ArrayList(windowIDs);// convert set into list collection (for to extract id's individually)

/*
   //Approach 1
	       List<String> windowList=new ArrayList(windowIDs);// convert set into list collection (for to extract id's individually)

	       String parentID = windowList.get(0);
	       String childID =windowList.get(1);

	       //Switch to child window
	       driver.switchTo().window(childID);
	       System.out.println(driver.getTitle());

	       //switch to parent window or main window

	       driver.switchTo().window(parentID);
	       System.out.println(driver.getTitle());
	  */


//Approach  2

	       for (String winID:windowIDs)
	       {
	    	   String title1 = driver.switchTo().window(winID).getTitle();
	    	   if(title1.equals("Amazon.in: Buy Acer Swift Go OLED Display Thin and Light Premium Laptop Intel Core i5 13th Gen (16GB/ 512 GB SSD/Windows 11 Home/MS Office Home and Student) Sunshiny Gold, SFG14-71, 35.56 cm (14.0 Inch) Online at Low Prices in India | Acer Reviews & Ratings")) // change window title
	    	   {
	    		   System.out.println(driver.getCurrentUrl());
	    	   }

	       }

	        String title= driver.getTitle();
	        System.out.println(" Product title:- "  +title);
	        Assert.assertTrue(title.contains("Amazon.in: Buy Acer Swift Go OLED Display Thin and Light Premium Laptop Intel Core i5 13th Gen (16GB/ 512 GB SSD/Windows 11 Home/MS Office Home and Student) Sunshiny Gold, SFG14-71, 35.56 cm (14.0 Inch) Online at Low Prices in India | Acer Reviews & Ratings"));
            driver.switchTo().defaultContent();
logger.info("Regression Testing TC001--> Verify producttext available test is closed");

            //based on window title to close the window
Thread.sleep(5000);
            for (String winid:windowIDs)
            {
            	String title1 =driver.switchTo().window(winid).getTitle();
            	System.out.println(title1);

            	if(title.equals("Amazon.in: Buy Acer Swift Go OLED Display Thin and Light Premium Laptop Intel Core i5 13th Gen (16GB/ 512 GB SSD/Windows 11 Home/MS Office Home and Student) Sunshiny Gold, SFG14-71, 35.56 cm (14.0 Inch) Online at Low Prices in India | Acer Reviews & Ratings"))
            	{
            		driver.close();
            	}

            	Thread.sleep(5000);

            }


	}
}




/*
	        String expectedText = "Acer Swift Go OLED Display Thin and Light Premium Laptop Intel Core i5 13th Gen (16GB/ 512 GB SSD/Windows 11 Home/MS Office Home and Student) Sunshiny Gold, SFG14-71, 35.56 cm (14.0 Inch)";

	        // Assuming `actualText` is retrieved properly from VPT.VerifyProducttext(), let's proceed to comparison
	        Object actualText = null; // Replace with actual text retrieval logic

	        try {
	            // Verify if the text is present and matches the expected text
	            System.out.println(actualText != null && actualText.equals(expectedText)
	                ? "Text is present and matches: " + actualText
	                : "Text mismatch. Expected: " + expectedText + " but found: " + actualText);
	        } catch (Exception e) {
	            System.out.println("Text not found on the page.");
	            e.printStackTrace();
	        }



	}
}


*/





	        /*

	        VPT.VerifyProducttext();

	        String expectedText = "Acer Swift Go OLED Display Thin and Light Premium Laptop Intel Core i5 13th Gen "
	        		+ "(16GB/ 512 GB SSD/Windows 11 Home/MS Office Home and Student) Sunshiny Gold, SFG14-71, 35.56 cm (14.0 Inch)";


	     // Verify if the text is present and matches the expected text
            Object actualText = null;
            try {
			if (actualText.equals(expectedText)) {
                System.out.println("Text is present and matches: " + actualText);
            } else {
                System.out.println("Text mismatch. Expected: " + expectedText + " but found: " + actualText);
            }

        } catch(Exception e) {
            // If the element or text isn't found, log an error
            System.out.println("Text not found on the page.");
            e.printStackTrace();
        }



	}


	*/














