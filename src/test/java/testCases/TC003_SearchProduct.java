package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchProduct;
import testBase.BaseClass;

public class TC003_SearchProduct extends BaseClass{
	
	
	@Test (priority=3 ,  groups={"SmokeTesting","Master"} )
	public void mobilePage() throws InterruptedException {
		try {
		logger.info("** TC003_Search Product started**");
		
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
        	Assert.assertTrue(false);
        }
		logger.info("TC003_ SearchProduct Testing End");
		
	
}
}

