

package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.FileInputStream;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.InputStream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Allure;
import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

    private List<ITestResult> allTestResults = new ArrayList<>();


    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

    private VideoRecorder videoRecorder;

    public void onStart(ITestContext testContext) {


        // ... (keep the existing onStart method as is)
       String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		repName = "Test-Report-" + timeStamp + ".html" ;

		sparkReporter =new ExtentSparkReporter(".\\reports\\" + repName); // specify location of the report


		sparkReporter.config().setDocumentTitle("Amazon Automation Testing Report"); //Title of the report

		sparkReporter.config().setReportName("Amazon Functional Testing"); // Name of the report

		sparkReporter.config().setTheme(Theme.STANDARD); //Dark theme used

		//Project Specific details

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Amazon Website");
		extent.setSystemInfo("Module", "Functionality Testing");
		//extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("User Name", System.getProperty("user.name")); //display tester Name
		extent.setSystemInfo("Environment", "QA");

		//Below code is used to:- Capture the parameter from the XML File dynamically


		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);


		// to Display  the Group Info in the Report

		List<String>  includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty());{
			extent.setSystemInfo("Groups", includedGroups.toString());

			videoRecorder = new VideoRecorder();

		}
	}

    public void onTestStart(ITestResult result) {
        try {
            videoRecorder.startRecording(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     public void onTestSuccess(ITestResult result) {
        // ... (keep the existing onTestSuccess method as is)

    	test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //To display groups in reports
		test.log(Status.PASS, result.getName()+"got successfully executed");

	//	allTestResults.add(result);

		try {
            videoRecorder.stopRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }

}

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, result.getName() + " got Failed");
        test.log(Status.INFO, result.getThrowable().getMessage());


     //   allTestResults.add(result);


        // Attach screenshot to Extent report and Allure report
        try {
            String imgPath = captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
            attachScreenshotToAllure(imgPath);  // Attach screenshot to Allure
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // Stop video recording
        try {
            videoRecorder.stopRecording();  // Ensure the recording is stopped
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Attach video to Allure report
        String videoPath = "./test-recordings/" + result.getName() + ".mp4";  // Make sure the path is correct
        File videoFile = new File(videoPath);
       // String videoPath = "./test-recordings/" + result.getName() + ".mp4"; // Ensure path is valid

        if (videoFile.exists()) {
            System.out.println("Video found at: " + videoFile.getAbsolutePath());
            try {
                attachVideoToAllure(videoFile);  // Attach the video
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Video file not found: " + videoFile.getAbsolutePath());
        }
    }


    public void attachVideoToAllure(File videoFile) throws IOException {
        try (InputStream videoStream = new FileInputStream(videoFile)) {
            // Attach the video file as a stream to Allure report
            Allure.addAttachment("Test Video", "video/mp4", videoStream, "mp4");
        } catch (IOException e) {
            throw new IOException("Failed to attach video to Allure report: " + e.getMessage(), e);
        }
    }


    private void attachScreenshotToAllure(String imgPath) throws IOException {
       Allure.addAttachment("Screenshot", "image/png", FileUtils.openInputStream(new File(imgPath)), "png");
      // Allure.addAttachment("Test Failure Video", "video/mp4", new File(videoPath).toURI().toURL().openStream(), "mp4");

    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) BaseClass.driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }

   public void onTestSkipped(ITestResult result) {
        // ... (keep the existing onTestSkipped method as is)


    	test= extent.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
    	test.log(Status.SKIP, result.getName()+"Got Skipped");
    	test.log(Status.INFO, result.getThrowable().getMessage());


    	// allTestResults.add(result);


    	// Stop video recording
        try {
            videoRecorder.stopRecording();  // Ensure the recording is stopped
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Attach video to Allure report
        String videoPath = "./test-recordings/" + result.getName() + ".mp4";  // Make sure the path is correct
        File videoFile = new File(videoPath);
       // String videoPath = "./test-recordings/" + result.getName() + ".mp4"; // Ensure path is valid

        if (videoFile.exists()) {
            System.out.println("Video found at: " + videoFile.getAbsolutePath());
            try {
                attachVideoToAllure(videoFile);  // Attach the video
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Video file not found: " + videoFile.getAbsolutePath());
        }
    }


/*
   private void attachVideoToAllure(String videoPath) throws IOException {
	    Allure.addAttachment("Skipped Test Video", "video/avi", new FileInputStream(new File(videoPath)), "avi");
   }
   */

   public void attachVideoToAllure1(File videoFile) throws IOException {
       try (InputStream videoStream = new FileInputStream(videoFile)) {
           // Attach the video file as a stream to Allure report
           Allure.addAttachment("Skipped Video", "video/mp4", videoStream, "mp4");
       } catch (IOException e) {
           throw new IOException("Skipped to attach video to Allure report: " + e.getMessage(), e);
       }
   }





    public void onFinish(ITestContext testContext) {
        // ... (keep the existing onFinish method as is)

    	extent.flush();
    	// Generate PDF report
    //    PDFReportGenerator pdfGenerator = new PDFReportGenerator("TestReport.pdf");
      //  pdfGenerator.createPDF(allTestResults);


    	    if (testContext != null) {
    	        try {
    	            PDFReportGenerator pdfReportGenerator = new PDFReportGenerator();
    	            pdfReportGenerator.generatePDFReport(testContext);  // Pass context properly
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	    } else {
    	        System.err.println("Test context is null!");
    	    }
    	}




    	// Optionally, open the PDF report automatically after it's generated.

        String pathOfPDFReport = System.getProperty("user.dir") + "\\PDF-Report\\ Amazon Website Selenium-java Automation Testing Report"
                                 + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".pdf";
        File pdfReport = new File(pathOfPDFReport);

    	String pathOfExtentReport = System.getProperty("user.dir")+ "\\reports\\" + repName;
    	File extentReport = new File(pathOfExtentReport);

    	{

    	try {
    	    if (extentReport.exists()) {
    	        Desktop.getDesktop().browse(extentReport.toURI());  // Open the report in the browser
    	    } else {
    	        System.out.println("Report file not found: " + pathOfExtentReport);
    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
  }
    }












//  @Attachment(value = "Screenshot", type = "image/png")
// public byte[] attachScreenshotToAllureReport(String imgPath) throws IOException {
  //   return FileUtils.readFileToByteArray(new File(imgPath));



//private void attachScreenshotToAllure1(String imgPath) throws IOException {
//    Allure.addAttachment("Screenshot", "image/png", FileUtils.openInputStream(new File(imgPath)), "png");




/*  public void attachVideoToAllure(String videoPath) throws IOException {
   File videoFile = new File(videoPath);
   if (videoFile.exists()) {
       try (InputStream videoStream = new FileInputStream(videoFile)) {
           Allure.addAttachment("Test Video", "video/mp4", videoStream, "mp4");
       }
   } else {
       System.err.println("Video file not found at path: " + videoPath);
   }
}

*/


// private void attachVideoToAllure(String videoPath) throws IOException {
 // Allure.addAttachment("Failure Video", "video/avi", FileUtils.openInputStream(new File(videoPath)), "avi");









/*
try {
    PDFReportGenerator pdfReportGenerator = new PDFReportGenerator();
    ITestContext context = null;
	pdfReportGenerator.generatePDFReport(context);
} catch (IOException e) {
    e.printStackTrace();
}
*/



/*
    	try {
    		Desktop.getDesktop().browse(extentReport.toURI());
    	}catch (IOException e) {
    		e.printStackTrace();
    	}

    	*/








/*
@Override
public void onTestFailure(ITestResult result) {
    test = extent.createTest(result.getTestClass().getName());
    test.assignCategory(result.getMethod().getGroups());

    test.log(Status.FAIL, result.getName() + " got Failed");
    test.log(Status.INFO, result.getThrowable().getMessage());




    try {
        String imgPath = captureScreen(result.getName());
        test.addScreenCaptureFromPath(imgPath);

        // Attach screenshot to Allure report
        attachScreenshotToAllure(imgPath);
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    // Stop video recording and attach to Allure report
    try {
		videoRecorder.stopRecording();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



    String videoPath = "./test-recordings/" + result.getName() + ".mp4";
    File videoFile = new File(videoPath);


    if (videoFile.exists()) {
        System.out.println("Video found at: " + videoFile.getAbsolutePath());
    } else {
        System.err.println("Video file not found: " + videoFile.getAbsolutePath());
    }

 /*   try {
		attachVideoToAllure(videoPath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  // Attach video to Allure report

*/




//test.addScreenCaptureFromPath("./test-recordings/" + result.getName() + ".avi");



























































/*package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	public void onStart(ITestContext testContext) {
		/*
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentdatetimestamp =df.format(dt);
		*/

		/*
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		repName = "Test-Report-" + timeStamp + ".html" ;

		sparkReporter =new ExtentSparkReporter(".\\reports\\" + repName); // specify location of the report


		sparkReporter.config().setDocumentTitle("Amazon Automation Testing Report"); //Title of the report

		sparkReporter.config().setReportName("Amazon Functional Testing"); // Name of the report

		sparkReporter.config().setTheme(Theme.STANDARD); //Dark theme used

		//Project Specific details

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Amazon Website");
		extent.setSystemInfo("Module", "Functionality Testing");
		//extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("User Name", System.getProperty("user.name")); //display tester Name
		extent.setSystemInfo("Environment", "QA");

		//Below code is used to:- Capture the parameter from the XML File dynamically


		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);


		// to Display  the Group Info in the Report

		List<String>  includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty());{
			extent.setSystemInfo("Groups", includedGroups.toString());

		}
	}

	*/

	//@Attachment //this is used to attach screenshot in allure report
	/*
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment
	public File saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

*/

/*
	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //To display groups in reports
		test.log(Status.PASS, result.getName()+"got successfully executed");

	}

	 @Override
	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());

	        test.log(Status.FAIL, result.getName() + " got Failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            String imgPath = new BaseClass().captureScreen(result.getName());
	            test.addScreenCaptureFromPath(imgPath);

	            // Attach screenshot to Allure report
	            Allure.addAttachment("Screenshot", new String(((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES)));
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }


	 */


	/*
	//@Attachment(value = "Screenshot on Failure", type = "image/png")

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName()+"got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());


		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromBase64String(imgPath);
			//test.addScreenCaptureFromBase64String(imgPath);

	//  Capture and add screenshot in Allure report

		attachScreenshotToAllure(imgPath);

		}catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	// Method to attach the screenshot in Allure report
	@Attachment(value = "Screenshot on Failure", type = "image/png")
	public byte[] attachScreenshotToAllure(String filePath) {
	    try {
	        // Read the file and convert it to byte[]
	        FileInputStream screenshotStream = new FileInputStream(filePath);
	        return screenshotStream.readAllBytes();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new byte[0];
	    }
	}

	*/

	/*

	//@Attachment //this is used to attach screenshot in allure report

public void onTestSkipped(ITestResult result) {

	test= extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.SKIP, result.getName()+"Got Skipped");
	test.log(Status.INFO, result.getThrowable().getMessage());

}
	//@Attachment //this is used to attach screenshot in allure report

public void onFinish(ITestContext testContext) {

	extent.flush();

	String pathOfExtentReport = System.getProperty("user.dir")+ "\\reports\\" + repName;
	File extentReport = new File(pathOfExtentReport);

	try {
		Desktop.getDesktop().browse(extentReport.toURI());
	}catch (IOException e) {
		e.printStackTrace();
	}

*/

	/*


	// to sent the Report Automatically by using mail


  try {

	  URL url = new URL ("file:///" +System.getProperty("user.dir")+"\\reports\\" + repName);

	  //Create the Email message



	  ImageHtmlEmail email = new ImageHtmlEmail();

	  email.setDataSourceResolver((DataSourceResolver) new DataSourceUrlResolver(url));

	  email.setHostName("smtp.googlemail.com");

	  email.setSmtpPort(465);

	  email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com", "password"));

	  email.setSSLOnConnect(true);

	  email.setFrom("pavanoltraining@gmail.com"); //Sender

	  email.setSubject("Test Results");

	  email.setMsg("Please find Attached Report....");

	  email.addTo("pavankumar.busyqa@gmail.com"); //Receiver email.attach(url, "extent report", "please check report...");

	  email.send(); // send the email

	  } catch(Exception e)

	  { e.printStackTrace();

	  }



	*/







