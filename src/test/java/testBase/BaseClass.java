package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
//ava.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger; //log4j
import org.apache.logging.log4j.LogManager; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.qameta.allure.Allure;
import utilities.VideoRecorder;

import org.openqa.selenium.remote.*;

public class BaseClass {


	public Logger logger;

	public static WebDriver driver;

	public Properties p;

	private VideoRecorder videoRecorder;



	@BeforeMethod
    public void setupMethod(Method method) throws Exception {
        videoRecorder = new VideoRecorder();
        videoRecorder.startRecording(method.getName());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws Exception {
        videoRecorder.stopRecording();
        if (result.getStatus() == ITestResult.FAILURE) {
            // Attach video to Allure report for failed tests
            String videoPath = "./test-recordings/" + result.getName() + ".mp4";
            Allure.addAttachment("Test Failure Video", "video/mp4", new File(videoPath).toURI().toURL().openStream(), "mp4");
            Allure.addAttachment("Test Skipped Video", "video/mp4", new File(videoPath).toURI().toURL().openStream(), "mp4");


        }
    }


	@BeforeClass (groups= {"Unit Testing","Master","SmokeTesting", "Regression Testing"})

	@Parameters({"os", "browser"})



	public void setup(String os, String br) throws IOException{

		//loading config.properties file

		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);


		logger=LogManager.getLogger(this.getClass());

		//below code is used for remote system execution ( also Check config.properties file)
		// Below code is used for Selenium Grid Setup (For Local and Remote Execution

		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities =new DesiredCapabilities();

			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);

			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}

			else
			{
				System.out.println("NO matching os");
				return;
			}

			//browser

			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
            default: System.out.println("No Matching Browser"); return;

			}

			driver= new RemoteWebDriver(new URL("http://192.168.101.76:4444/wd/hub"), capabilities);

		}







		//below code is used to control the browser and OS from xml file
		//below code is used for local system execution

		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{

		switch (br.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge"  : driver=new EdgeDriver(); break;
		case "firefox" : driver= new FirefoxDriver(); break;

		// if you pass invalid browser name

		default: System.out.println("Invalid Browser Name"); return;

		}
	}

		driver.manage().deleteAllCookies();
		//Wait for 10 second
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl")); // reading url from properties file
		driver.manage().window().maximize();

		}

	public String captureScreen(String tname) throws IOException {
//try {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")+ "\\screenshots\\"+ tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);// .png



		sourceFile.renameTo(targetFile);
		return targetFilePath;
}

	@AfterClass (alwaysRun = true, groups= {"Unit Testing","Master","SmokeTesting", "Regression Testing"})
	public void teardown() throws InterruptedException {


		String videoPath = "./test-recordings/";
		//driver.navigate().back();
		//driver.navigate().back();
		//driver.navigate().back();

		// Capture test failure video with Allure if available
		try {
			Allure.addAttachment("Test Failure Video", "video/mp4", new File(videoPath).toURI().toURL().openStream(), "mp4");
			Allure.addAttachment("Test Skipped Video", "video/mp4", new File(videoPath).toURI().toURL().openStream(), "mp4");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Thread.sleep(5000);
        // Quit the driver, which will close all tabs and end the session
        if (driver != null) {
            driver.quit();
        }




	}
	public static WebDriver getDriver() {
	    return driver;
	}





















	//Generate random string(Mailid Password)
/*
		public String randomeString()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}

		/*To generate random number create method
		 *
		 * public string randomnumber() {
		 *
		 * String generatednumber=RandomStringUtils.randomNumeric(10);
			return generatednumber;
		 * }
		 *
		 */


		/*To generate (Number+ string)= Alphanumeric value create one method
		 *
		 * public string randomeAlphanumeric(){
		 * 		String generatedstring=RandomStringUtils.randomAlphabetic(5);
	           String generatednumber=RandomStringUtils.randomNumeric(10);

	            return (generatedstring + generatednumber);
		 *
		 * If you want to add special char then you can add like this
		 *
		 * return (generatedstring + "@"+generatednumber);
		 * }
		 *
		 *
		 */


}
