package com.HRM.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener

{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext context) 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extentReports/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml"); // load the XML file
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","ADMIN");
		
		htmlReporter.config().setDocumentTitle("Orange HRM Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	

	public void onTestStart(ITestResult result) 
	{
		logger= extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color 	
	}

	public void onTestSuccess(ITestResult result) 
	{
		logger= extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color 
	}

	public void onTestFailure(ITestResult result) 
	{
		logger= extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color 
		
		String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+BaseClass.screenShotName+".png";	
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (Exception e) 
				{
				System.out.println("Unable to locate the file "+e);
				}
		}
	}
		

	public void onTestSkipped(ITestResult result) 
	{
		logger=extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
 
}
